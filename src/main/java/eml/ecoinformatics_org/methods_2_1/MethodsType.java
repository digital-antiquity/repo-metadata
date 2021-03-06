//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.18 at 05:13:02 PM MST 
//


package eml.ecoinformatics_org.methods_2_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import eml.ecoinformatics_org.coverage_2_1.Coverage;
import eml.ecoinformatics_org.coverage_2_1.GeographicCoverage;
import eml.ecoinformatics_org.dataset_2_1.DatasetType;
import eml.ecoinformatics_org.literature_2_1.CitationType;
import eml.ecoinformatics_org.text_2_1.TextType;


/**
 * <p>Java class for MethodsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MethodsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="methodStep" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{eml://ecoinformatics.org/methods-2.1.1}ProcedureStepType">
 *                 &lt;sequence>
 *                   &lt;element name="dataSource" type="{eml://ecoinformatics.org/dataset-2.1.1}DatasetType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="sampling" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="studyExtent">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice maxOccurs="unbounded">
 *                             &lt;element name="coverage" type="{eml://ecoinformatics.org/coverage-2.1.1}Coverage"/>
 *                             &lt;element name="description" type="{eml://ecoinformatics.org/text-2.1.1}TextType"/>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="samplingDescription" type="{eml://ecoinformatics.org/text-2.1.1}TextType"/>
 *                   &lt;element name="spatialSamplingUnits" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice maxOccurs="unbounded">
 *                             &lt;element name="referencedEntityId" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                             &lt;element name="coverage" type="{eml://ecoinformatics.org/coverage-2.1.1}GeographicCoverage"/>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="citation" type="{eml://ecoinformatics.org/literature-2.1.1}CitationType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="qualityControl" type="{eml://ecoinformatics.org/methods-2.1.1}ProcedureStepType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MethodsType", propOrder = {
    "methodStepAndSamplingAndQualityControl"
})
public class MethodsType {

    @XmlElements({
        @XmlElement(name = "methodStep", required = true, type = MethodsType.MethodStep.class),
        @XmlElement(name = "sampling", required = true, type = MethodsType.Sampling.class),
        @XmlElement(name = "qualityControl", required = true, type = ProcedureStepType.class)
    })
    protected List<Object> methodStepAndSamplingAndQualityControl;

    /**
     * Gets the value of the methodStepAndSamplingAndQualityControl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the methodStepAndSamplingAndQualityControl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMethodStepAndSamplingAndQualityControl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MethodsType.MethodStep }
     * {@link MethodsType.Sampling }
     * {@link ProcedureStepType }
     * 
     * 
     */
    public List<Object> getMethodStepAndSamplingAndQualityControl() {
        if (methodStepAndSamplingAndQualityControl == null) {
            methodStepAndSamplingAndQualityControl = new ArrayList<Object>();
        }
        return this.methodStepAndSamplingAndQualityControl;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{eml://ecoinformatics.org/methods-2.1.1}ProcedureStepType">
     *       &lt;sequence>
     *         &lt;element name="dataSource" type="{eml://ecoinformatics.org/dataset-2.1.1}DatasetType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dataSource"
    })
    public static class MethodStep
        extends ProcedureStepType
    {

        protected List<DatasetType> dataSource;

        /**
         * Gets the value of the dataSource property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dataSource property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDataSource().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DatasetType }
         * 
         * 
         */
        public List<DatasetType> getDataSource() {
            if (dataSource == null) {
                dataSource = new ArrayList<DatasetType>();
            }
            return this.dataSource;
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
     *       &lt;sequence>
     *         &lt;element name="studyExtent">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice maxOccurs="unbounded">
     *                   &lt;element name="coverage" type="{eml://ecoinformatics.org/coverage-2.1.1}Coverage"/>
     *                   &lt;element name="description" type="{eml://ecoinformatics.org/text-2.1.1}TextType"/>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="samplingDescription" type="{eml://ecoinformatics.org/text-2.1.1}TextType"/>
     *         &lt;element name="spatialSamplingUnits" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice maxOccurs="unbounded">
     *                   &lt;element name="referencedEntityId" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                   &lt;element name="coverage" type="{eml://ecoinformatics.org/coverage-2.1.1}GeographicCoverage"/>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="citation" type="{eml://ecoinformatics.org/literature-2.1.1}CitationType" maxOccurs="unbounded" minOccurs="0"/>
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
        "studyExtent",
        "samplingDescription",
        "spatialSamplingUnits",
        "citation"
    })
    public static class Sampling {

        @XmlElement(required = true)
        protected MethodsType.Sampling.StudyExtent studyExtent;
        @XmlElement(required = true)
        protected TextType samplingDescription;
        protected MethodsType.Sampling.SpatialSamplingUnits spatialSamplingUnits;
        protected List<CitationType> citation;

        /**
         * Gets the value of the studyExtent property.
         * 
         * @return
         *     possible object is
         *     {@link MethodsType.Sampling.StudyExtent }
         *     
         */
        public MethodsType.Sampling.StudyExtent getStudyExtent() {
            return studyExtent;
        }

        /**
         * Sets the value of the studyExtent property.
         * 
         * @param value
         *     allowed object is
         *     {@link MethodsType.Sampling.StudyExtent }
         *     
         */
        public void setStudyExtent(MethodsType.Sampling.StudyExtent value) {
            this.studyExtent = value;
        }

        /**
         * Gets the value of the samplingDescription property.
         * 
         * @return
         *     possible object is
         *     {@link TextType }
         *     
         */
        public TextType getSamplingDescription() {
            return samplingDescription;
        }

        /**
         * Sets the value of the samplingDescription property.
         * 
         * @param value
         *     allowed object is
         *     {@link TextType }
         *     
         */
        public void setSamplingDescription(TextType value) {
            this.samplingDescription = value;
        }

        /**
         * Gets the value of the spatialSamplingUnits property.
         * 
         * @return
         *     possible object is
         *     {@link MethodsType.Sampling.SpatialSamplingUnits }
         *     
         */
        public MethodsType.Sampling.SpatialSamplingUnits getSpatialSamplingUnits() {
            return spatialSamplingUnits;
        }

        /**
         * Sets the value of the spatialSamplingUnits property.
         * 
         * @param value
         *     allowed object is
         *     {@link MethodsType.Sampling.SpatialSamplingUnits }
         *     
         */
        public void setSpatialSamplingUnits(MethodsType.Sampling.SpatialSamplingUnits value) {
            this.spatialSamplingUnits = value;
        }

        /**
         * Gets the value of the citation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the citation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCitation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CitationType }
         * 
         * 
         */
        public List<CitationType> getCitation() {
            if (citation == null) {
                citation = new ArrayList<CitationType>();
            }
            return this.citation;
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
         *       &lt;choice maxOccurs="unbounded">
         *         &lt;element name="referencedEntityId" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *         &lt;element name="coverage" type="{eml://ecoinformatics.org/coverage-2.1.1}GeographicCoverage"/>
         *       &lt;/choice>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "referencedEntityIdOrCoverage"
        })
        public static class SpatialSamplingUnits {

            @XmlElements({
                @XmlElement(name = "referencedEntityId"),
                @XmlElement(name = "coverage", type = GeographicCoverage.class)
            })
            protected List<Object> referencedEntityIdOrCoverage;

            /**
             * Gets the value of the referencedEntityIdOrCoverage property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the referencedEntityIdOrCoverage property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getReferencedEntityIdOrCoverage().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Object }
             * {@link GeographicCoverage }
             * 
             * 
             */
            public List<Object> getReferencedEntityIdOrCoverage() {
                if (referencedEntityIdOrCoverage == null) {
                    referencedEntityIdOrCoverage = new ArrayList<Object>();
                }
                return this.referencedEntityIdOrCoverage;
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
         *       &lt;choice maxOccurs="unbounded">
         *         &lt;element name="coverage" type="{eml://ecoinformatics.org/coverage-2.1.1}Coverage"/>
         *         &lt;element name="description" type="{eml://ecoinformatics.org/text-2.1.1}TextType"/>
         *       &lt;/choice>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "coverageOrDescription"
        })
        public static class StudyExtent {

            @XmlElements({
                @XmlElement(name = "coverage", type = Coverage.class),
                @XmlElement(name = "description", type = TextType.class)
            })
            protected List<Object> coverageOrDescription;

            /**
             * Gets the value of the coverageOrDescription property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the coverageOrDescription property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCoverageOrDescription().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Coverage }
             * {@link TextType }
             * 
             * 
             */
            public List<Object> getCoverageOrDescription() {
                if (coverageOrDescription == null) {
                    coverageOrDescription = new ArrayList<Object>();
                }
                return this.coverageOrDescription;
            }

        }

    }

}
