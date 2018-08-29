package edu.asu.lib.datacite;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.lang.StringUtils;
import org.datacite.v41.Box;
import org.datacite.v41.ContributorType;
import org.datacite.v41.DateType;
import org.datacite.v41.DescriptionType;
import org.datacite.v41.FunderIdentifierType;
import org.datacite.v41.NameType;
import org.datacite.v41.ObjectFactory;
import org.datacite.v41.RelatedIdentifierType;
import org.datacite.v41.RelationType;
import org.datacite.v41.Resource;
import org.datacite.v41.Resource.AlternateIdentifiers;
import org.datacite.v41.Resource.AlternateIdentifiers.AlternateIdentifier;
import org.datacite.v41.Resource.Contributors;
import org.datacite.v41.Resource.Contributors.Contributor;
import org.datacite.v41.Resource.Contributors.Contributor.ContributorName;
import org.datacite.v41.Resource.Creators;
import org.datacite.v41.Resource.Creators.Creator;
import org.datacite.v41.Resource.Creators.Creator.CreatorName;
import org.datacite.v41.Resource.Creators.Creator.NameIdentifier;
import org.datacite.v41.Resource.Dates;
import org.datacite.v41.Resource.Dates.Date;
import org.datacite.v41.Resource.Descriptions;
import org.datacite.v41.Resource.Descriptions.Description;
import org.datacite.v41.Resource.Formats;
import org.datacite.v41.Resource.FundingReferences;
import org.datacite.v41.Resource.FundingReferences.FundingReference;
import org.datacite.v41.Resource.FundingReferences.FundingReference.AwardNumber;
import org.datacite.v41.Resource.FundingReferences.FundingReference.FunderIdentifier;
import org.datacite.v41.Resource.GeoLocations;
import org.datacite.v41.Resource.GeoLocations.GeoLocation;
import org.datacite.v41.Resource.Identifier;
import org.datacite.v41.Resource.RelatedIdentifiers;
import org.datacite.v41.Resource.RelatedIdentifiers.RelatedIdentifier;
import org.datacite.v41.Resource.ResourceType;
import org.datacite.v41.Resource.RightsList;
import org.datacite.v41.Resource.RightsList.Rights;
import org.datacite.v41.Resource.Sizes;
import org.datacite.v41.Resource.Subjects;
import org.datacite.v41.Resource.Subjects.Subject;
import org.datacite.v41.Resource.Titles;
import org.datacite.v41.Resource.Titles.Title;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import edu.asu.lib.ResourceResolver;
import edu.asu.lib.jaxb.JaxbDocument;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "resource", namespace = DataCiteDocument.SCHEMA_NAMESPACE)
public class DataCiteDocument implements JaxbDocument {
    private static final String DATACITE_SCHEMA_URL = "http://schema.datacite.org/meta/kernel-4.1/metadata.xsd";

    ObjectFactory of = new ObjectFactory();

    private Resource resource;

    private static JAXBContext context;
    private static Schema schema;

    public static final String SCHEMA_NAMESPACE = "http://datacite.org/schema/kernel-4";
    public static final String SCHEMA_URL = "http://ns.dataone.org/metadata/schema/onedcx/v1.0/onedcx_v1.0.xsd";
    public static final String SCHEMA_LOCATION = String.format("%s %s", SCHEMA_NAMESPACE, SCHEMA_URL);
    // public static final String NAMESPACE = "http://purl.org/dc/elements/1.1/";

    private static final Logger log = LoggerFactory.getLogger(DataCiteDocument.class);

