package edu.asu.lib.mods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;

import gov.loc.mods.v3.AbstractType;
import gov.loc.mods.v3.AccessConditionType;
import gov.loc.mods.v3.ClassificationType;
import gov.loc.mods.v3.CodeOrText;
import gov.loc.mods.v3.CopyInformationType;
import gov.loc.mods.v3.DateOtherType;
import gov.loc.mods.v3.DateType;
import gov.loc.mods.v3.DetailType;
import gov.loc.mods.v3.EnumerationAndChronologyType;
import gov.loc.mods.v3.ExtensionType;
import gov.loc.mods.v3.ExtentType;
import gov.loc.mods.v3.GenreType;
import gov.loc.mods.v3.HierarchicalGeographicType;
import gov.loc.mods.v3.HoldingSimpleType;
import gov.loc.mods.v3.IdentifierType;
import gov.loc.mods.v3.LanguageType;
import gov.loc.mods.v3.LocationType;
import gov.loc.mods.v3.NamePartType;
import gov.loc.mods.v3.NameType;
import gov.loc.mods.v3.NameTypeAttribute;
import gov.loc.mods.v3.NoteType;
import gov.loc.mods.v3.ObjectFactory;
import gov.loc.mods.v3.OriginInfoType;
import gov.loc.mods.v3.PartType;
import gov.loc.mods.v3.PhysicalDescriptionType;
import gov.loc.mods.v3.PhysicalLocationType;
import gov.loc.mods.v3.PlaceAuthority;
import gov.loc.mods.v3.PlaceTermType;
import gov.loc.mods.v3.PlaceType;
import gov.loc.mods.v3.RecordInfoType;
import gov.loc.mods.v3.RelatedItemType;
import gov.loc.mods.v3.RoleType;
import gov.loc.mods.v3.StringPlusAuthority;
import gov.loc.mods.v3.StringPlusAuthorityPlusLanguage;
import gov.loc.mods.v3.StringPlusAuthorityPlusType;
import gov.loc.mods.v3.StringPlusDisplayLabelPlusType;
import gov.loc.mods.v3.SubjectType;
import gov.loc.mods.v3.TableOfContentsType;
import gov.loc.mods.v3.TargetAudienceType;
import gov.loc.mods.v3.TitleInfoType;
import gov.loc.mods.v3.TypeOfResourceType;
import gov.loc.mods.v3.UnstructuredText;
import gov.loc.mods.v3.UrlType;
import gov.loc.mods.v3.Yes;
import gov.loc.mods.v3.LanguageType.LanguageTerm;
import gov.loc.mods.v3.RecordInfoType.RecordIdentifier;
import gov.loc.mods.v3.SubjectType.Cartographics;
import gov.loc.mods.v3.SubjectType.GeographicCode;

public abstract class ModsElementContainer {
	
	protected static final ObjectFactory modsFactory = new ObjectFactory();
	private Location location;
	private Part part;
	private PhysicalDescription physicalDescription;
	private RecordInfo recordInfo;
	private RelatedItem relatedItem;
	private OriginInfo originInfo;
	private TitleInfo titleInfo;
	
	protected abstract List<Object> getModsGroup();

	public enum TypeOfResourceValue {
		TEXT("text"),
		CARTOGRAPHIC("cartographic"),
		NOTATED_MUSIC("notated music"),
		SOUND_RECORDING_MUSICAL("sound recording-musical"),
		SOUND_RECORDING_NONMUSICAL("sound recording-nonmusical"),
		SOUND_RECORDING("sound recording"),
		STILL_IMAGE("still image"),
		MOVING_IMAGE("moving image"),
		THREE_DIMENSIONAL_OBJECT("three dimensional object"),
		SOFTWARE_MULTIMEDIA("software, multimedia"),
		MIXED_MATERIAL("mixed material");
    	 
		private String value;
     	
		private TypeOfResourceValue(String value){
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}
    }
	
	public enum TitleType {
		abbreviated, translated, alternative, uniform;
	}
    
    public enum DateGranularity {
    	YEAR(FastDateFormat.getInstance("yyyy")),
    	YEAR_MONTH(FastDateFormat.getInstance("yyyy-MM")),
    	YEAR_MONTH_DAY(FastDateFormat.getInstance("yyyy-MM-dd"));
    	
    	private FastDateFormat format;
    	
    	private DateGranularity(FastDateFormat format){
    		this.format = format;
    	}
    	
    	public FastDateFormat getFormat() {
    		return format;
    	}
    	
