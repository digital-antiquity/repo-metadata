package edu.asu.lib.dc;

import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBException;

import junit.framework.TestCase;
import edu.asu.lib.jaxb.JaxbDocumentWriter;

public class DublinCoreDocumentTest extends TestCase {

	public void testDublinCoreDocument() {
		
		DublinCoreDocument dc = new DublinCoreDocument();
		dc.getTitle().add("Hi Title");
		assertTrue(dc.getTitle().get(0).equals("Hi Title"));
		dc.getCreator().add("You are a creator");
		dc.getContributor().add("Harry Reinhold");
		dc.getCoverage().add("the past");
		dc.getDate().add("1999");
		dc.getDescription().add("You are clever");
		dc.getFormat().add("clay");
		dc.getIdentifier().add("http://lib.asu.edu/id");
		dc.getLanguage().add("en");
		dc.getPublisher().add("Stinky Feet Press");
		dc.getRelation().add("neighbor");
		dc.getRights().add("You have none");
		dc.getSource().add("the sewer");
		dc.getSubject().add("respiration");
		dc.getSubject().add("secondary respiration");
		assertTrue(dc.getSubject().get(1).equals("secondary respiration"));
		dc.getType().add("a great type");
		
		try {
			JaxbDocumentWriter.write(dc, new ByteArrayOutputStream(), true);
			assertTrue(true); // no exceptions means the marshaller validated
		} catch (JAXBException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
