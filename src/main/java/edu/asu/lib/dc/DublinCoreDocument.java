package edu.asu.lib.dc;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import edu.asu.lib.jaxb.JaxbDocument;

@XmlRootElement(name="dc", namespace=DublinCoreDocument.OAIDC_SCHEMA_NAMESPACE)
public class DublinCoreDocument implements JaxbDocument {
	
	private List<String> title;
	private List<String> creator;
	private List<String> subject;
	private List<String> description;
	private List<String> publisher;
	private List<String> contributor;
	private List<String> date;
	private List<String> type;
	private List<String> format;
	private List<String> identifier;
	private List<String> source;
	private List<String> language;
	private List<String> relation;
	private List<String> coverage;
	private List<String> rights;
	
	private static final JAXBContext context;
	private static final Schema schema;
	
	public static final String OAIDC_SCHEMA_NAMESPACE = "http://www.openarchives.org/OAI/2.0/oai_dc/";
	public static final String OAIDC_SCHEMA_URL = "http://www.openarchives.org/OAI/2.0/oai_dc.xsd";
	public static final String OAIDC_SCHEMA_LOCATION = String.format("%s %s", OAIDC_SCHEMA_NAMESPACE, OAIDC_SCHEMA_URL);
	public static final String DC_NAMESPACE = "http://purl.org/dc/elements/1.1/";
	
	static {
		try {
			context = JAXBContext.newInstance(DublinCoreDocument.class);
			SchemaFactory sfact = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			InputStream schemaStream = DublinCoreDocument.class.getResourceAsStream("/oai_dc.xsd");
			if (schemaStream != null) {
				schema = sfact.newSchema(new StreamSource(schemaStream));
			} else {
				schema = sfact.newSchema(new URL(OAIDC_SCHEMA_URL));
			}
		} catch (JAXBException e) {
			throw new RuntimeException("Failed to create the JAXB context for DublinCoreDocument", e);
		} catch (SAXException e) {
			throw new RuntimeException("Failed to parse schema.", e);
		} catch (MalformedURLException e) {
			throw new RuntimeException("The OAIDC_SCHEMA_URL " + OAIDC_SCHEMA_URL + " is bad.");
		}
	}
	
	@XmlElement(name="title", namespace=DC_NAMESPACE)
	public List<String> getTitle() {
		if (title == null) { title = new ArrayList<String>(); }
		return title;
	}
	
	@XmlElement(name="creator", namespace=DC_NAMESPACE)
	public List<String> getCreator() {
		if (creator == null) { creator = new ArrayList<String>(); }
		return creator;
	}

	@XmlElement(name="subject", namespace=DC_NAMESPACE)
	public List<String> getSubject() {
		if (subject == null) { subject = new ArrayList<String>(); }
		return subject;
	}

	@XmlElement(name="description", namespace=DC_NAMESPACE)
	public List<String> getDescription() {
		if (description == null) { description = new ArrayList<String>(); }
		return description;
	}

	@XmlElement(name="publisher", namespace=DC_NAMESPACE)
	public List<String> getPublisher() {
		if (publisher == null) { publisher = new ArrayList<String>(); }
		return publisher;
	}

	@XmlElement(name="contributor", namespace=DC_NAMESPACE)
	public List<String> getContributor() {
		if (contributor == null) { contributor = new ArrayList<String>(); }
		return contributor;
	}

	@XmlElement(name="date", namespace=DC_NAMESPACE)
	public List<String> getDate() {
		if (date == null) { date = new ArrayList<String>(); }
		return date;
	}

	@XmlElement(name="type", namespace=DC_NAMESPACE)
	public List<String> getType() {
		if (type == null) { type = new ArrayList<String>(); }
		return type;
	}

	@XmlElement(name="format", namespace=DC_NAMESPACE)
	public List<String> getFormat() {
		if (format == null) { format = new ArrayList<String>(); }
		return format;
	}

	@XmlElement(name="identifier", namespace=DC_NAMESPACE)
	public List<String> getIdentifier() {
		if (identifier == null) { identifier = new ArrayList<String>(); }
		return identifier;
	}

	@XmlElement(name="source", namespace=DC_NAMESPACE)
	public List<String> getSource() {
		if (source == null) { source = new ArrayList<String>(); }
		return source;
	}

	@XmlElement(name="language", namespace=DC_NAMESPACE)
	public List<String> getLanguage() {
		if (language == null) { language = new ArrayList<String>(); }
		return language;
	}

	@XmlElement(name="relation", namespace=DC_NAMESPACE)
	public List<String> getRelation() {
		if (relation == null) { relation = new ArrayList<String>(); }
		return relation;
	}

	@XmlElement(name="coverage", namespace=DC_NAMESPACE)
	public List<String> getCoverage() {
		if (coverage == null) { coverage = new ArrayList<String>(); }
		return coverage;
	}

	@XmlElement(name="rights", namespace=DC_NAMESPACE)
	public List<String> getRights() {
		if (rights == null) { rights = new ArrayList<String>(); }
		return rights;
	}
	
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
		return OAIDC_SCHEMA_LOCATION;
	}
	
}
