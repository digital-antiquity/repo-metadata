package edu.asu.lib.eml;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import edu.asu.lib.dc.DublinCoreDocument;
import edu.asu.lib.jaxb.JaxbDocument;
import eml.ecoinformatics_org.access_2_1.AccessType;
import eml.ecoinformatics_org.dataset_2_1.DatasetType;
import eml.ecoinformatics_org.eml_2_1.Eml.AdditionalMetadata;
import eml.ecoinformatics_org.literature_2_1.CitationType;
import eml.ecoinformatics_org.protocol_2_1.ProtocolType;
import eml.ecoinformatics_org.resource_2_1.I18NNonEmptyStringType;
import eml.ecoinformatics_org.resource_2_1.ScopeType;
import eml.ecoinformatics_org.software_2_1.SoftwareType;
import eml.ecoinformatics_org.text_2_1.TextType;

@XmlRootElement(name = "eml", namespace = EMLDocument.EML_SCHEMA_NAMESPACE)
public class EMLDocument implements JaxbDocument {

    private static JAXBContext context;
    private static Schema schema;

    private static final Logger log = LoggerFactory.getLogger(EMLDocument.class);

    public static final String EML_SCHEMA_NAMESPACE = "eml://ecoinformatics.org/eml-2.1.1";
    public static final String EML_SCHEMA_URL = "eml://ecoinformatics.org/eml-2.1.1 eml.xsd";
    public static final String EML_SCHEMA_LOCATION = String.format("%s %s", EML_SCHEMA_NAMESPACE, EML_SCHEMA_URL);
    public static final String DC_NAMESPACE = "http://purl.org/dc/elements/1.1/";
    private AccessType access;
    private CitationType citation;
    private List<AdditionalMetadata> additionalMetadata;
    private DatasetType dataset;
    private String lang;
    private String packageId;
    private ProtocolType protocol;
    private ScopeType scope;
    private SoftwareType software;
    private List<String> system;
    eml.ecoinformatics_org.eml_2_1.ObjectFactory objectFactory = new eml.ecoinformatics_org.eml_2_1.ObjectFactory();
    eml.ecoinformatics_org.literature_2_1.ObjectFactory literatureFactory = new eml.ecoinformatics_org.literature_2_1.ObjectFactory();
    eml.ecoinformatics_org.text_2_1.ObjectFactory textFactory = new eml.ecoinformatics_org.text_2_1.ObjectFactory();
    eml.ecoinformatics_org.resource_2_1.ObjectFactory resourceFactory = new eml.ecoinformatics_org.resource_2_1.ObjectFactory();

    public eml.ecoinformatics_org.text_2_1.ObjectFactory getTextObjectFactory() {
        return textFactory;
    }

    public eml.ecoinformatics_org.literature_2_1.ObjectFactory getLiteratureObjectFactory() {
        return literatureFactory;
    }

    public eml.ecoinformatics_org.eml_2_1.ObjectFactory getObjectFactory() {
        return objectFactory;
    }

    public I18NNonEmptyStringType createNonEmptyStringType(String val) {
        I18NNonEmptyStringType stringType = resourceFactory.createI18NNonEmptyStringType();
        stringType.setLang(val);
        stringType.getContent().add(val);
        return stringType;
    }

    public eml.ecoinformatics_org.resource_2_1.ObjectFactory getResourceObjectFactory() {
        return resourceFactory;
    }

    public AccessType getAccess() {
        return access;
    }

    public void setAccess(AccessType access) {
        this.access = access;
    }

    public CitationType getCitation() {
        if (citation == null) {
            citation = getLiteratureObjectFactory().createCitationType();
        }
        return citation;
    }

    public void setCitation(CitationType citation) {
        this.citation = citation;
    }

    public List<AdditionalMetadata> getAdditionalMetadata() {
        return additionalMetadata;
    }

    public void setAdditionalMetadata(List<AdditionalMetadata> additionalMetadata) {
        this.additionalMetadata = additionalMetadata;
    }

    public DatasetType getDataset() {
        return dataset;
    }

    public void setDataset(DatasetType dataset) {
        this.dataset = dataset;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public ProtocolType getProtocol() {
        return protocol;
    }

    public void setProtocol(ProtocolType protocol) {
        this.protocol = protocol;
    }

    public ScopeType getScope() {
        return scope;
    }

    public void setScope(ScopeType scope) {
        this.scope = scope;
    }

    public SoftwareType getSoftware() {
        return software;
    }

    public void setSoftware(SoftwareType software) {
        this.software = software;
    }

    public List<String> getSystem() {
        return system;
    }

    public void setSystem(List<String> system) {
        this.system = system;
    }

    public EMLDocument() {
        eml.ecoinformatics_org.eml_2_1.ObjectFactory of = new eml.ecoinformatics_org.eml_2_1.ObjectFactory();
    }

    static {
        try {
            context = JAXBContext.newInstance(EMLDocument.class);
        } catch (JAXBException e) {
            throw new RuntimeException("Failed to create the JAXB context for EmlDocument", e);
        }
        SchemaFactory sfact = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        InputStream schemaStream = DublinCoreDocument.class.getResourceAsStream("/eml/eml.xsd");
        if (schemaStream != null) {
            try {
                schema = sfact.newSchema(new StreamSource(schemaStream));
            } catch (SAXException e) {
                log.debug("Failed to parse schema.", e);
            }
        }
        if (schema == null) {
            try {
                schema = sfact.newSchema(new URL(EML_SCHEMA_URL));
            } catch (SAXException e1) {
                log.debug("Failed to parse schema.", e1);
                schema = null;
            } catch (MalformedURLException e1) {
                log.debug("The OAIDC_SCHEMA_URL " + EML_SCHEMA_URL + " is bad.");
                schema = null;
            }
        }
    }

    public JAXBContext getContext() {
        return context;
    }

    public Schema getSchema() {
        return schema;
    }

    public Object getRootElement() {
        return this;
    }

    public String getSchemaLocation() {
        return EML_SCHEMA_LOCATION;
    }

    public TextType createTextType(String description) {
        TextType type = new TextType();
//        type.setLang("EN_us");
        type.getContent().add(description);
        return type;
    }
}