    static {
        try {
            context = JAXBContext.newInstance(DataCiteDocument.class, org.datacite.v41.ObjectFactory.class);
        } catch (JAXBException e) {
            throw new RuntimeException("Failed to create the JAXB context for DataCiteDocument", e);
        }
        SchemaFactory sfact = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        sfact.setResourceResolver(new ResourceResolver());

        InputStream schemaStream = DataCiteDocument.class.getResourceAsStream("/datacite-metadata.xsd");

        if (schemaStream != null) {
            try {
                schema = sfact.newSchema(new StreamSource(schemaStream));
            } catch (SAXException e) {
                log.debug("Failed to parse schema.", e);
            }
        }
        if (schema == null) {
            try {
                schema = sfact.newSchema(new URL(DATACITE_SCHEMA_URL));
            } catch (SAXException e1) {
                log.debug("Failed to parse schema.", e1);
                schema = null;
            } catch (MalformedURLException e1) {
                log.debug("The DataCite_SCHEMA_URL " + DATACITE_SCHEMA_URL + " is bad.");
                schema = null;
            }
        }
    }

    public DataCiteDocument() {
        resource = of.createResource();
    }

    public JAXBContext getContext() {
        return context;
    }

    public Schema getSchema() {
        return schema;
    }

    public Object getRootElement() {
        return resource;
    }

    public String getSchemaLocation() {
        return SCHEMA_LOCATION;
    }

    public void addTitle(String title_) {
        Title title = new Title();
        title.setValue(title_);
        if (resource.getTitles() == null) {
            resource.setTitles(new Titles());
        }
        resource.getTitles().getTitle().add(title);
    }

    public void setLanguage(String language) {
        resource.setLanguage(language);
    }

    public void addFormat(String format) {
        if (resource.getFormats() == null) {
            resource.setFormats(new Formats());
        }
        resource.getFormats().getFormat().add(format);
    }

    public void addFundingReference(String title, String funder, FunderIdentifierType identifierType, String identifier, String awardNumber, String uri) {
        if (resource.getFundingReferences() == null) {
            resource.setFundingReferences(new FundingReferences());
        }
        FundingReference funding = new FundingReference();
        AwardNumber number = new AwardNumber();
        number.setAwardURI(uri);
        number.setValue(awardNumber);
        funding.setAwardNumber(number);
        funding.setAwardTitle(title);
        FunderIdentifier funderIdent = new FunderIdentifier();
        funderIdent.setFunderIdentifierType(identifierType);
        funderIdent.setValue(identifier);
        funding.setFunderIdentifier(funderIdent);
        funding.setFunderName(funder);
        resource.getFundingReferences().getFundingReference().add(funding);
    }

    public void addRightsList(String format, String url) {
        if (resource.getRightsList() == null) {
            resource.setRightsList(new RightsList());
        }
        Rights rights = new Rights();
        rights.setValue(format);
        rights.setRightsURI(url);
        resource.getRightsList().getRights().add(rights);
    }

    public void addGeoLocation(Double double1, Double double2, Double double3, Double double4) {
        if (resource.getGeoLocations() == null) {
            resource.setGeoLocations(new GeoLocations());
        }
        GeoLocation loc = new GeoLocation();
        loc.setGeoLocationBox(new Box());;
        loc.getGeoLocationBox().setNorthBoundLatitude(double1.floatValue());
        loc.getGeoLocationBox().setSouthBoundLatitude(double2.floatValue());
        loc.getGeoLocationBox().setEastBoundLongitude(double3.floatValue());
        loc.getGeoLocationBox().setWestBoundLongitude(double4.floatValue());
        resource.getGeoLocations().getGeoLocation().add(loc);
    }

    public void addSize(String format) {
        if (resource.getSizes() == null) {
            resource.setSizes(new Sizes());
        }
        resource.getSizes().getSize().add(format);
    }

    public void setVersion(String value) {
        resource.setVersion(value);
    }

    public void setIdentifier(String identifier) {
        Identifier ident = new Identifier();
        ident.setValue(identifier);
        ident.setIdentifierType("DOI");
        resource.setIdentifier(ident);
    }

    public void addDate(String value, DateType type) {
        Date date = new Date();
        date.setDateType(type);
        date.setValue(value);
        if (resource.getDates() == null) {
            resource.setDates(new Dates());
        }
        resource.getDates().getDate().add(date);
    }

