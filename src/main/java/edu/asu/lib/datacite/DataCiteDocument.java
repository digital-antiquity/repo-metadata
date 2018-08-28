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
import javax.xml.bind.annotation.XmlType;
import javax.xml.crypto.Data;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.datacite.v41.NameType;
import org.datacite.v41.ObjectFactory;
import org.datacite.v41.Resource;
import org.datacite.v41.Resource.Creators;
import org.datacite.v41.Resource.Creators.Creator;
import org.datacite.v41.Resource.Creators.Creator.CreatorName;
import org.datacite.v41.Resource.Identifier;
import org.datacite.v41.Resource.ResourceType;
import org.datacite.v41.Resource.Titles;
import org.datacite.v41.Resource.Titles.Title;
import org.datacite.v41.TitleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.ls.LSResourceResolver;
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

    public void setIdentifier(String identifier) {
        Identifier ident = new Identifier();
        ident.setValue(identifier);
        ident.setIdentifierType("DOI");
        resource.setIdentifier(ident);
    }

    public void addPersonalCreator(String firstName, String lastName) {
        Creator c = new Creator();
        CreatorName name = new CreatorName();
        name.setNameType(NameType.PERSONAL);
        name.setValue(firstName + " " + lastName);
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

    public void setResourceType(String string) {
        ResourceType rt = new ResourceType();
        rt.setResourceTypeGeneral(org.datacite.v41.ResourceType.valueOf(string));
        resource.setResourceType(rt);
    }

}