    	public DateEncoding getDateEncoding() {
    		return DateEncoding.iso8601;
    	}
    }
    
    public enum DateEncoding {
    	w3cdtf, iso8601, marc;
    }
    
    public enum DatePoint {
    	start, end;
    }
    
    public enum DateQualifier {
    	approximate, inferred, questionable;
    }
    
    public enum OriginDateType {
    	ISSUED, CREATED, CAPTURED, VALID, MODIFIED, COPYRIGHT;
    }
    
    public enum LanguageAuthority {
    	ISO639_2b("iso639-2b"), 
    	RFC3066("rfc3066"), 
    	ISO639_3("iso639-3"), 
    	RFC4646("rfc4646");
    	
    	private String value;
     	
		private LanguageAuthority(String value){
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}
    }
    
    public enum NamePartTypeValue {
    	date, family, given, termsOfAddress;
    }
    
    public enum IssuanceValues {
    	continuing, monographic;
    }
    
    public enum ReformattingQualityValues {
    	access, preservation, replacement;
    }
    
    public enum DigitalOriginValues {
    	BORN_DIGITAL("born digital"), 
    	REFORMATTED_DIGITAL("reformatted digital"), 
    	DIGITIZED_MICROFILM("digitized microfilm"), 
    	DIGITIZED_OTHER_ANALOG("digitized other analog");
    	
    	private String value;
     	
		private DigitalOriginValues(String value){
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}
    }
    
    public enum RelatedItemTypeValues {
    	preceding, succeeding, original, host, constituent, series,
    	otherVersion, otherFormat, isReferencedBy;
    }
    
