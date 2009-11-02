package edu.asu.lib.jaxb;

import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBResult;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;

public class JaxbDocumentTransformer {
	
	public static void transform(Source xsl, JaxbDocument doc, OutputStream out) 
    throws TransformerException, JAXBException {
		transform(xsl, doc, new StreamResult(out));
	}
    
	public static void transform(Source xsl, JaxbDocument doc, Node out) 
    throws TransformerException, JAXBException {
       transform(xsl, doc, new DOMResult(out));
	}

	public static JAXBResult transform(Source xsl, JaxbDocument doc, JAXBContext out)
	throws TransformerException, JAXBException {
		JAXBResult res = new JAXBResult(out);
		transform(xsl, doc, res);
		return res;
	}
	
	private static void transform(Source xsl, JaxbDocument doc, Result res) 
	throws TransformerException, JAXBException {
		TransformerFactory tfact = TransformerFactory.newInstance();       
		Transformer trans = tfact.newTransformer(xsl);
		JAXBSource modsSource = new JAXBSource(doc.getContext(), doc.getRootElement());
		trans.transform(modsSource, res);
	}

}
