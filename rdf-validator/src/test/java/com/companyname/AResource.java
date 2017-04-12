package com.companyname;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashSet;

import javax.xml.datatype.DatatypeConfigurationException;

import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

import com.companyname.constants.DataType;
import com.companyname.impl.ValidatorImpl;
import com.companyname.shacl.ShaclShape;
import com.companyname.shacl.ShaclShapeFactory;
import com.scania.shacl.annotations.ShaclClassType;
import com.scania.shacl.annotations.ShaclDataType;
import com.scania.shacl.annotations.ShaclIn;
import com.scania.shacl.annotations.ShaclMaxCount;
import com.scania.shacl.annotations.ShaclMaxExclusive;
import com.scania.shacl.annotations.ShaclMaxInclusive;
import com.scania.shacl.annotations.ShaclMaxLength;
import com.scania.shacl.annotations.ShaclMinCount;
import com.scania.shacl.annotations.ShaclMinExclusive;
import com.scania.shacl.annotations.ShaclMinInclusive;
import com.scania.shacl.annotations.ShaclMinLength;
import com.scania.shacl.annotations.ShaclPattern;

import es.weso.schema.Result;

@OslcNamespace(SampleAdaptorConstants.SAMPLEDOMAIN_NAMSPACE)
@OslcName(SampleAdaptorConstants.ARESOURCE)
@OslcResourceShape(title = "AResource Resource Shape", describes = SampleAdaptorConstants.TYPE_ARESOURCE)
public class AResource extends AbstractResource {
	private BigInteger anIntegerProperty;
	private BigInteger anotherIntegerProperty;

	private String aStringProperty;
	private HashSet<Date> aSetOfDates = new HashSet<Date>();
	private Link aReferenceProperty = new Link();

	public AResource() throws URISyntaxException {
		super();
	}

	public AResource(final URI about) throws URISyntaxException {
		super(about);
	}

	@OslcName("anIntegerProperty")
	@OslcPropertyDefinition(SampleAdaptorConstants.SAMPLEDOMAIN_NAMSPACE + "anIntegerProperty")
	@OslcOccurs(Occurs.ExactlyOne)
	@OslcValueType(ValueType.Integer)
	@OslcReadOnly(false)
	@ShaclMinCount(1)
	@ShaclMaxCount(1)
	@ShaclDataType(DataType.Integer)
	@ShaclMaxExclusive(12)
	@ShaclMinExclusive(5)
	@ShaclMaxLength(2)
	@ShaclMinLength(1)
	@ShaclIn(valueType = Integer.class, value = { "5", "7", "9", "12" })
	public BigInteger getAnIntegerProperty() {
		return anIntegerProperty;
	}

	@OslcName("anotherIntegerProperty")
	@OslcPropertyDefinition(SampleAdaptorConstants.SAMPLEDOMAIN_NAMSPACE + "anotherIntegerProperty")
	@OslcOccurs(Occurs.ExactlyOne)
	@OslcValueType(ValueType.Integer)
	@OslcReadOnly(false)
	@ShaclMinCount(1)
	@ShaclMaxCount(1)
	@ShaclDataType(DataType.Integer)
	@ShaclMaxInclusive(12)
	@ShaclMinInclusive(5)
	@ShaclMaxLength(2)
	@ShaclMinLength(1)
	@ShaclIn(valueType = Integer.class, value = { "5", "7", "9", "12" })
	public BigInteger getAnotherIntegerProperty() {
		return anotherIntegerProperty;
	}

	@OslcName("aStringProperty")
	@OslcPropertyDefinition(SampleAdaptorConstants.SAMPLEDOMAIN_NAMSPACE + "aStringProperty")
	@OslcDescription("a Simple Single String Property")
	@OslcValueType(ValueType.String)
	@OslcTitle("a Property")
	@ShaclMinCount(1)
	@ShaclMaxCount(1)
	@ShaclPattern("^B")
	public String getAStringProperty() {
		return aStringProperty;
	}

	@OslcName("aSetOfDates")
	@OslcPropertyDefinition(SampleAdaptorConstants.SAMPLEDOMAIN_NAMSPACE + "aSetOfDates")
	@OslcOccurs(Occurs.OneOrMany)
	@OslcValueType(ValueType.DateTime)
	@OslcReadOnly(false)
	@ShaclMaxCount(2)
	@ShaclMinCount(0)
	public HashSet<Date> getASetOfDates() {
		return aSetOfDates;
	}

	@OslcName("aReferenceProperty")
	@OslcPropertyDefinition(SampleAdaptorConstants.SAMPLEDOMAIN_NAMSPACE + "aReferenceProperty")
	@OslcOccurs(Occurs.ZeroOrOne)
	@OslcValueType(ValueType.Resource)
	@OslcRange({ SampleAdaptorConstants.TYPE_ANOTHERRESOURCE })
	@OslcReadOnly(false)
	@ShaclClassType(SampleAdaptorConstants.SAMPLEDOMAIN_NAMSPACE + SampleAdaptorConstants.ANOTHERRESOURCE)
	public Link getAReferenceProperty() {
		return aReferenceProperty;
	}

	public void setAnIntegerProperty(final BigInteger anIntegerProperty) {
		this.anIntegerProperty = anIntegerProperty;
	}

	public void setAnotherIntegerProperty(final BigInteger anotherIntegerProperty) {
		this.anotherIntegerProperty = anotherIntegerProperty;
	}

	public void setAStringProperty(final String aStringProperty) {
		this.aStringProperty = aStringProperty;
	}

	public void addASetOfDates(final Date aSetOfDates) {
		this.aSetOfDates.add(aSetOfDates);
	}

	public void setASetOfDates(final HashSet<Date> aSetOfDates) {
		this.aSetOfDates.clear();
		if (aSetOfDates != null) {
			this.aSetOfDates.addAll(aSetOfDates);
		}
	}

	public void setAReferenceProperty(final Link aReferenceProperty) {
		this.aReferenceProperty = aReferenceProperty;
	}

	public Result validate() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			DatatypeConfigurationException, OslcCoreApplicationException, URISyntaxException {
		ShaclShape shaclShape = ShaclShapeFactory.createShaclShape(AResource.class);
		return new ValidatorImpl().validate(this, shaclShape);
	}
}
