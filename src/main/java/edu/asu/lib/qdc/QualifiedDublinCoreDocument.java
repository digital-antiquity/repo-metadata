package edu.asu.lib.qdc;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.lang.time.DateFormatUtils;
import org.dataone.ns.metadata.schema.onedcx.v1.DcTermsType;
import org.dataone.ns.metadata.schema.onedcx.v1.OtherElementsType;
import org.dataone.ns.metadata.schema.onedcx.v1.SimpleDcType;
import org.purl.dc.elements._1.SimpleLiteral;
import org.purl.dc.terms.Box;
import org.purl.dc.terms.ISO6392;
import org.purl.dc.terms.ObjectFactory;
import org.purl.dc.terms.W3CDTF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import edu.asu.lib.jaxb.JaxbDocument;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "metadata", namespace = QualifiedDublinCoreDocument.DC_SCHEMA_NAMESPACE)
@XmlType(propOrder = {
        "simpleDc",
        "dcTerms",
        "otherElements"
})
public class QualifiedDublinCoreDocument implements JaxbDocument {
    ObjectFactory of = new ObjectFactory();

    private static JAXBContext context;
    private static Schema schema;

    public static final String DC_SCHEMA_NAMESPACE = "http://ns.dataone.org/metadata/schema/onedcx/v1.0";
    public static final String DC_SCHEMA_URL = "http://ns.dataone.org/metadata/schema/onedcx/v1.0/onedcx_v1.0.xsd";
    public static final String DC_SCHEMA_LOCATION = String.format("%s %s", DC_SCHEMA_NAMESPACE, DC_SCHEMA_URL);
    public static final String DC_NAMESPACE = "http://purl.org/dc/elements/1.1/";

    private static final Logger log = LoggerFactory.getLogger(QualifiedDublinCoreDocument.class);

    static {
        try {
            context = JAXBContext.newInstance(QualifiedDublinCoreDocument.class, org.dataone.ns.metadata.schema.onedcx.v1.ObjectFactory.class,
                    ObjectFactory.class, org.purl.dc.terms.ObjectFactory.class);
        } catch (JAXBException e) {
            throw new RuntimeException("Failed to create the JAXB context for DublinCoreDocument", e);
        }
        SchemaFactory sfact = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        InputStream schemaStream = QualifiedDublinCoreDocument.class.getResourceAsStream("/onedcx_v1.0.xsd");

        if (schemaStream != null) {
            try {
                schema = sfact.newSchema(new StreamSource(schemaStream));
            } catch (SAXException e) {
                log.debug("Failed to parse schema.", e);
            }
        }
        if (schema == null) {
            try {
                schema = sfact.newSchema(new URL(DC_SCHEMA_URL));
            } catch (SAXException e1) {
                log.debug("Failed to parse schema.", e1);
                schema = null;
            } catch (MalformedURLException e1) {
                log.debug("The DC_SCHEMA_URL " + DC_SCHEMA_URL + " is bad.");
                schema = null;
            }
        }
    }

    private SimpleDcType simpleDc;
    private DcTermsType dcTerms;
    private OtherElementsType otherElements;

    public JAXBContext getContext() {
        return context;
    }

    public Schema getSchema() {
        return schema;
    }

    public Object getRootElement() {
        return this;
    }

    public String getSchemaLocation() {
        return DC_SCHEMA_LOCATION;
    }

    public DcTermsType getDcTerms() {
        return dcTerms;
    }

    public void setDcTerms(DcTermsType dcTermsType) {
        this.dcTerms = dcTermsType;
    }

    public SimpleDcType getSimpleDc() {
        return simpleDc;
    }

    public void setSimpleDc(SimpleDcType simpleType) {
        this.simpleDc = simpleType;
    }

    public OtherElementsType getOtherElements() {
        return otherElements;
    }

    public void setOtherElements(OtherElementsType otherElements) {
        this.otherElements = otherElements;
    }

