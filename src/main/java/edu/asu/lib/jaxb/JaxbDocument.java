package edu.asu.lib.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.validation.Schema;

public interface JaxbDocument {

	public abstract Object getRootElement();

	public abstract String getSchemaLocation();

	public abstract Schema getSchema();

	public abstract JAXBContext getContext();

}