package edu.asu.lib.mods;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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

import edu.asu.lib.jaxb.JaxbDocument;
import gov.loc.mods.v3.ModsType;

@XmlRootElement(name="mods", namespace=ModsDocument.MODS_SCHEMA_NAMESPACE)
public class ModsDocument extends ModsElementContainer implements JaxbDocument {
    
    private static JAXBContext jaxbContext;
    private static Schema schema;
    public static final String MODS_SCHEMA_URL = "http://www.loc.gov/standards/mods/v3/mods-3-3.xsd";
    public static final String MODS_SCHEMA_NAMESPACE = "http://www.loc.gov/mods/v3";
    public static final String MODS_SCHEMA_LOCATION = String.format("%s %s", MODS_SCHEMA_NAMESPACE, MODS_SCHEMA_URL);
    public static final Logger log = LoggerFactory.getLogger(ModsDocument.class);
    
    private final ModsType modsType;
    private final List<Object> root;
    
    static {
    	try {
    		jaxbContext = JAXBContext.newInstance("gov.loc.mods.v3");
    	} catch (JAXBException e) {
			throw new RuntimeException("Failed to create the JAXB context for ModsDocument", e);
		}
		SchemaFactory sfact = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		InputStream schemaStream = ModsDocument.class.getResourceAsStream("/mods-3-3.xsd");
		if (schemaStream != null) {
			log.debug("Loading schema from stream.");
			try {
				schema = sfact.newSchema(new StreamSource(schemaStream));
			} catch (SAXException e) {
				log.debug("Failed to parse schema from stream.", e);
			}
		}
		
		if (schema == null) {
			try {
				log.debug("Loading schema from URL: {}.", MODS_SCHEMA_URL);
				schema = sfact.newSchema(new URL(MODS_SCHEMA_URL));
				log.debug("Loaded schema from URL: {}.", MODS_SCHEMA_URL);
			} catch (MalformedURLException e1) {
				log.debug("The MODS_SCHEMA_URL " + MODS_SCHEMA_URL + " is bad.", e1);
				schema = null;
			} catch (SAXException e2) {
				log.debug("Failed to parse schema from stream.", e2);
				schema = null;
			}
		}
		
    }
    
    public ModsDocument() {
    	modsType = modsFactory.createModsType();
        root = modsType.getModsGroup();
    }

    public Schema getSchema() {
    	return schema;
    }
    
    @Override
    protected List<Object> getModsGroup() {
    	return root;
    }

	public JAXBContext getContext() {
		return jaxbContext;
	}

	public Object getRootElement() {
		return modsType;
	}

	public String getSchemaLocation() {
		return MODS_SCHEMA_LOCATION;
	}
}