    private void setElementAttribute(Object elem, String attribute, Object value) {
    	String setMethod = "set" + StringUtils.capitalize(attribute);
		for (Method meth : elem.getClass().getMethods()) {
			if (meth.getName().equals(setMethod)) {
				try {
					meth.invoke(elem, value);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				return;
			}
		}
    }
    
    private void setElementAttribute(Object elem, Attribute attr) {
    	if (attr == null) return;
		setElementAttribute(elem, attr.getName(), attr.getValue());
    }
    
    private void setElementAttributes(Object elem, List<Attribute> attrs) {
    	if (attrs == null) return;
		for (Attribute attr : attrs) {
			setElementAttribute(elem, attr.getName(), attr.getValue());
		}
    }
    
    public void addTypeOfResource(TypeOfResourceValue value, boolean isCollection, boolean isManuscript){
    	TypeOfResourceType typeType = modsFactory.createTypeOfResourceType();
    	typeType.setValue(value.toString());
    	if (isCollection) typeType.setCollection(Yes.YES);
    	if (isManuscript) typeType.setManuscript(Yes.YES);
    	getModsGroup().add(typeType);
    }
    
    public void addLanguage(String lang, boolean isCode, LanguageAuthority auth, String objectPart) {
    	LanguageType langType = generateLanguageType(lang, isCode, auth, objectPart);
    	getModsGroup().add(langType);
    }
    
    private LanguageType generateLanguageType(String lang, boolean isCode, LanguageAuthority auth, String objectPart) {
    	LanguageType langType = modsFactory.createLanguageType();
    	LanguageTerm langTerm = modsFactory.createLanguageTypeLanguageTerm();
    	if (isCode) {
    		langTerm.setType(CodeOrText.CODE);
    	} else {
    		langTerm.setType(CodeOrText.TEXT);
    	}
    	langTerm.setValue(lang);
    	if (auth != null) langTerm.setAuthority(auth.toString());
    	if (objectPart != null) langType.setObjectPart(objectPart);
    	langType.getLanguageTerm().add(langTerm);
    	return langType;
    }
    
    public void addAbstract(String abs, List<Attribute> attrs) {
    	AbstractType absType = modsFactory.createAbstractType();
    	absType.setValue(abs);
    	setElementAttributes(absType, attrs);
    	getModsGroup().add(absType);
    }
    
    public void addNote(String note, List<Attribute> attrs) {
    	NoteType noteType = modsFactory.createNoteType();
    	noteType.setValue(note);
    	setElementAttributes(noteType, attrs);
    	getModsGroup().add(noteType);
    }
    
    public void addTableOfContents(String toc, List<Attribute> attrs) {
    	TableOfContentsType tocType = modsFactory.createTableOfContentsType();
    	tocType.setValue(toc);
    	setElementAttributes(tocType, attrs);
    	getModsGroup().add(tocType);
    }
    
    public void addAccessCondition(String cond, List<Attribute> attrs) {
    	AccessConditionType condType = modsFactory.createAccessConditionType();
    	condType.getContent().add(cond);
    	setElementAttributes(condType, attrs);
    	getModsGroup().add(condType);
    }
    
    public void addIdentifier(String id, String type, boolean invalid, List<Attribute> attrs) {
    	IdentifierType idType = modsFactory.createIdentifierType();
    	idType.setValue(id);
    	if (type != null) idType.setType(type);
    	if (invalid) idType.setInvalid(Yes.YES);
    	setElementAttributes(idType, attrs);
    	getModsGroup().add(idType);
    }
    
    public void addGenre(String genre, List<Attribute> attrs) {
    	GenreType genreType = modsFactory.createGenreType();
    	genreType.setValue(genre);
    	setElementAttributes(genreType, attrs);
    	getModsGroup().add(genreType);
    }
    
    public void addTargetAudience(String audience, List<Attribute> attrs) {
    	TargetAudienceType taType = modsFactory.createTargetAudienceType();
    	taType.setValue(audience);
    	setElementAttributes(taType, attrs);
    	getModsGroup().add(taType);
    }
    
    public void addClassification(String classification, List<Attribute> attrs) {
    	ClassificationType classType = modsFactory.createClassificationType();
    	classType.setValue(classification);
    	setElementAttributes(classType, attrs);
    	getModsGroup().add(classType);
    }
    
	public RelatedItem createRelatedItem() {
		return new RelatedItem(getModsGroup());
	}
	
	public TitleInfo createTitleInfo() {
		TitleInfo ti = new TitleInfo();
		getModsGroup().add(ti.getElementType());
		return ti;
	}
	
	public RecordInfo createRecordInfo() {
		RecordInfo ri = new RecordInfo();
		getModsGroup().add(ri.getElementType());
		return ri;
	}
	
	public Location createLocation() {
		Location loc = new Location();
		getModsGroup().add(loc.getElementType());
		return loc;
	}
	
	public Part createPart() {
		Part part = new Part();
		getModsGroup().add(part.getElementType());
		return part;
	}
	
	public Name createName() {
		Name name = new Name();
		getModsGroup().add(name.getElementType());
		return name;
	}
	
	public Subject createSubject() {
		Subject sub = new Subject();
		getModsGroup().add(sub.getElementType());
		return sub;
	}
	
	public OriginInfo createOriginInfo() {
		OriginInfo oi = new OriginInfo();
		getModsGroup().add(oi.getElementType());
		return oi;
	}
	
	public List<OriginInfoType> getOriginInfoType() {
		List<OriginInfoType> oit = getObjectList(OriginInfoType.class);
		return oit;
	}
	
	public <E> List<E> getObjectList(Class<E> clazz) {
		List<E> objs = new ArrayList<E>();
		for (Object o : getModsGroup()) {
			if (clazz.isInstance(o)) objs.add(clazz.cast(o));
		}
		return objs;
	}
	
	public PhysicalDescription createPhysicalDescription() {
		PhysicalDescription pd = new PhysicalDescription();
		getModsGroup().add(pd.getElementType());
		return pd;
	}
	
	public class RelatedItem extends ModsElementContainer {
		
		private List<Object> modsGroup;
		private RelatedItemType relItem;
		
		public RelatedItem(List<Object> parent) {
			relItem = modsFactory.createRelatedItemType();
			parent.add(relItem);
			modsGroup = relItem.getModsGroup();
		}
		
		@Override
		protected List<Object> getModsGroup() {
			return modsGroup;
		}	
		
		public void setType(RelatedItemTypeValues type) {
			relItem.setRiType(type.toString());
		}
		
		public void setArributes(List<Attribute> attrs) {
			setElementAttributes(relItem, attrs);
		}
		
	}
	
	public class TitleInfo extends ElementGroup<TitleInfoType> {
		
		private TitleInfoType titleType;
		private List<JAXBElement<String>> titleRoot;
		
		public TitleInfo() {
			titleType = modsFactory.createTitleInfoType();
			titleRoot = titleType.getTitleOrSubTitleOrPartNumber();
		}
		
		public void setTitleType(TitleType type) {
			titleType.setTiType(type.toString());
		}
		
		public void addTitle(String title) {
	        titleRoot.add(modsFactory.createBaseTitleInfoTypeTitle(title));
		}
		
		public void addSubTitle(String subtitle) {
			titleRoot.add(modsFactory.createBaseTitleInfoTypeSubTitle(subtitle));
		}
		
		public void addPartName(String partName) {
			titleRoot.add(modsFactory.createBaseTitleInfoTypePartName(partName));
		}
		
		public void addPartNumber(String partNum) {
			titleRoot.add(modsFactory.createBaseTitleInfoTypePartNumber(partNum));
		}
		
		public void addNonSort(String nonSort) {
			titleRoot.add(modsFactory.createBaseTitleInfoTypeNonSort(nonSort));
		}

		@Override
		public TitleInfoType getElementType() {
			return titleType;
		}
	}
	
	public class RecordInfo extends ElementGroup<RecordInfoType>{
		
		private RecordInfoType recordInfoType;
		private List<JAXBElement<?>> riRoot;

		public RecordInfo() {
			recordInfoType = modsFactory.createRecordInfoType();
			riRoot = recordInfoType.getRecordContentSourceOrRecordCreationDateOrRecordChangeDate();
		}
		
		public void addRecordContentSource(String source, String authority, String language) {
			StringPlusAuthorityPlusLanguage val = modsFactory.createStringPlusAuthorityPlusLanguage();
			val.setValue(source);
			if (authority != null) val.setAuthority(authority);
			if (language != null) val.setLang(language);
			riRoot.add(modsFactory.createRecordInfoTypeRecordContentSource(val));
		}
		
		public void addDescriptionStandard(String standard, String authority) {
			StringPlusAuthority val = modsFactory.createStringPlusAuthority();
			val.setValue(standard);
			if (authority != null) val.setAuthority(authority);
			riRoot.add(modsFactory.createRecordInfoTypeDescriptionStandard(val));
		}
		
		public void addRecordOrigin(String origin) {
			riRoot.add(modsFactory.createRecordInfoTypeRecordOrigin(origin));
		}
		
		public void addRecordIdentifier(String id, String source) {
			RecordIdentifier recIdType = modsFactory.createRecordInfoTypeRecordIdentifier();
			recIdType.setValue(id);
			if (source != null) recIdType.setSource(source);
			riRoot.add(modsFactory.createRecordInfoTypeRecordIdentifier(recIdType));
		}
		
		public void addLanguageOfCataloging(String lang, boolean isCode, LanguageAuthority auth, String objectPart) {
			LanguageType langType = generateLanguageType(lang, isCode, auth, objectPart);
			riRoot.add(modsFactory.createRecordInfoTypeLanguageOfCataloging(langType));
		}
		
		public DateElement createRecordCreationDate() {
			DateElement date = new DateElement();
			riRoot.add(modsFactory.createRecordInfoTypeRecordCreationDate(date.getElementType()));
			return date;
		}
		
		public DateElement createRecordChangeDate() {
			DateElement date = new DateElement();
			riRoot.add(modsFactory.createRecordInfoTypeRecordChangeDate(date.getElementType()));
			return date;
		}

		@Override
		public RecordInfoType getElementType() {
			return recordInfoType;
		}
	}
	
	public abstract class DateBase<D extends DateType> extends ElementGroup<D> {
		
		protected D dateType;
		
		public void setAsKeyDate() {
			dateType.setKeyDate(Yes.YES);
		}
		
		public void setEncoding(DateEncoding enc) {
			dateType.setEncoding(enc.toString());
		}
		
		public void setPoint(DatePoint point) {
			dateType.setPoint(point.toString());
		}
		
		public void setQualifier(DateQualifier qual) {
			dateType.setQualifier(qual.toString());
		}
		
		public void setValue(String value) {
			dateType.setValue(value);
		}
		
		public void setValue(Date value, DateGranularity gran) {
			dateType.setValue(gran.getFormat().format(value));
			dateType.setEncoding(gran.getDateEncoding().toString());
		}
		
		public abstract void setType(String type);
		
		@Override
		public D getElementType() {
			return dateType;
		}
		
	}
	
	public class DateElement extends DateBase<DateType> {
		
		public DateElement() {
			dateType = modsFactory.createDateType();
		}

		@Override
		public void setType(String type) {}
		
	}
	
	public class DateOtherElement extends DateBase<DateOtherType> {
		
		public DateOtherElement() {
			dateType = modsFactory.createDateOtherType();
		}
		
		@Override
		public void setType(String type) {
			dateType.setType(type);
		}
	}
	
	public class Location extends ElementGroup<LocationType> {
		
		private LocationType locType;
		
		public Location() {
			locType = modsFactory.createLocationType();
		}
		
		public void addShelfLocator(String locator) {
			locType.getShelfLocator().add(locator);
		}
		
		public void addUrl(String url, boolean primaryDisplay, List<Attribute> attrs) {
			UrlType urlType = modsFactory.createUrlType();
			urlType.setValue(url);
			setElementAttributes(urlType, attrs);
			if (primaryDisplay) urlType.setUsage("primary display");
			locType.getUrl().add(urlType);
		}
		
		public void addPhysicalLocation(String location, List<Attribute> attrs) {
			PhysicalLocationType plType = modsFactory.createPhysicalLocationType();
			plType.setValue(location);
			setElementAttributes(plType, attrs);
			locType.getPhysicalLocation().add(plType);
		}
		
		public void addHoldingExternal(String val) {
			ExtensionType ext = modsFactory.createExtensionType();
			ext.getContent().add(val);
			locType.setHoldingExternal(ext);
		}
		
		public HoldingSimple createHoldingSimple() {
			return new HoldingSimple();
		}
		
		@Override
		public LocationType getElementType() {
			return locType;
		}
		
		public class HoldingSimple extends ElementGroup<HoldingSimpleType> {
			
			private HoldingSimpleType holdType;
			
			public HoldingSimple() {
				holdType = modsFactory.createHoldingSimpleType();
				locType.setHoldingSimple(holdType);
			}
			
			@Override
			public HoldingSimpleType getElementType() {
				return holdType;
			}
			
			public CopyInformation createCopyInformation() {
				return new CopyInformation();
			}
			
			public class CopyInformation extends ElementGroup<CopyInformationType>{
				
				private CopyInformationType ciType; 
				
				public CopyInformation() {
					ciType = modsFactory.createCopyInformationType();
					holdType.getCopyInformation().add(ciType);
				}
				
				public void setForm(String form, String authority) {
					StringPlusAuthority val = modsFactory.createStringPlusAuthority();
					val.setValue(form);
					if (authority != null) val.setAuthority(authority);
					ciType.setForm(val);
				}
				
				public void addElectronicLocator(String locator){
					ciType.getElectronicLocator().add(locator);
				}
				
				public void addShelfLocator(String locator){
					ciType.getShelfLocator().add(locator);
				}
				
				public void addSubLocation(String location){
					ciType.getSubLocation().add(location);
				}
				
				public void addNote(String note, String type, String displayLabel){
					StringPlusDisplayLabelPlusType val = modsFactory.createStringPlusDisplayLabelPlusType();
					val.setValue(note);
					if (type != null) val.setSpdType(type);
					if (displayLabel != null) val.setDisplayLabel(displayLabel);
					ciType.getNote().add(val);
				}
				
				public void addEnumerationAndChronology(String value, String unitType){
					EnumerationAndChronologyType ecType = modsFactory.createEnumerationAndChronologyType();
					ecType.setValue(value);
					if (unitType != null) ecType.setUnitType(unitType);
					ciType.getEnumerationAndChronology().add(ecType);
				}

				@Override
				public CopyInformationType getElementType() {
					return ciType;
				}
				
			}
			
		}
		
	}
	
	public class Part extends ElementGroup<PartType> {
		
		private PartType partType;
		private List<Object> ptRoot;
		
		public Part() {
			partType = modsFactory.createPartType();
			ptRoot = partType.getDetailOrExtentOrDate();
		}
		
		public void setType(String type) {
			partType.setType(type);
		}
		
		public void addDetail(String number, String title, String caption, String type, BigInteger level) {
			DetailType detailType = modsFactory.createDetailType();
			List<JAXBElement<String>> dtRoot = detailType.getNumberOrCaptionOrTitle();
			if (number != null) dtRoot.add(modsFactory.createDetailTypeNumber(number));
			if (caption != null) dtRoot.add(modsFactory.createDetailTypeCaption(caption));
			if (title != null) dtRoot.add(modsFactory.createDetailTypeTitle(title));
			if (type != null) detailType.setType(type);
			if (level != null) detailType.setLevel(level);
			ptRoot.add(detailType);
		}
		
		public void addExtent(String start, String end, String list, String unit, BigInteger total) {
			ExtentType extType = modsFactory.createExtentType();
			if (start != null) extType.setStart(start);
			if (end != null) extType.setEnd(end);
			if (list != null) extType.setList(list);
			if (unit != null) extType.setUnit(unit);
			if (total != null) extType.setTotal(total);
			ptRoot.add(extType);
		}
		
		public DateElement createDate() {
			DateElement date = new DateElement();
			ptRoot.add(date.getElementType());
			return date;
		}
		
		public void addText(String text, List<Attribute> attrs) {
			UnstructuredText textType = modsFactory.createUnstructuredText();
			textType.setValue(text);
			setElementAttributes(textType, attrs);
			ptRoot.add(textType);
		}

		@Override
		public PartType getElementType() {
			return partType;
		}
		
		
	}
	
	public class Name extends ElementGroup<NameType> {
		
		private NameType nameType;
		private List<JAXBElement<?>> nRoot;
		
		public Name() {
			nameType = modsFactory.createNameType();
			nRoot = nameType.getNamePartOrDisplayFormOrAffiliation();
		}
		
		public void setNameType(NameTypeAttribute type) {
			nameType.setNType(type);
		}
		
		public void addNamePart(String name, NamePartTypeValue type) {
			NamePartType namePart = modsFactory.createNamePartType();
	        namePart.setValue(name);
	        if (type != null) namePart.setType(type.toString());
	        nRoot.add(modsFactory.createNameTypeNamePart(namePart));
		}
		
		public void addDisplayForm(String displayForm) {
			nRoot.add(modsFactory.createNameTypeDisplayForm(displayForm));
		}
		
		public void addAffiliation(String affiliation) {
			nRoot.add(modsFactory.createNameTypeAffiliation(affiliation));
		}

		public void addDescription(String description) {
			nRoot.add(modsFactory.createNameTypeDescription(description));
		}
		
		public void addRole(String role, boolean isCode, String authority) {
			RoleType roleType = modsFactory.createRoleType();
            RoleType.RoleTerm roleTerm = modsFactory.createRoleTypeRoleTerm();
            if (isCode) {
            	roleTerm.setType(CodeOrText.CODE);
            } else {
            	roleTerm.setType(CodeOrText.TEXT);
            }
            roleTerm.setValue(role);
            if (authority != null) roleTerm.setAuthority(authority);
            roleType.getRoleTerm().add(roleTerm);
	        nRoot.add(modsFactory.createNameTypeRole(roleType));
		}

		@Override
		public NameType getElementType() {
			return nameType;
		}
		
	}
	
	public class OriginInfo extends ElementGroup<OriginInfoType>{
		
		private OriginInfoType oiType;
		private List<JAXBElement<?>> oiRoot;
		
		public OriginInfo() {
			oiType = modsFactory.createOriginInfoType();
			oiRoot = oiType.getPlaceOrPublisherOrDateIssued();
		}

		@Override
		public OriginInfoType getElementType() {
			return oiType;
		}
		
	    public void addPublisher(String pub) {
	    	oiRoot.add(modsFactory.createOriginInfoTypePublisher(pub));
	    }
	    
	    public void addEdition(String edition) {
	    	oiRoot.add(modsFactory.createOriginInfoTypeEdition(edition));
	    }
	    
	    public void addIssuance(IssuanceValues value) {
	    	oiRoot.add(modsFactory.createOriginInfoTypeIssuance(value.toString()));
	    }
	    
	    public void addFrequency(String freq, String authority) {
	    	StringPlusAuthority value = modsFactory.createStringPlusAuthority();
	    	value.setValue(freq);
	    	if (authority != null) value.setAuthority(authority);
	    	oiRoot.add(modsFactory.createOriginInfoTypeFrequency(value));
	    }
	    
	    public void addPlace(String placeTerm, boolean isCode, PlaceAuthority auth) {
	    	PlaceType placeType = modsFactory.createPlaceType();
	    	PlaceTermType placeTermType = modsFactory.createPlaceTermType();
	    	placeTermType.setValue(placeTerm);
	    	if (isCode) {
	    		placeTermType.setType(CodeOrText.CODE);
	    	} else {
	    		placeTermType.setType(CodeOrText.TEXT);
	    	}
	    	
	    	if (auth != null) placeTermType.setAuthority(auth);
	    	placeType.getPlaceTerm().add(placeTermType);
	    	oiRoot.add(modsFactory.createOriginInfoTypePlace(placeType));
	    }
	    
	    public DateElement createDate(OriginDateType type) {
    		DateElement date = new DateElement();
	    	DateType dateType = date.getElementType();
	    	switch (type) {
				case CREATED:
					oiRoot.add(modsFactory.createOriginInfoTypeDateCreated(dateType));
					break;
				case CAPTURED:
					oiRoot.add(modsFactory.createOriginInfoTypeDateCaptured(dateType));
					break;
				case COPYRIGHT:
					oiRoot.add(modsFactory.createOriginInfoTypeCopyrightDate(dateType));
					break;
				case ISSUED:
					oiRoot.add(modsFactory.createOriginInfoTypeDateIssued(dateType));
					break;
				case MODIFIED:
					oiRoot.add(modsFactory.createOriginInfoTypeDateModified(dateType));
					break;
				case VALID:
					oiRoot.add(modsFactory.createOriginInfoTypeDateValid(dateType));
					break;
			}
	    	return date;
	    }
	    
	    public DateOtherElement createDateOther() {
			DateOtherElement date = new DateOtherElement();
			oiRoot.add(modsFactory.createOriginInfoTypeDateOther(date.getElementType()));
			return date;
	    }
	    
	    public void addOtherDate(String date, DateEncoding enc, DatePoint point, boolean keyDate, DateQualifier qual) {
        	DateOtherType dateType = modsFactory.createDateOtherType();
        	dateType.setValue(date);
        	if (enc != null) dateType.setEncoding(enc.toString());
        	if (point != null) dateType.setPoint(point.toString());
        	if (keyDate) dateType.setKeyDate(Yes.YES);
        	if (qual != null) dateType.setQualifier(qual.toString());
        	oiRoot.add(modsFactory.createOriginInfoTypeDateOther(dateType));
	    }
	    
	}
	
	public class PhysicalDescription extends ElementGroup<PhysicalDescriptionType> {
		
		private PhysicalDescriptionType pdType;
		private List<JAXBElement<?>> pdRoot;
		
		public PhysicalDescription() {
			pdType = modsFactory.createPhysicalDescriptionType();
			pdRoot = pdType.getFormOrReformattingQualityOrInternetMediaType();
		}
		
		public void addForm(String form, String type, String authority) {
			StringPlusAuthorityPlusType val = modsFactory.createStringPlusAuthorityPlusType();
			val.setValue(form);
			if(type != null) val.setType(type);
			if(authority != null) val.setAuthority(authority);
			pdRoot.add(modsFactory.createPhysicalDescriptionTypeForm(val));
		}
		
		public void addInternetMediaType(String mime) {
			pdRoot.add(modsFactory.createPhysicalDescriptionTypeInternetMediaType(mime));
		}
		
		public void addExtent(String ext) {
			pdRoot.add(modsFactory.createPhysicalDescriptionTypeExtent(ext));
		}
		
		public void addReformattingQuality(ReformattingQualityValues val) {
			pdRoot.add(modsFactory.createPhysicalDescriptionTypeReformattingQuality(val.toString()));
		}
		
		public void addDigitalOrigin(DigitalOriginValues val) {
			pdRoot.add(modsFactory.createPhysicalDescriptionTypeDigitalOrigin(val.toString()));
		}
		
		public void addNote(String note, List<Attribute> attrs) {
			NoteType noteType = modsFactory.createNoteType();
			noteType.setValue(note);
			setElementAttributes(noteType, attrs);
			pdRoot.add(modsFactory.createPhysicalDescriptionTypeNote(noteType));
		}
		
		@Override
		public PhysicalDescriptionType getElementType() {
			return pdType;
		}
	}
	
	public class Subject extends ElementGroup<SubjectType> {
		
		private SubjectType subType;
		private List<JAXBElement<?>> subRoot;
		
		public Subject() {
			subType = modsFactory.createSubjectType();
			subRoot = subType.getTopicOrGeographicOrTemporal();
		}
		
		public void addTopic(String topic) {
			subRoot.add(modsFactory.createSubjectTypeTopic(topic));
		}
		
		public void addGeographic(String geo) {
			subRoot.add(modsFactory.createSubjectTypeGeographic(geo));
		}
		
		public DateElement createTemporalAsDate() {
			DateElement date = new DateElement();
			subRoot.add(modsFactory.createSubjectTypeTemporal(date.getElementType()));
			return date;
		}
		
		public void addTemporal(String dateTerm) {
			DateType dateType = modsFactory.createDateType();
			dateType.setValue(dateTerm);
			subRoot.add(modsFactory.createSubjectTypeTemporal(dateType));
		}
		
		public TitleInfo createTitleInfo() {
			TitleInfo ti = new TitleInfo();
			subRoot.add(modsFactory.createSubjectTypeTitleInfo(ti.getElementType()));
			return ti;
		}
		
		public Name createName() {
			Name name = new Name();
			subRoot.add(modsFactory.createSubjectTypeName(name.getElementType()));
			return name;
		}
		
		public void addGeographicCode(String code, PlaceAuthority auth) {
			GeographicCode geoCode = modsFactory.createSubjectTypeGeographicCode();
			geoCode.setValue(code);
			if (auth != null) geoCode.setAuthority(auth);
			subRoot.add(modsFactory.createSubjectTypeGeographicCode(geoCode));
		}
		
		public void addGenre(String genre) {
			subRoot.add(modsFactory.createSubjectTypeGenre(genre));
		}
		
		public void addOccupation(String occ) {
			subRoot.add(modsFactory.createSubjectTypeOccupation(occ));
		}
		
		public void addHierarchicalGeographic(String continent, String country, 
			String province, String region, String state, String territory, 
			String county, String city, String island, String area, 
			String extraterrestrialArea, String citySection) {
			
			HierarchicalGeographicType hgType = modsFactory.createHierarchicalGeographicType();
			List<JAXBElement<String>> hgRoot = hgType.getExtraterrestrialAreaOrContinentOrCountry();
			
			if (continent != null) hgRoot.add(modsFactory.createHierarchicalGeographicTypeContinent(continent));
			if (country != null) hgRoot.add(modsFactory.createHierarchicalGeographicTypeCountry(country));
			if (province != null) hgRoot.add(modsFactory.createHierarchicalGeographicTypeProvince(province));
			if (region != null) hgRoot.add(modsFactory.createHierarchicalGeographicTypeRegion(region));
			if (state != null) hgRoot.add(modsFactory.createHierarchicalGeographicTypeState(state));
			if (territory != null) hgRoot.add(modsFactory.createHierarchicalGeographicTypeTerritory(territory));
			if (county != null) hgRoot.add(modsFactory.createHierarchicalGeographicTypeCounty(county));
			if (city != null) hgRoot.add(modsFactory.createHierarchicalGeographicTypeCity(city));
			if (island != null) hgRoot.add(modsFactory.createHierarchicalGeographicTypeIsland(island));
			if (area != null) hgRoot.add(modsFactory.createHierarchicalGeographicTypeArea(area));
			if (extraterrestrialArea != null) hgRoot.add(modsFactory.createHierarchicalGeographicTypeExtraterrestrialArea(extraterrestrialArea));
			if (citySection != null) hgRoot.add(modsFactory.createHierarchicalGeographicTypeCitySection(citySection));
			
			subRoot.add(modsFactory.createSubjectTypeHierarchicalGeographic(hgType));
		}
		
		public void addCartographics(List<String> coordinates, String projection, String scale) {
			Cartographics cart = modsFactory.createSubjectTypeCartographics();
			
			List<String> targetCoords = cart.getCoordinates();
			for (String coord : coordinates) targetCoords.add(coord);
			
			if (projection != null) cart.setProjection(projection);
			if (scale != null) cart.setScale(scale);
			subRoot.add(modsFactory.createSubjectTypeCartographics(cart));
		}
		
		@Override
		public SubjectType getElementType() {
			return subType;
		}
	}
	
	public abstract class ElementGroup<R> {
		
		public ElementGroup() {
			getModsGroup().add(getElementType());
		}
		
		public abstract R getElementType();
		
		public void setAttributes(List<Attribute> attrs) {
			setElementAttributes(getElementType(), attrs);
		}
		
		public void setAttribute(Attribute attr) {
			setElementAttribute(getElementType(), attr);
		}
		
		public void setAttribute(String attr, Object value) {
			setElementAttribute(getElementType(), attr, value);
		}
	}
	
	public class Attribute {
		
		private String name;
		private Object value;
		
		public Attribute(String name, Object value) {
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public Object getValue() {
			return value;
		}
	}

	public Location getLocation() {
		if (location == null) location = createLocation();
		return location;
	}

	public Part getPart() {
		if (part == null) part = createPart();
		return part;
	}

	public PhysicalDescription getPhysicalDescription() {
		if (physicalDescription == null) physicalDescription = createPhysicalDescription();
		return physicalDescription;
	}

	public RecordInfo getRecordInfo() {
		if(recordInfo == null) recordInfo = createRecordInfo();
		return recordInfo;
	}

	public RelatedItem getRelatedItem() {
		if(relatedItem == null) relatedItem = createRelatedItem();
		return relatedItem;
	}
	
	public OriginInfo getOriginInfo() {
		if(originInfo == null) originInfo = createOriginInfo();
		return originInfo;
	}

	public TitleInfo getTitleInfo() {
		if(titleInfo == null) titleInfo = createTitleInfo();
		return titleInfo;
	}
	
}
