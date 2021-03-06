//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.18 at 05:13:02 PM MST 
//


package eml.ecoinformatics_org.units_2_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MassUnitType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MassUnitType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="kilogram"/>
 *     &lt;enumeration value="nanogram"/>
 *     &lt;enumeration value="microgram"/>
 *     &lt;enumeration value="milligram"/>
 *     &lt;enumeration value="centigram"/>
 *     &lt;enumeration value="decigram"/>
 *     &lt;enumeration value="gram"/>
 *     &lt;enumeration value="dekagram"/>
 *     &lt;enumeration value="hectogram"/>
 *     &lt;enumeration value="megagram"/>
 *     &lt;enumeration value="tonne"/>
 *     &lt;enumeration value="pound"/>
 *     &lt;enumeration value="ton"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MassUnitType", namespace = "eml://ecoinformatics.org/units-2.1.1")
@XmlEnum
public enum MassUnitType {

    @XmlEnumValue("kilogram")
    KILOGRAM("kilogram"),
    @XmlEnumValue("nanogram")
    NANOGRAM("nanogram"),
    @XmlEnumValue("microgram")
    MICROGRAM("microgram"),
    @XmlEnumValue("milligram")
    MILLIGRAM("milligram"),
    @XmlEnumValue("centigram")
    CENTIGRAM("centigram"),
    @XmlEnumValue("decigram")
    DECIGRAM("decigram"),
    @XmlEnumValue("gram")
    GRAM("gram"),
    @XmlEnumValue("dekagram")
    DEKAGRAM("dekagram"),
    @XmlEnumValue("hectogram")
    HECTOGRAM("hectogram"),
    @XmlEnumValue("megagram")
    MEGAGRAM("megagram"),
    @XmlEnumValue("tonne")
    TONNE("tonne"),
    @XmlEnumValue("pound")
    POUND("pound"),
    @XmlEnumValue("ton")
    TON("ton");
    private final String value;

    MassUnitType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MassUnitType fromValue(String v) {
        for (MassUnitType c: MassUnitType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