    public void addTitle(String title) {
        guardSimpleDc();
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createTitle(new SimpleLiteral(title)));
    }

    public void addCreator(String creator) {
        guardSimpleDc();
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createCreator(new SimpleLiteral(creator)));
    }

    public void addAccrualMethod(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createAccrualMethod(new SimpleLiteral(value)));
    }

    public void addModified(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createModified(new SimpleLiteral(value)));
    }

    public void addInstructionalMethod(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createInstructionalMethod(new SimpleLiteral(value)));
    }

    public void addIsVersionOf(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createIsVersionOf(new SimpleLiteral(value)));
    }

    public void addIssued(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createIssued(new SimpleLiteral(value)));
    }

    public void addSpatial(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createSpatial(new SimpleLiteral(value)));
    }

    public void addSpatial(String minx, String miny, String maxx, String maxy) {
        guardExtendedDc();
        Box box = new Box();
        box.getContent().add(String.format("northlimit=%s; southlimit=%s; westlimit=%s; eastlimit=%s;", maxy, miny, minx, maxx));
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createSpatial(box));
    }

    public void addIsReplacedBy(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createIsReplacedBy(new SimpleLiteral(value)));
    }

    public void addTemporal(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createTemporal(new SimpleLiteral(value)));
    }

    public void addDate(String value) {
        guardSimpleDc();
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createDate(new SimpleLiteral(value)));
    }

    public void addDate(Date value) {
        W3CDTF w3cdtf = new W3CDTF();
        w3cdtf.getContent().add(DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(value));
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createDate(w3cdtf));
    }

    public void addExtent(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createExtent(new SimpleLiteral(value)));
    }

    public void addRightsHolder(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createRightsHolder(new SimpleLiteral(value)));
    }

    public void addIsFormatOf(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createIsFormatOf(new SimpleLiteral(value)));
    }

    public void addReferences(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createReferences(new SimpleLiteral(value)));
    }

    public void addSubject(String value) {
        guardSimpleDc();
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createSubject(new SimpleLiteral(value)));
    }

    public void addAvailable(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createAvailable(new SimpleLiteral(value)));
    }

    public void addLanguage(String value) {
        guardSimpleDc();
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createLanguage(new SimpleLiteral(value)));
    }

    public void addLanguageISO639_2(String iso639_2) {
        guardSimpleDc();
        ISO6392 iso = new ISO6392();
        iso.getContent().add(iso639_2);
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createLanguage(iso));
    }

    public void addSource(String value) {
        guardSimpleDc();
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createSource(new SimpleLiteral(value)));
    }

    public void addType(String value) {
        guardSimpleDc();
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createType(new SimpleLiteral(value)));
    }

    public void addRelation(String value) {
        guardSimpleDc();
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createRelation(new SimpleLiteral(value)));
    }

    public void addLicense(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createLicense(new SimpleLiteral(value)));
    }

    public void addPublisher(String value) {
        guardSimpleDc();
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createPublisher(new SimpleLiteral(value)));
    }

    public void addAccrualPeriodicity(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createAccrualPeriodicity(new SimpleLiteral(value)));
    }

    public void addConformsTo(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createConformsTo(new SimpleLiteral(value)));
    }

    public void addBibliographicCitation(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createBibliographicCitation(new SimpleLiteral(value)));
    }

    public void addMediator(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createMediator(new SimpleLiteral(value)));
    }

    public void addTableOfContents(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createTableOfContents(new SimpleLiteral(value)));
    }

    public void addDateSubmitted(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createDateSubmitted(new SimpleLiteral(value)));
    }

    public void addDateSubmitted(Date value) {
        W3CDTF w3cdtf = new W3CDTF();
        w3cdtf.getContent().add(DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(value));
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createDateSubmitted(w3cdtf));
    }

    public void addRequires(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createRequires(new SimpleLiteral(value)));
    }

    public void addIdentifier(String value) {
        guardSimpleDc();
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createIdentifier(new SimpleLiteral(value)));
    }

    public void addAudience(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createAudience(new SimpleLiteral(value)));
    }

    public void addHasPart(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createHasPart(new SimpleLiteral(value)));
    }

    public void addCreated(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createCreated(new SimpleLiteral(value)));
    }

    public void addCreated(Date dateCreated) {
        guardExtendedDc();
        W3CDTF w3cdtf = new W3CDTF();
        w3cdtf.getContent().add(DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(dateCreated));
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createCreated(w3cdtf));
    }

    public void addFormat(String value) {
        guardSimpleDc();
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createFormat(new SimpleLiteral(value)));
    }

    public void addIsPartOf(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createIsPartOf(new SimpleLiteral(value)));
    }

    public void addValid(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createValid(new SimpleLiteral(value)));
    }

    public void addIsReferencedBy(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createIsReferencedBy(new SimpleLiteral(value)));
    }

    public void addContributor(String value) {
        guardSimpleDc();
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createContributor(new SimpleLiteral(value)));
    }

    public void addProvenance(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createProvenance(new SimpleLiteral(value)));
    }

    public void addEducationLevel(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createEducationLevel(new SimpleLiteral(value)));
    }

    public void addRights(String value) {
        guardSimpleDc();
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createRights(new SimpleLiteral(value)));
    }

    public void addHasVersion(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createHasVersion(new SimpleLiteral(value)));
    }

    public void addDescription(String value) {
        guardSimpleDc();
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createDescription(new SimpleLiteral(value)));
    }

    public void addDateAccepted(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createDateAccepted(new SimpleLiteral(value)));
    }

    public void addDateAccepted(Date value) {
        W3CDTF w3cdtf = new W3CDTF();
        w3cdtf.getContent().add(DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(value));
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createDateAccepted(w3cdtf));
    }

    public void addMedium(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createMedium(new SimpleLiteral(value)));
    }

    public void addAccrualPolicy(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createAccrualPolicy(new SimpleLiteral(value)));
    }

    public void addDateCopyrighted(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createDateCopyrighted(new SimpleLiteral(value)));
    }

    public void addDateCopyrighted(Date value) {
        W3CDTF w3cdtf = new W3CDTF();
        w3cdtf.getContent().add(DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(value));
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createDateCopyrighted(w3cdtf));
    }

    public void addAccessRights(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createAccessRights(new SimpleLiteral(value)));
    }

    public void addIsRequiredBy(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createIsRequiredBy(new SimpleLiteral(value)));
    }

    public void addCoverage(String value) {
        guardSimpleDc();
        getSimpleDc().getTitleOrCreatorOrSubject().add(of.createCoverage(new SimpleLiteral(value)));
    }

    public void addHasFormat(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createHasFormat(new SimpleLiteral(value)));
    }

    public void addReplaces(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createReplaces(new SimpleLiteral(value)));
    }

    public void addAlternative(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createAlternative(new SimpleLiteral(value)));
    }

    public void addAbstract(String value) {
        guardExtendedDc();
        getDcTerms().getAlternativeOrTableOfContentsOrAbstract().add(of.createAbstract(new SimpleLiteral(value)));
    }

    private void guardSimpleDc() {
        if (getSimpleDc() == null) {
            setSimpleDc(new SimpleDcType());
        }
    }

    private void guardExtendedDc() {
        if (getDcTerms() == null) {
            setDcTerms(new DcTermsType());
        }
    }

}