    public void addSubject(String subject, String uri, String scheme, String schemeUri) {
        if (resource.getSubjects() == null) {
            resource.setSubjects(new Subjects());
        }
        Subject sub = new Subject();
        sub.setValue(subject);
        if (StringUtils.isNotBlank(scheme) && StringUtils.isNotBlank(schemeUri)) {
            sub.setSchemeURI(schemeUri);
            sub.setSubjectScheme(scheme);
        }
        if (StringUtils.isNotBlank(uri)) {
            sub.setValueURI(uri);
        }
        resource.getSubjects().getSubject().add(sub);
    }

    public void addIdentifier(String identifier, String type) {
        AlternateIdentifier ident = new AlternateIdentifier();
        ident.setValue(identifier);
        ident.setAlternateIdentifierType(type);
        if (resource.getAlternateIdentifiers() == null) {
            resource.setAlternateIdentifiers(new AlternateIdentifiers());
        }
        resource.getAlternateIdentifiers().getAlternateIdentifier().add(ident);
    }

    public void addRelatedIdentifier(String identifier, RelatedIdentifierType type) {
        RelatedIdentifier ident = new RelatedIdentifier();
        ident.setValue(identifier);
        ident.setRelatedIdentifierType(type);
        ident.setRelationType(RelationType.IS_IDENTICAL_TO);
        if (resource.getRelatedIdentifiers() == null) {
            resource.setRelatedIdentifiers(new RelatedIdentifiers());
        }
        resource.getRelatedIdentifiers().getRelatedIdentifier().add(ident);
    }

    public void addDescription(String text, DescriptionType type) {
        Description description = new Description();
        description.setDescriptionType(type);
        description.getContent().add(text);
        if (resource.getDescriptions() == null) {
            resource.setDescriptions(new Descriptions());
        }
        resource.getDescriptions().getDescription().add(description);
    }

    private void addContributor(Contributor c) {
        if (resource.getContributors() == null) {
            resource.setContributors(new Contributors());
        }
        resource.getContributors().getContributor().add(c);
    }

    public void addPersonalCreator(String firstName, String lastName, String string) {
        Creator c = new Creator();
        CreatorName name = new CreatorName();
        name.setNameType(NameType.PERSONAL);
        name.setValue(firstName + " " + lastName);
        if (StringUtils.isNotBlank(string)) {
            NameIdentifier ident= new NameIdentifier();
            ident.setNameIdentifierScheme("ORCID");
            ident.setValue(string);
            ident.setSchemeURI("http://orcid.org");
            c.getNameIdentifier().add(ident);
        }
        c.setCreatorName(name);
        createCreator(c);
    }

    public void addInstitutionalCreator(String cname) {
        Creator c = new Creator();
        CreatorName name = new CreatorName();
        name.setNameType(NameType.ORGANIZATIONAL);
        name.setValue(cname);
        c.setCreatorName(name);
        createCreator(c);
    }

    public void addPersonalContributor(String firstName, String lastName, ContributorType type) {
        Contributor c = new Contributor();
        ContributorName name = new ContributorName();
        name.setNameType(NameType.PERSONAL);
        name.setValue(firstName + " " + lastName);
        c.setContributorName(name);
        c.setContributorType(type);
        addContributor(c);
    }

    public void addInstitutionalContributor(String cname, ContributorType type) {
        Contributor c = new Contributor();
        ContributorName name = new ContributorName();
        name.setNameType(NameType.PERSONAL);
        name.setValue(cname);
        c.setContributorName(name);
        c.setContributorType(type);
        addContributor(c);
    }

    private void createCreator(Creator c) {
        if (resource.getCreators() == null) {
            Creators value = new Creators();
            resource.setCreators(value);
        }
        resource.getCreators().getCreator().add(c);
    }

    public void setPublisher(String string) {
        resource.setPublisher(string);

    }

    public void setPublicationYear(Integer i) {
        resource.setPublicationYear(i.toString());
    }

    public void setResourceType(org.datacite.v41.ResourceType type) {
        ResourceType rt = new ResourceType();
        rt.setResourceTypeGeneral(type);
        resource.setResourceType(rt);
    }

}