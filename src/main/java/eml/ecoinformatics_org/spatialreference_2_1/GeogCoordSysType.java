//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.18 at 05:13:02 PM MST 
//


package eml.ecoinformatics_org.spatialreference_2_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for geogCoordSysType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="geogCoordSysType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datum">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="spheroid">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="semiAxisMajor" type="{http://www.w3.org/2001/XMLSchema}float" />
 *                 &lt;attribute name="denomFlatRatio" type="{http://www.w3.org/2001/XMLSchema}float" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="primeMeridian">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="longitude" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *                       &lt;minInclusive value="-180"/>
 *                       &lt;maxInclusive value="180"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="unit">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="name" use="required" type="{eml://ecoinformatics.org/spatialReference-2.1.1}angleUnits" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "geogCoordSysType", propOrder = {
    "datum",
    "spheroid",
    "primeMeridian",
    "unit"
})
public class GeogCoordSysType {

    @XmlElement(required = true)
    protected GeogCoordSysType.Datum datum;
    @XmlElement(required = true)
    protected GeogCoordSysType.Spheroid spheroid;
    @XmlElement(required = true)
    protected GeogCoordSysType.PrimeMeridian primeMeridian;
    @XmlElement(required = true)
    protected GeogCoordSysType.Unit unit;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link GeogCoordSysType.Datum }
     *     
     */
    public GeogCoordSysType.Datum getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeogCoordSysType.Datum }
     *     
     */
    public void setDatum(GeogCoordSysType.Datum value) {
        this.datum = value;
    }

    /**
     * Gets the value of the spheroid property.
     * 
     * @return
     *     possible object is
     *     {@link GeogCoordSysType.Spheroid }
     *     
     */
    public GeogCoordSysType.Spheroid getSpheroid() {
        return spheroid;
    }

    /**
     * Sets the value of the spheroid property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeogCoordSysType.Spheroid }
     *     
     */
    public void setSpheroid(GeogCoordSysType.Spheroid value) {
        this.spheroid = value;
    }

    /**
     * Gets the value of the primeMeridian property.
     * 
     * @return
     *     possible object is
     *     {@link GeogCoordSysType.PrimeMeridian }
     *     
     */
    public GeogCoordSysType.PrimeMeridian getPrimeMeridian() {
        return primeMeridian;
    }

    /**
     * Sets the value of the primeMeridian property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeogCoordSysType.PrimeMeridian }
     *     
     */
    public void setPrimeMeridian(GeogCoordSysType.PrimeMeridian value) {
        this.primeMeridian = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link GeogCoordSysType.Unit }
     *     
     */
    public GeogCoordSysType.Unit getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeogCoordSysType.Unit }
     *     
     */
    public void setUnit(GeogCoordSysType.Unit value) {
        this.unit = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Datum {

        @XmlAttribute(name = "name")
        protected String name;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

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
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="longitude" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
     *             &lt;minInclusive value="-180"/>
     *             &lt;maxInclusive value="180"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class PrimeMeridian {

        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "longitude", required = true)
        protected float longitude;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the longitude property.
         * 
         */
        public float getLongitude() {
            return longitude;
        }

        /**
         * Sets the value of the longitude property.
         * 
         */
        public void setLongitude(float value) {
            this.longitude = value;
        }

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
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="semiAxisMajor" type="{http://www.w3.org/2001/XMLSchema}float" />
     *       &lt;attribute name="denomFlatRatio" type="{http://www.w3.org/2001/XMLSchema}float" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Spheroid {

        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "semiAxisMajor")
        protected Float semiAxisMajor;
        @XmlAttribute(name = "denomFlatRatio")
        protected Float denomFlatRatio;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the semiAxisMajor property.
         * 
         * @return
         *     possible object is
         *     {@link Float }
         *     
         */
        public Float getSemiAxisMajor() {
            return semiAxisMajor;
        }

        /**
         * Sets the value of the semiAxisMajor property.
         * 
         * @param value
         *     allowed object is
         *     {@link Float }
         *     
         */
        public void setSemiAxisMajor(Float value) {
            this.semiAxisMajor = value;
        }

        /**
         * Gets the value of the denomFlatRatio property.
         * 
         * @return
         *     possible object is
         *     {@link Float }
         *     
         */
        public Float getDenomFlatRatio() {
            return denomFlatRatio;
        }

        /**
         * Sets the value of the denomFlatRatio property.
         * 
         * @param value
         *     allowed object is
         *     {@link Float }
         *     
         */
        public void setDenomFlatRatio(Float value) {
            this.denomFlatRatio = value;
        }

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
     *       &lt;attribute name="name" use="required" type="{eml://ecoinformatics.org/spatialReference-2.1.1}angleUnits" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Unit {

        @XmlAttribute(name = "name", required = true)
        protected AngleUnits name;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link AngleUnits }
         *     
         */
        public AngleUnits getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link AngleUnits }
         *     
         */
        public void setName(AngleUnits value) {
            this.name = value;
        }

    }

}
