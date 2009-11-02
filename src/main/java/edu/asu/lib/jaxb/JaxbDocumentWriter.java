package edu.asu.lib.jaxb;

import java.io.File;
import java.io.OutputStream;
import java.io.Writer;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;

import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;

public class JaxbDocumentWriter {
	
	public static void write(JaxbDocument doc, OutputStream out, Boolean formatOutput)
	throws JAXBException {
		buildMarshaller(doc, formatOutput).marshal(doc.getRootElement(), out);
	}
	
	public static void write(JaxbDocument doc, File out, Boolean formatOutput)
	throws JAXBException {
		buildMarshaller(doc, formatOutput).marshal(doc.getRootElement(), out);
	}
	
	public static void write(JaxbDocument doc, Node out, Boolean formatOutput)
	throws JAXBException {
		buildMarshaller(doc, formatOutput).marshal(doc.getRootElement(), out);
	}
	
	public static void write(JaxbDocument doc, Result out, Boolean formatOutput)
	throws JAXBException {
		buildMarshaller(doc, formatOutput).marshal(doc.getRootElement(), out);
	}
	
	public static void write(JaxbDocument doc, Writer out, Boolean formatOutput)
	throws JAXBException {
		buildMarshaller(doc, formatOutput).marshal(doc.getRootElement(), out);
	}
	
	public static void write(JaxbDocument doc, ContentHandler out, Boolean formatOutput)
	throws JAXBException {
		buildMarshaller(doc, formatOutput).marshal(doc.getRootElement(), out);
	}
	
	public static void write(JaxbDocument doc, XMLEventWriter out, Boolean formatOutput)
	throws JAXBException {
		buildMarshaller(doc, formatOutput).marshal(doc.getRootElement(), out);
	}
	
	public static void write(JaxbDocument doc, XMLStreamWriter out, Boolean formatOutput)
	throws JAXBException {
		buildMarshaller(doc, formatOutput).marshal(doc.getRootElement(), out);
	}
	
	private static Marshaller buildMarshaller(JaxbDocument doc, Boolean formatOutput)
	throws JAXBException {
		Marshaller marsh = doc.getContext().createMarshaller();
		marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formatOutput);
		marsh.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marsh.setSchema(doc.getSchema());
		marsh.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, doc.getSchemaLocation());
		return marsh;
	}
	
	
}
