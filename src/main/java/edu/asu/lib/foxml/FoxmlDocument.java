package edu.asu.lib.foxml;

import info.fedora.foxml.DigitalObject;
import info.fedora.foxml.ExtpropertyType;
import info.fedora.foxml.ObjectFactory;
import info.fedora.foxml.ObjectPropertiesType;
import info.fedora.foxml.PropertyType;
import info.fedora.foxml.StateType;
import info.fedora.foxml.DigitalObjectType.VersionValue;
import info.fedora.foxml.PropertyType.PropertyTypeName;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import edu.asu.lib.jaxb.JaxbDocument;


public class FoxmlDocument implements JaxbDocument{

	private static final ObjectFactory foxmlFactory = new ObjectFactory();
	private static final JAXBContext jaxbContext;
    private static final Schema schema;
    public static final String FOXML_1_1_FORMAT_URI = "info:fedora/fedora-system:FOXML-1.1";
    public static final String FOXML_SCHEMA_URL = "http://www.fedora-commons.org/definitions/1/0/foxml1-1.xsd";
    public static final String FOXML_SCHEMA_NAMESPACE = "info:fedora/fedora-system:def/foxml#";
    public static final String FOXML_SCHEMA_LOCATION = String.format("%s %s", FOXML_SCHEMA_NAMESPACE, FOXML_SCHEMA_URL);
    
    private DigitalObject foxml;
    
    static {
		try {
			jaxbContext = JAXBContext.newInstance("info.fedora.foxml");
			SchemaFactory sfact = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			InputStream schemaStream = FoxmlDocument.class.getResourceAsStream("/foxml1-1.xsd");
			if (schemaStream != null) {
				schema = sfact.newSchema(new StreamSource(schemaStream));
			} else {
				schema = sfact.newSchema(new URL(FOXML_SCHEMA_URL));
			}
		} catch (JAXBException e) {
			throw new RuntimeException("Failed to create the JAXB context for FoxmlDocument", e);
		} catch (SAXException e) {
			throw new RuntimeException("Failed to parse schema.", e);
		} catch (MalformedURLException e) {
			throw new RuntimeException("The FOXML_SCHEMA_URL " + FOXML_SCHEMA_URL + " is bad.");
		} 
	}
    
    public FoxmlDocument() {
    	foxml = foxmlFactory.createDigitalObject();
    	foxml.setVERSION(VersionValue.OnePointOne);
	}
    
    public void setPid(String pid) {
    	Pattern pattern = Pattern.compile("^([A-Za-z0-9]|-|\\.)+:(([A-Za-z0-9])|-|\\.|~|_|(%[0-9A-F]{2}))+$");
		Matcher match = pattern.matcher(pid);
		if (!match.matches()) 
			throw new IllegalArgumentException("The supplied PID: " + pid + " is malformed.");
    	foxml.setPID(pid);
    }
    
    public void setLabel(String label) {
    	setProperty(PropertyTypeName.INFO_FEDORA_FEDORA_SYSTEM_DEF_MODEL_LABEL, label);
    }
    
    public void setState(StateType state) {
    	String value;
    	switch (state) {
			case A: value = "Active";
			case D: value = "Deleted";
			case I: value = "Inactive";
			default: value = "Active";
		}
    	setProperty(PropertyTypeName.INFO_FEDORA_FEDORA_SYSTEM_DEF_MODEL_STATE, value);
    }
    
    public void setOwnerId(String ownerId) {
    	setProperty(PropertyTypeName.INFO_FEDORA_FEDORA_SYSTEM_DEF_MODEL_OWNER_ID, ownerId);
    }
    
    public void setCreatedDate(Date date) {
    	FedoraDateFormat format = new FedoraDateFormat();
    	setProperty(PropertyTypeName.INFO_FEDORA_FEDORA_SYSTEM_DEF_MODEL_CREATED_DATE, format.format(date));
    }
    
    public void setLastModifiedDate(Date date) {
    	FedoraDateFormat format = new FedoraDateFormat();
    	setProperty(PropertyTypeName.INFO_FEDORA_FEDORA_SYSTEM_DEF_VIEW_LAST_MODIFIED_DATE, format.format(date));
    }
    
    public void setProperty(PropertyTypeName name, String value) {
    	removeProperty(name);
    	PropertyType prop = foxmlFactory.createPropertyType();
    	prop.setNAME(name);
    	prop.setVALUE(value);
    	getObjectProperties().getProperty().add(prop);
    }
    
    private void removeProperty(PropertyTypeName name) {
    	List<PropertyType> props = getObjectProperties().getProperty();
    	for (PropertyType prop : props) {
    		if (prop.getNAME().equals(name)) props.remove(prop);
    	}
    }
    
    public void setExternalProperty(String name, String value) {
    	removeExternalProperty(name);
    	ExtpropertyType prop = foxmlFactory.createExtpropertyType();
    	prop.setNAME(name);
    	prop.setVALUE(value);
    	getObjectProperties().getExtproperty().add(prop);
    }
    
    private void removeExternalProperty(String name) {
    	List<ExtpropertyType> props = getObjectProperties().getExtproperty();
    	for (ExtpropertyType prop : props) {
    		if (prop.getNAME().equals(name)) props.remove(prop);
    	}
    }
    
    public ObjectPropertiesType getObjectProperties() {
    	ObjectPropertiesType op = foxml.getObjectProperties(); 
    	if (op == null) {
    		op = foxmlFactory.createObjectPropertiesType();
    		foxml.setObjectProperties(op);
    	}
    	return op;
    }
    
    public Schema getSchema() {
    	return schema;
    }
	
	public JAXBContext getContext() {
		return jaxbContext;
	}

	public Object getRootElement() {
		return foxml;
	}

	public String getSchemaLocation() {
		return FOXML_SCHEMA_LOCATION;
	}
	
}
