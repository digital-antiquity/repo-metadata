package edu.asu.lib.eml;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import edu.asu.lib.dc.DublinCoreDocument;
import edu.asu.lib.jaxb.JaxbDocument;
import eml.ecoinformatics_org.eml_2_1.Eml;
import eml.ecoinformatics_org.eml_2_1.ObjectFactory;

@XmlRootElement(name="eml", namespace=DublinCoreDocument.OAIDC_SCHEMA_NAMESPACE)
public class EMLDocument implements JaxbDocument {

    private static JAXBContext context;
    private static Schema schema;
    
    private static final Logger log = LoggerFactory.getLogger(DublinCoreDocument.class);

    public static final String EML_SCHEMA_NAMESPACE = "eml://ecoinformatics.org/eml-2.1.1";
    public static final String EML_SCHEMA_URL = "eml://ecoinformatics.org/eml-2.1.1 eml.xsd";
    public static final String EML_SCHEMA_LOCATION = String.format("%s %s", EML_SCHEMA_NAMESPACE, EML_SCHEMA_URL);
    public static final String DC_NAMESPACE = "http://purl.org/dc/elements/1.1/";

    static {
        try{
            context = JAXBContext.newInstance(DublinCoreDocument.class);
        } catch (JAXBException e) {
            throw new RuntimeException("Failed to create the JAXB context for EmlDocument", e);
        }
        SchemaFactory sfact = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        InputStream schemaStream = DublinCoreDocument.class.getResourceAsStream("/eml/eml.xsd");
        if (schemaStream != null) {
            try {
                schema = sfact.newSchema(new StreamSource(schemaStream));
            } catch (SAXException e) {
                log.debug("Failed to parse schema.", e);
            }
        }
        if (schema == null) {
            try {
                schema = sfact.newSchema(new URL(EML_SCHEMA_URL));
            } catch (SAXException e1) {
                log.debug("Failed to parse schema.", e1);
                schema = null;
            } catch (MalformedURLException e1) {
                log.debug("The OAIDC_SCHEMA_URL " + EML_SCHEMA_URL + " is bad.");
                schema = null;
            }
        }
    }

        eml.ecoinformatics_org.eml_2_1.ObjectFactory of = new ObjectFactory();
        Eml eml = of.createEml();
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
            return EML_SCHEMA_LOCATION;
        }
        
    }
