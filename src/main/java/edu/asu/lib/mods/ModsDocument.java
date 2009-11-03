package edu.asu.lib.mods;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import edu.asu.lib.jaxb.JaxbDocument;
import gov.loc.mods.v3.ModsType;

public class ModsDocument extends ModsElementContainer implements JaxbDocument {
    
    private static final JAXBContext jaxbContext;
    private static final Schema schema;
    public static final String MODS_SCHEMA_URL = "http://www.loc.gov/standards/mods/v3/mods-3-3.xsd";
    public static final String MODS_SCHEMA_NAMESPACE = "http://www.loc.gov/mods/v3";
    public static final String MODS_SCHEMA_LOCATION = String.format("%s %s", MODS_SCHEMA_NAMESPACE, MODS_SCHEMA_URL);
    
    private final ModsType modsType;
    private final List<Object> root;
    
    static {
		try {
			jaxbContext = JAXBContext.newInstance("gov.loc.mods.v3");
			SchemaFactory sfact = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			InputStream schemaStream = ModsDocument.class.getResourceAsStream("/mods-3-3.xsd");
			if (schemaStream != null) {
				schema = sfact.newSchema(new StreamSource(schemaStream));
			} else {
				schema = sfact.newSchema(new URL(MODS_SCHEMA_URL));
			}
		} catch (JAXBException e) {
			throw new RuntimeException("Failed to create the JAXB context for ModsDocument", e);
		} catch (SAXException e) {
			throw new RuntimeException("Failed to parse schema.", e);
		} catch (MalformedURLException e) {
			throw new RuntimeException("The MODS_SCHEMA_URL " + MODS_SCHEMA_URL + " is bad.");
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
