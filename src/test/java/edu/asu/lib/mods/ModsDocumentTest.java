package edu.asu.lib.mods;

import gov.loc.mods.v3.NameTypeAttribute;
import gov.loc.mods.v3.PlaceAuthority;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import edu.asu.lib.mods.ModsDocument;
import edu.asu.lib.mods.ModsElementContainer.DateElement;
import edu.asu.lib.mods.ModsElementContainer.DateGranularity;
import edu.asu.lib.mods.ModsElementContainer.DateOtherElement;
import edu.asu.lib.mods.ModsElementContainer.DatePoint;
import edu.asu.lib.mods.ModsElementContainer.DateQualifier;
import edu.asu.lib.mods.ModsElementContainer.DigitalOriginValues;
import edu.asu.lib.mods.ModsElementContainer.IssuanceValues;
import edu.asu.lib.mods.ModsElementContainer.LanguageAuthority;
import edu.asu.lib.mods.ModsElementContainer.Location;
import edu.asu.lib.mods.ModsElementContainer.Name;
import edu.asu.lib.mods.ModsElementContainer.NamePartTypeValue;
import edu.asu.lib.mods.ModsElementContainer.OriginDateType;
import edu.asu.lib.mods.ModsElementContainer.OriginInfo;
import edu.asu.lib.mods.ModsElementContainer.Part;
import edu.asu.lib.mods.ModsElementContainer.PhysicalDescription;
import edu.asu.lib.mods.ModsElementContainer.RecordInfo;
import edu.asu.lib.mods.ModsElementContainer.ReformattingQualityValues;
import edu.asu.lib.mods.ModsElementContainer.RelatedItem;
import edu.asu.lib.mods.ModsElementContainer.RelatedItemTypeValues;
import edu.asu.lib.mods.ModsElementContainer.Subject;
import edu.asu.lib.mods.ModsElementContainer.TitleInfo;
import edu.asu.lib.mods.ModsElementContainer.TitleType;
import edu.asu.lib.mods.ModsElementContainer.TypeOfResourceValue;
import edu.asu.lib.mods.ModsElementContainer.Location.HoldingSimple.CopyInformation;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple ModsDocument.
 */
