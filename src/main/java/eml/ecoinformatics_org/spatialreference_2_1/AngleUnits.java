//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.18 at 05:13:02 PM MST 
//


package eml.ecoinformatics_org.spatialreference_2_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for angleUnits.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="angleUnits">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="radian"/>
 *     &lt;enumeration value="degree"/>
 *     &lt;enumeration value="grad"/>
 *     &lt;enumeration value="degree"/>
 *     &lt;enumeration value="grad"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "angleUnits")
@XmlEnum
public enum AngleUnits {

    @XmlEnumValue("radian")
    RADIAN("radian"),
    @XmlEnumValue("degree")
    DEGREE("degree"),
    @XmlEnumValue("grad")
    GRAD("grad");
    private final String value;

    AngleUnits(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AngleUnits fromValue(String v) {
        for (AngleUnits c: AngleUnits.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
