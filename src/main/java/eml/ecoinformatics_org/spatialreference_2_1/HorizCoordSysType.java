//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.18 at 05:13:02 PM MST 
//


package eml.ecoinformatics_org.spatialreference_2_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for horizCoordSysType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="horizCoordSysType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="geogCoordSys" type="{eml://ecoinformatics.org/spatialReference-2.1.1}geogCoordSysType"/>
 *         &lt;element name="projCoordSys">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="geogCoordSys" type="{eml://ecoinformatics.org/spatialReference-2.1.1}geogCoordSysType"/>
 *                   &lt;element name="projection">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="parameter" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="unit">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="name" use="required" type="{eml://ecoinformatics.org/spatialReference-2.1.1}lengthUnits" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "horizCoordSysType", propOrder = {
    "geogCoordSys",
    "projCoordSys"
})
public class HorizCoordSysType {

    protected GeogCoordSysType geogCoordSys;
    protected HorizCoordSysType.ProjCoordSys projCoordSys;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the geogCoordSys property.
     * 
     * @return
     *     possible object is
     *     {@link GeogCoordSysType }
     *     
     */
    public GeogCoordSysType getGeogCoordSys() {
        return geogCoordSys;
    }

    /**
     * Sets the value of the geogCoordSys property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeogCoordSysType }
     *     
     */
    public void setGeogCoordSys(GeogCoordSysType value) {
        this.geogCoordSys = value;
    }

    /**
     * Gets the value of the projCoordSys property.
     * 
     * @return
     *     possible object is
     *     {@link HorizCoordSysType.ProjCoordSys }
     *     
     */
    public HorizCoordSysType.ProjCoordSys getProjCoordSys() {
        return projCoordSys;
    }

    /**
     * Sets the value of the projCoordSys property.
     * 
     * @param value
     *     allowed object is
     *     {@link HorizCoordSysType.ProjCoordSys }
     *     
     */
    public void setProjCoordSys(HorizCoordSysType.ProjCoordSys value) {
        this.projCoordSys = value;
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
     *       &lt;sequence>
     *         &lt;element name="geogCoordSys" type="{eml://ecoinformatics.org/spatialReference-2.1.1}geogCoordSysType"/>
     *         &lt;element name="projection">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="parameter" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="unit">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="name" use="required" type="{eml://ecoinformatics.org/spatialReference-2.1.1}lengthUnits" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "geogCoordSys",
        "projection"
    })
    public static class ProjCoordSys {

        @XmlElement(required = true)
        protected GeogCoordSysType geogCoordSys;
        @XmlElement(required = true)
        protected HorizCoordSysType.ProjCoordSys.Projection projection;

        /**
         * Gets the value of the geogCoordSys property.
         * 
         * @return
         *     possible object is
         *     {@link GeogCoordSysType }
         *     
         */
        public GeogCoordSysType getGeogCoordSys() {
            return geogCoordSys;
        }

        /**
         * Sets the value of the geogCoordSys property.
         * 
         * @param value
         *     allowed object is
         *     {@link GeogCoordSysType }
         *     
         */
        public void setGeogCoordSys(GeogCoordSysType value) {
            this.geogCoordSys = value;
        }

        /**
         * Gets the value of the projection property.
         * 
         * @return
         *     possible object is
         *     {@link HorizCoordSysType.ProjCoordSys.Projection }
         *     
         */
        public HorizCoordSysType.ProjCoordSys.Projection getProjection() {
            return projection;
        }

        /**
         * Sets the value of the projection property.
         * 
         * @param value
         *     allowed object is
         *     {@link HorizCoordSysType.ProjCoordSys.Projection }
         *     
         */
        public void setProjection(HorizCoordSysType.ProjCoordSys.Projection value) {
            this.projection = value;
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
         *         &lt;element name="parameter" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="unit">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="name" use="required" type="{eml://ecoinformatics.org/spatialReference-2.1.1}lengthUnits" />
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
        @XmlType(name = "", propOrder = {
            "parameter",
            "unit"
        })
        public static class Projection {

            @XmlElement(required = true)
            protected List<HorizCoordSysType.ProjCoordSys.Projection.Parameter> parameter;
            @XmlElement(required = true)
            protected HorizCoordSysType.ProjCoordSys.Projection.Unit unit;
            @XmlAttribute(name = "name")
            protected String name;

            /**
             * Gets the value of the parameter property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the parameter property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getParameter().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link HorizCoordSysType.ProjCoordSys.Projection.Parameter }
             * 
             * 
             */
            public List<HorizCoordSysType.ProjCoordSys.Projection.Parameter> getParameter() {
                if (parameter == null) {
                    parameter = new ArrayList<HorizCoordSysType.ProjCoordSys.Projection.Parameter>();
                }
                return this.parameter;
            }

            /**
             * Gets the value of the unit property.
             * 
             * @return
             *     possible object is
             *     {@link HorizCoordSysType.ProjCoordSys.Projection.Unit }
             *     
             */
            public HorizCoordSysType.ProjCoordSys.Projection.Unit getUnit() {
                return unit;
            }

            /**
             * Sets the value of the unit property.
             * 
             * @param value
             *     allowed object is
             *     {@link HorizCoordSysType.ProjCoordSys.Projection.Unit }
             *     
             */
            public void setUnit(HorizCoordSysType.ProjCoordSys.Projection.Unit value) {
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
             *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Parameter {

                @XmlAttribute(name = "name", required = true)
                protected String name;
                @XmlAttribute(name = "description")
                protected String description;
                @XmlAttribute(name = "value", required = true)
                @XmlSchemaType(name = "anySimpleType")
                protected String value;

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
                 * Gets the value of the description property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDescription() {
                    return description;
                }

                /**
                 * Sets the value of the description property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDescription(String value) {
                    this.description = value;
                }

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
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
             *       &lt;attribute name="name" use="required" type="{eml://ecoinformatics.org/spatialReference-2.1.1}lengthUnits" />
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
                protected LengthUnits name;

                /**
                 * Gets the value of the name property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link LengthUnits }
                 *     
                 */
                public LengthUnits getName() {
                    return name;
                }

                /**
                 * Sets the value of the name property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link LengthUnits }
                 *     
                 */
                public void setName(LengthUnits value) {
                    this.name = value;
                }

            }

        }

    }

}