public class ModsDocumentTest extends TestCase {
    
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ModsDocumentTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( ModsDocumentTest.class );
    }

    /**
     * 
     */
    public void testModsDocument() {
    	
    	ModsDocument doc = new ModsDocument();
		
		TitleInfo title = doc.createTitleInfo();
		title.addTitle("A good one.");
		title.addPartName("The First Part");
		title.addPartNumber("2");
		title.addNonSort("The");
		title.setTitleType(TitleType.uniform);
		title.addSubTitle("sub");
		title.setAttribute("displayLabel", "Label Me Good");
	
		Name author = doc.createName();
		author.setNameType(NameTypeAttribute.PERSONAL);
		author.addDescription("This guy is awesome");
		author.addRole("author", false, null);
		author.addAffiliation("ASU");
		author.addDisplayForm("Mr. Matty Matt");
		author.addNamePart("Cordial", NamePartTypeValue.family);
		author.addNamePart("Matthew", NamePartTypeValue.given);
		
		doc.addTypeOfResource(TypeOfResourceValue.TEXT, true, false);
		doc.addTypeOfResource(TypeOfResourceValue.CARTOGRAPHIC, true, true);
		
		doc.addGenre("GoodThings", null);
		
		OriginInfo origin = doc.createOriginInfo();
		origin.addPlace("Phoenix", false, null);
		origin.addEdition("First");
		origin.addIssuance(IssuanceValues.continuing);
		origin.addFrequency("yearly", null);
		origin.addPublisher("Stinky Feet Press");
		DateElement date = origin.createDate(OriginDateType.CREATED);
		date.setAsKeyDate();
		date.setValue(new Date(), DateGranularity.YEAR_MONTH_DAY);
		
		DateOtherElement dot = origin.createDateOther();
		dot.setType("completed!!");
		dot.setQualifier(DateQualifier.approximate);
		dot.setValue("77");
		
		doc.addLanguage("en", true, LanguageAuthority.ISO639_3, null);
		
		PhysicalDescription phys = doc.createPhysicalDescription();
		phys.addDigitalOrigin(DigitalOriginValues.DIGITIZED_OTHER_ANALOG);
		phys.addInternetMediaType("text/plain");
		phys.addExtent("300 pages");
		phys.addReformattingQuality(ReformattingQualityValues.access);
		phys.addForm("Lincoln Logs", null, null);
		phys.addNote("This is a really pretty thing.", null);
		
		doc.addAbstract("Wow this should be really great.", null);
		
		doc.addTableOfContents(
			"1) mystuff\n2)Your stuff", 
			Arrays.asList(doc.new Attribute("displayLabel", "Mine and Yours")));
		
		doc.addTargetAudience("Dev Folks", null);
		
		doc.addNote("This is not a bogus record. Really, it is useful.", null);
		
		String[] topics = {"bears", "honey", "helmets"};
		for (String topic : topics) {
			Subject sub = doc.createSubject();
			sub.addTopic(topic);
		}
		
		Subject sub = doc.createSubject();
		Name subName = sub.createName();
		subName.setNameType(NameTypeAttribute.CORPORATE);
		subName.addNamePart("Fly By Night Productions", null);
		TitleInfo subTitle = sub.createTitleInfo();
		subTitle.addTitle("2012 The Musical");
		
		sub = doc.createSubject();
		sub.addCartographics(Arrays.asList("N: 1250", "E: 468", "S: 34", "W: 6634"), null, "feet");
		
		sub = doc.createSubject();
		DateElement d = sub.createTemporalAsDate();
		d.setValue("200");
		d.setPoint(DatePoint.start);
		
		sub = doc.createSubject();
		sub.addTemporal("modern era");
		
		sub = doc.createSubject();
		sub.addGenre("fishing tales");
		
		sub = doc.createSubject();
		sub.addGeographic("Southwestern");
		sub.addGeographic("Arizona");
		
		sub = doc.createSubject();
		sub.addOccupation("Engineer");
		
		sub = doc.createSubject();
		sub.addGeographicCode("USA", PlaceAuthority.MARCCOUNTRY);
		sub.addHierarchicalGeographic(null, "USA", null, null, "Ohio", null, 
			"Montgomery", "Dayton", null, null, null, null);
		
		doc.addClassification("stellar", null);
		
		RelatedItem rel = doc.createRelatedItem();
		rel.setType(RelatedItemTypeValues.host);
		rel.addGenre("scarry", null);
		rel.addIdentifier("asulib:4", "fedora pid", false, null);
		RelatedItem rel2 = rel.createRelatedItem();
		rel2.addAbstract("iiiiiiiinnnnnnnnnnyyyyyyyouuuuu", null);
		
		doc.addIdentifier("long:34", null, false, null);
		
		Location loc = doc.createLocation();
		loc.addPhysicalLocation("My House.", null);
		loc.addShelfLocator("dd554");
		loc.addUrl("http://drs.asu.edu", true, null);
		CopyInformation ci = loc.createHoldingSimple().createCopyInformation();
		ci.addSubLocation("the sink");
		ci.addEnumerationAndChronology("50", null);
		ci.setForm("paper", null);
		
		doc.addAccessCondition("if you touch it I will eat your brain", null);
		
		Part part = doc.createPart();
		part.setType("host");
		part.addExtent("20", "30", null, "pages", new BigInteger("10"));
		part.addDetail("3", "The Long Running Series", null, "issue", null);
		DateElement da = part.createDate();
		da.setValue(new Date(), DateGranularity.YEAR_MONTH);
		part.addText("Lots of stuff in this chapter was created by monkeys.", null);
		
		RecordInfo ri = doc.createRecordInfo();
		ri.addDescriptionStandard("my own", null);
		ri.addLanguageOfCataloging("en", true, LanguageAuthority.ISO639_2b, null);
		DateElement dt = ri.createRecordCreationDate();
		dt.setValue("2008");
		ri.addRecordOrigin("My BRAIN!!!!!!!!");
		ri.addRecordIdentifier("hiBrainHi", null);
		
        try {
        	Marshaller marsh = doc.getContext().createMarshaller();
        	marsh.setSchema(doc.getSchema());
        	marsh.marshal(doc.getRootElement(), new ByteArrayOutputStream());
			assertTrue(true); // if validation did not throw an exception
		} catch (JAXBException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
    }
}
