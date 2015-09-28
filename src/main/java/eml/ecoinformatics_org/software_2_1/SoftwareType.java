//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.18 at 05:13:02 PM MST 
//


package eml.ecoinformatics_org.software_2_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import eml.ecoinformatics_org.coverage_2_1.Coverage;
import eml.ecoinformatics_org.party_2_1.ResponsibleParty;
import eml.ecoinformatics_org.physical_2_1.PhysicalDistributionType;
import eml.ecoinformatics_org.project_2_1.ResearchProjectType;
import eml.ecoinformatics_org.resource_2_1.DistributionType;
import eml.ecoinformatics_org.resource_2_1.I18NNonEmptyStringType;
import eml.ecoinformatics_org.resource_2_1.ScopeType;
import eml.ecoinformatics_org.text_2_1.TextType;


/**
 * <p>Java class for SoftwareType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SoftwareType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;group ref="{eml://ecoinformatics.org/resource-2.1.1}ResourceGroup"/>
 *           &lt;element name="implementation" maxOccurs="unbounded">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="distribution" type="{eml://ecoinformatics.org/physical-2.1.1}PhysicalDistributionType" maxOccurs="unbounded"/>
 *                     &lt;element name="size" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" minOccurs="0"/>
 *                     &lt;element name="language" maxOccurs="unbounded" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="LanguageValue" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType"/>
 *                               &lt;element name="LanguageCodeStandard" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" minOccurs="0"/>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="operatingSystem" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="machineProcessor" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="virtualMachine" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" minOccurs="0"/>
 *                     &lt;element name="diskUsage" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" minOccurs="0"/>
 *                     &lt;element name="runtimeMemoryUsage" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" minOccurs="0"/>
 *                     &lt;element name="programmingLanguage" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="checksum" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" minOccurs="0"/>
 *                     &lt;element ref="{eml://ecoinformatics.org/software-2.1.1}dependency" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element ref="{eml://ecoinformatics.org/software-2.1.1}dependency" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;choice maxOccurs="unbounded" minOccurs="0">
 *             &lt;element name="licenseURL" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType"/>
 *             &lt;element name="license" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType"/>
 *           &lt;/choice>
 *           &lt;element name="version" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType"/>
 *           &lt;element name="project" type="{eml://ecoinformatics.org/project-2.1.1}ResearchProjectType" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;group ref="{eml://ecoinformatics.org/resource-2.1.1}ReferencesGroup"/>
 *       &lt;/choice>
 *       &lt;attribute name="id" type="{eml://ecoinformatics.org/resource-2.1.1}IDType" />
 *       &lt;attribute name="system" type="{eml://ecoinformatics.org/resource-2.1.1}SystemType" />
 *       &lt;attribute name="scope" type="{eml://ecoinformatics.org/resource-2.1.1}ScopeType" default="document" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoftwareType", propOrder = {
    "alternateIdentifier",
    "shortName",
    "title",
    "creator",
    "metadataProvider",
    "associatedParty",
    "pubDate",
    "language",
    "series",
    "_abstract",
    "keywordSet",
    "additionalInfo",
    "intellectualRights",
    "distribution",
    "coverage",
    "implementation",
    "dependency",
    "licenseURLOrLicense",
    "version",
    "project",
    "references"
})
public class SoftwareType {

    protected List<eml.ecoinformatics_org.protocol_2_1.ProtocolType.AlternateIdentifier> alternateIdentifier;
    protected String shortName;
    protected List<I18NNonEmptyStringType> title;
    protected List<ResponsibleParty> creator;
    protected List<ResponsibleParty> metadataProvider;
    protected List<eml.ecoinformatics_org.protocol_2_1.ProtocolType.AssociatedParty> associatedParty;
    protected String pubDate;
    protected I18NNonEmptyStringType language;
    protected String series;
    @XmlElement(name = "abstract")
    protected TextType _abstract;
    protected List<eml.ecoinformatics_org.protocol_2_1.ProtocolType.KeywordSet> keywordSet;
    protected List<TextType> additionalInfo;
    protected TextType intellectualRights;
    protected List<DistributionType> distribution;
    protected Coverage coverage;
    protected List<SoftwareType.Implementation> implementation;
    @XmlElement(namespace = "eml://ecoinformatics.org/software-2.1.1")
    protected List<Dependency> dependency;
    @XmlElementRefs({
        @XmlElementRef(name = "license", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "licenseURL", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> licenseURLOrLicense;
    protected String version;
    protected ResearchProjectType project;
    protected eml.ecoinformatics_org.view_2_1.ViewType.References references;
    @XmlAttribute(name = "id")
    protected List<String> id;
    @XmlAttribute(name = "system")
    protected List<String> system;
    @XmlAttribute(name = "scope")
    protected ScopeType scope;

    /**
     * Gets the value of the alternateIdentifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alternateIdentifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlternateIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link eml.ecoinformatics_org.protocol_2_1.ProtocolType.AlternateIdentifier }
     * 
     * 
     */
    public List<eml.ecoinformatics_org.protocol_2_1.ProtocolType.AlternateIdentifier> getAlternateIdentifier() {
        if (alternateIdentifier == null) {
            alternateIdentifier = new ArrayList<eml.ecoinformatics_org.protocol_2_1.ProtocolType.AlternateIdentifier>();
        }
        return this.alternateIdentifier;
    }

    /**
     * Gets the value of the shortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets the value of the shortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortName(String value) {
        this.shortName = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the title property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTitle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link I18NNonEmptyStringType }
     * 
     * 
     */
    public List<I18NNonEmptyStringType> getTitle() {
        if (title == null) {
            title = new ArrayList<I18NNonEmptyStringType>();
        }
        return this.title;
    }

    /**
     * Gets the value of the creator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResponsibleParty }
     * 
     * 
     */
    public List<ResponsibleParty> getCreator() {
        if (creator == null) {
            creator = new ArrayList<ResponsibleParty>();
        }
        return this.creator;
    }

    /**
     * Gets the value of the metadataProvider property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metadataProvider property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetadataProvider().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResponsibleParty }
     * 
     * 
     */
    public List<ResponsibleParty> getMetadataProvider() {
        if (metadataProvider == null) {
            metadataProvider = new ArrayList<ResponsibleParty>();
        }
        return this.metadataProvider;
    }

    /**
     * Gets the value of the associatedParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the associatedParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssociatedParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link eml.ecoinformatics_org.protocol_2_1.ProtocolType.AssociatedParty }
     * 
     * 
     */
    public List<eml.ecoinformatics_org.protocol_2_1.ProtocolType.AssociatedParty> getAssociatedParty() {
        if (associatedParty == null) {
            associatedParty = new ArrayList<eml.ecoinformatics_org.protocol_2_1.ProtocolType.AssociatedParty>();
        }
        return this.associatedParty;
    }

    /**
     * Gets the value of the pubDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPubDate() {
        return pubDate;
    }

    /**
     * Sets the value of the pubDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPubDate(String value) {
        this.pubDate = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link I18NNonEmptyStringType }
     *     
     */
    public I18NNonEmptyStringType getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link I18NNonEmptyStringType }
     *     
     */
    public void setLanguage(I18NNonEmptyStringType value) {
        this.language = value;
    }

    /**
     * Gets the value of the series property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeries() {
        return series;
    }

    /**
     * Sets the value of the series property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeries(String value) {
        this.series = value;
    }

    /**
     * Gets the value of the abstract property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAbstract() {
        return _abstract;
    }

    /**
     * Sets the value of the abstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAbstract(TextType value) {
        this._abstract = value;
    }

    /**
     * Gets the value of the keywordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keywordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeywordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link eml.ecoinformatics_org.protocol_2_1.ProtocolType.KeywordSet }
     * 
     * 
     */
    public List<eml.ecoinformatics_org.protocol_2_1.ProtocolType.KeywordSet> getKeywordSet() {
        if (keywordSet == null) {
            keywordSet = new ArrayList<eml.ecoinformatics_org.protocol_2_1.ProtocolType.KeywordSet>();
        }
        return this.keywordSet;
    }

    /**
     * Gets the value of the additionalInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getAdditionalInfo() {
        if (additionalInfo == null) {
            additionalInfo = new ArrayList<TextType>();
        }
        return this.additionalInfo;
    }

    /**
     * Gets the value of the intellectualRights property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getIntellectualRights() {
        return intellectualRights;
    }

    /**
     * Sets the value of the intellectualRights property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setIntellectualRights(TextType value) {
        this.intellectualRights = value;
    }

    /**
     * Gets the value of the distribution property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the distribution property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistribution().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributionType }
     * 
     * 
     */
    public List<DistributionType> getDistribution() {
        if (distribution == null) {
            distribution = new ArrayList<DistributionType>();
        }
        return this.distribution;
    }

    /**
     * Gets the value of the coverage property.
     * 
     * @return
     *     possible object is
     *     {@link Coverage }
     *     
     */
    public Coverage getCoverage() {
        return coverage;
    }

    /**
     * Sets the value of the coverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Coverage }
     *     
     */
    public void setCoverage(Coverage value) {
        this.coverage = value;
    }

    /**
     * Gets the value of the implementation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the implementation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImplementation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoftwareType.Implementation }
     * 
     * 
     */
    public List<SoftwareType.Implementation> getImplementation() {
        if (implementation == null) {
            implementation = new ArrayList<SoftwareType.Implementation>();
        }
        return this.implementation;
    }

    /**
     * Gets the value of the dependency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dependency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDependency().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Dependency }
     * 
     * 
     */
    public List<Dependency> getDependency() {
        if (dependency == null) {
            dependency = new ArrayList<Dependency>();
        }
        return this.dependency;
    }

    /**
     * Gets the value of the licenseURLOrLicense property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the licenseURLOrLicense property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLicenseURLOrLicense().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getLicenseURLOrLicense() {
        if (licenseURLOrLicense == null) {
            licenseURLOrLicense = new ArrayList<JAXBElement<String>>();
        }
        return this.licenseURLOrLicense;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the project property.
     * 
     * @return
     *     possible object is
     *     {@link ResearchProjectType }
     *     
     */
    public ResearchProjectType getProject() {
        return project;
    }

    /**
     * Sets the value of the project property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearchProjectType }
     *     
     */
    public void setProject(ResearchProjectType value) {
        this.project = value;
    }

    /**
     * Gets the value of the references property.
     * 
     * @return
     *     possible object is
     *     {@link eml.ecoinformatics_org.view_2_1.ViewType.References }
     *     
     */
    public eml.ecoinformatics_org.view_2_1.ViewType.References getReferences() {
        return references;
    }

    /**
     * Sets the value of the references property.
     * 
     * @param value
     *     allowed object is
     *     {@link eml.ecoinformatics_org.view_2_1.ViewType.References }
     *     
     */
    public void setReferences(eml.ecoinformatics_org.view_2_1.ViewType.References value) {
        this.references = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the id property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getId() {
        if (id == null) {
            id = new ArrayList<String>();
        }
        return this.id;
    }

    /**
     * Gets the value of the system property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the system property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSystem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSystem() {
        if (system == null) {
            system = new ArrayList<String>();
        }
        return this.system;
    }

    /**
     * Gets the value of the scope property.
     * 
     * @return
     *     possible object is
     *     {@link ScopeType }
     *     
     */
    public ScopeType getScope() {
        if (scope == null) {
            return ScopeType.DOCUMENT;
        } else {
            return scope;
        }
    }

    /**
     * Sets the value of the scope property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScopeType }
     *     
     */
    public void setScope(ScopeType value) {
        this.scope = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="distribution" type="{eml://ecoinformatics.org/physical-2.1.1}PhysicalDistributionType" maxOccurs="unbounded"/>
     *         &lt;element name="size" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" minOccurs="0"/>
     *         &lt;element name="language" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="LanguageValue" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType"/>
     *                   &lt;element name="LanguageCodeStandard" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="operatingSystem" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="machineProcessor" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="virtualMachine" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" minOccurs="0"/>
     *         &lt;element name="diskUsage" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" minOccurs="0"/>
     *         &lt;element name="runtimeMemoryUsage" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" minOccurs="0"/>
     *         &lt;element name="programmingLanguage" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="checksum" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" minOccurs="0"/>
     *         &lt;element ref="{eml://ecoinformatics.org/software-2.1.1}dependency" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "distribution",
        "size",
        "language",
        "operatingSystem",
        "machineProcessor",
        "virtualMachine",
        "diskUsage",
        "runtimeMemoryUsage",
        "programmingLanguage",
        "checksum",
        "dependency"
    })
    public static class Implementation {

        @XmlElement(required = true)
        protected List<PhysicalDistributionType> distribution;
        protected String size;
        protected List<SoftwareType.Implementation.Language> language;
        protected List<String> operatingSystem;
        protected List<String> machineProcessor;
        protected String virtualMachine;
        protected String diskUsage;
        protected String runtimeMemoryUsage;
        protected List<String> programmingLanguage;
        protected String checksum;
        @XmlElement(namespace = "eml://ecoinformatics.org/software-2.1.1")
        protected List<Dependency> dependency;

        /**
         * Gets the value of the distribution property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the distribution property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDistribution().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PhysicalDistributionType }
         * 
         * 
         */
        public List<PhysicalDistributionType> getDistribution() {
            if (distribution == null) {
                distribution = new ArrayList<PhysicalDistributionType>();
            }
            return this.distribution;
        }

        /**
         * Gets the value of the size property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSize() {
            return size;
        }

        /**
         * Sets the value of the size property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSize(String value) {
            this.size = value;
        }

        /**
         * Gets the value of the language property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the language property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLanguage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SoftwareType.Implementation.Language }
         * 
         * 
         */
        public List<SoftwareType.Implementation.Language> getLanguage() {
            if (language == null) {
                language = new ArrayList<SoftwareType.Implementation.Language>();
            }
            return this.language;
        }

        /**
         * Gets the value of the operatingSystem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the operatingSystem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOperatingSystem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getOperatingSystem() {
            if (operatingSystem == null) {
                operatingSystem = new ArrayList<String>();
            }
            return this.operatingSystem;
        }

        /**
         * Gets the value of the machineProcessor property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the machineProcessor property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMachineProcessor().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getMachineProcessor() {
            if (machineProcessor == null) {
                machineProcessor = new ArrayList<String>();
            }
            return this.machineProcessor;
        }

        /**
         * Gets the value of the virtualMachine property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVirtualMachine() {
            return virtualMachine;
        }

        /**
         * Sets the value of the virtualMachine property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVirtualMachine(String value) {
            this.virtualMachine = value;
        }

        /**
         * Gets the value of the diskUsage property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDiskUsage() {
            return diskUsage;
        }

        /**
         * Sets the value of the diskUsage property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDiskUsage(String value) {
            this.diskUsage = value;
        }

        /**
         * Gets the value of the runtimeMemoryUsage property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRuntimeMemoryUsage() {
            return runtimeMemoryUsage;
        }

        /**
         * Sets the value of the runtimeMemoryUsage property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRuntimeMemoryUsage(String value) {
            this.runtimeMemoryUsage = value;
        }

        /**
         * Gets the value of the programmingLanguage property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the programmingLanguage property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProgrammingLanguage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getProgrammingLanguage() {
            if (programmingLanguage == null) {
                programmingLanguage = new ArrayList<String>();
            }
            return this.programmingLanguage;
        }

        /**
         * Gets the value of the checksum property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getChecksum() {
            return checksum;
        }

        /**
         * Sets the value of the checksum property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setChecksum(String value) {
            this.checksum = value;
        }

        /**
         * Gets the value of the dependency property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dependency property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDependency().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Dependency }
         * 
         * 
         */
        public List<Dependency> getDependency() {
            if (dependency == null) {
                dependency = new ArrayList<Dependency>();
            }
            return this.dependency;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="LanguageValue" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType"/>
         *         &lt;element name="LanguageCodeStandard" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "languageValue",
            "languageCodeStandard"
        })
        public static class Language {

            @XmlElement(name = "LanguageValue", required = true)
            protected String languageValue;
            @XmlElement(name = "LanguageCodeStandard")
            protected String languageCodeStandard;

            /**
             * Gets the value of the languageValue property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLanguageValue() {
                return languageValue;
            }

            /**
             * Sets the value of the languageValue property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLanguageValue(String value) {
                this.languageValue = value;
            }

            /**
             * Gets the value of the languageCodeStandard property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLanguageCodeStandard() {
                return languageCodeStandard;
            }

            /**
             * Sets the value of the languageCodeStandard property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLanguageCodeStandard(String value) {
                this.languageCodeStandard = value;
            }

        }

    }

}