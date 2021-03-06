//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.18 at 05:13:02 PM MST 
//


package eml.ecoinformatics_org.literature_2_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import eml.ecoinformatics_org.party_2_1.Address;


/**
 * <p>Java class for ConferenceProceedings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConferenceProceedings">
 *   &lt;complexContent>
 *     &lt;extension base="{eml://ecoinformatics.org/literature-2.1.1}Chapter">
 *       &lt;sequence>
 *         &lt;element name="conferenceName" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" minOccurs="0"/>
 *         &lt;element name="conferenceDate" type="{eml://ecoinformatics.org/resource-2.1.1}NonEmptyStringType" minOccurs="0"/>
 *         &lt;element name="conferenceLocation" type="{eml://ecoinformatics.org/party-2.1.1}Address" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConferenceProceedings", propOrder = {
    "conferenceName",
    "conferenceDate",
    "conferenceLocation"
})
public class ConferenceProceedings
    extends Chapter
{

    protected String conferenceName;
    protected String conferenceDate;
    protected Address conferenceLocation;

    /**
     * Gets the value of the conferenceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConferenceName() {
        return conferenceName;
    }

    /**
     * Sets the value of the conferenceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConferenceName(String value) {
        this.conferenceName = value;
    }

    /**
     * Gets the value of the conferenceDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConferenceDate() {
        return conferenceDate;
    }

    /**
     * Sets the value of the conferenceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConferenceDate(String value) {
        this.conferenceDate = value;
    }

    /**
     * Gets the value of the conferenceLocation property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getConferenceLocation() {
        return conferenceLocation;
    }

    /**
     * Sets the value of the conferenceLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setConferenceLocation(Address value) {
        this.conferenceLocation = value;
    }

}
