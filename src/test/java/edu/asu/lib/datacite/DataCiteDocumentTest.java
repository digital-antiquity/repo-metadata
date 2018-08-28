package edu.asu.lib.datacite;

import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBException;

import org.purl.dc.terms.ObjectFactory;

import junit.framework.TestCase;
import edu.asu.lib.jaxb.JaxbDocumentWriter;

public class DataCiteDocumentTest extends TestCase {

	public void testDublinCoreDocument() {
		
		DataCiteDocument dc = new DataCiteDocument();
		dc.addTitle("Hi Title");
		dc.setIdentifier("10.0.1234/what");
		dc.setPublisher("New york times");
		dc.setPublicationYear(1234);
		dc.setResourceType("DATASET");
		dc.addPersonalCreator("gray","brady");
//		assertTrue(dc.getTitle().get(0).equals("Hi Title"));
//		dc.getCreator().add("You are a creator");
//		dc.getContributor().add("Harry Reinhold");
//		dc.getCoverage().add("the past");
//		dc.getDate().add("1999");
//		dc.getDescription().add("You are clever");
//		dc.getFormat().add("clay");
//		dc.getIdentifier().add("http://lib.asu.edu/id");
//		dc.getLanguage().add("en");
//		dc.getPublisher().add("Stinky Feet Press");
//		dc.getRelation().add("neighbor");
//		dc.getRights().add("You have none");
//		dc.getSource().add("the sewer");
//		dc.getSubject().add("respiration");
//		dc.getSubject().add("secondary respiration");
//		assertTrue(dc.getSubject().get(1).equals("secondary respiration"));
//		dc.getType().add("a great type");
		
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
            JaxbDocumentWriter.write(dc, out, true);
            System.out.println(out);
			assertTrue(true); // no exceptions means the marshaller validated
		} catch (JAXBException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
