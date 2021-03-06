//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.18 at 05:13:02 PM MST 
//


package eml.ecoinformatics_org.spatialraster_2_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eml.ecoinformatics_org.spatialraster_2_1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SpatialRaster_QNAME = new QName("eml://ecoinformatics.org/spatialRaster-2.1.1", "spatialRaster");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eml.ecoinformatics_org.spatialraster_2_1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DataQuality }
     * 
     */
    public DataQuality createDataQuality() {
        return new DataQuality();
    }

    /**
     * Create an instance of {@link SpatialRasterType }
     * 
     */
    public SpatialRasterType createSpatialRasterType() {
        return new SpatialRasterType();
    }

    /**
     * Create an instance of {@link SpatialRasterType.GeoreferenceInfo }
     * 
     */
    public SpatialRasterType.GeoreferenceInfo createSpatialRasterTypeGeoreferenceInfo() {
        return new SpatialRasterType.GeoreferenceInfo();
    }

    /**
     * Create an instance of {@link BandType }
     * 
     */
    public BandType createBandType() {
        return new BandType();
    }

    /**
     * Create an instance of {@link DataQuality.QuantitativeAccuracyReport }
     * 
     */
    public DataQuality.QuantitativeAccuracyReport createDataQualityQuantitativeAccuracyReport() {
        return new DataQuality.QuantitativeAccuracyReport();
    }

    /**
     * Create an instance of {@link SpatialRasterType.ImageDescription }
     * 
     */
    public SpatialRasterType.ImageDescription createSpatialRasterTypeImageDescription() {
        return new SpatialRasterType.ImageDescription();
    }

    /**
     * Create an instance of {@link SpatialRasterType.GeoreferenceInfo.CornerPoint }
     * 
     */
    public SpatialRasterType.GeoreferenceInfo.CornerPoint createSpatialRasterTypeGeoreferenceInfoCornerPoint() {
        return new SpatialRasterType.GeoreferenceInfo.CornerPoint();
    }

    /**
     * Create an instance of {@link SpatialRasterType.GeoreferenceInfo.ControlPoint }
     * 
     */
    public SpatialRasterType.GeoreferenceInfo.ControlPoint createSpatialRasterTypeGeoreferenceInfoControlPoint() {
        return new SpatialRasterType.GeoreferenceInfo.ControlPoint();
    }

    /**
     * Create an instance of {@link SpatialRasterType.GeoreferenceInfo.BilinearFit }
     * 
     */
    public SpatialRasterType.GeoreferenceInfo.BilinearFit createSpatialRasterTypeGeoreferenceInfoBilinearFit() {
        return new SpatialRasterType.GeoreferenceInfo.BilinearFit();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpatialRasterType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "eml://ecoinformatics.org/spatialRaster-2.1.1", name = "spatialRaster")
    public JAXBElement<SpatialRasterType> createSpatialRaster(SpatialRasterType value) {
        return new JAXBElement<SpatialRasterType>(_SpatialRaster_QNAME, SpatialRasterType.class, null, value);
    }

}
