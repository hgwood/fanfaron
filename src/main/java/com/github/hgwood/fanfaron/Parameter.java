package com.github.hgwood.fanfaron;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.hgwood.fanfaron.utils.vendorextensions.WithVendorExtensions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#parameterObject
 */
public class Parameter extends WithVendorExtensions {
    public String name;
    public String in;
    public String description;
    public Boolean required;
    public Schema schema;
    public String type;
    public String format;
    public Boolean allowEmptyValue;
    public Items items;
    public String collectionFormat;
    @JsonProperty("default") public Object _default;
    public BigDecimal maximum;
    public Boolean exclusiveMaximum;
    public BigDecimal minimum;
    public Boolean exclusiveMinimum;
    public BigInteger maxLength;
    public BigInteger minLength;
    public String pattern;
    public BigInteger maxItems;
    public BigInteger minItems;
    public Boolean uniqueItems;
    @JsonProperty("enum") public List<Object> _enum;
    public BigDecimal multipleOf;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Parameter)) return false;
        Parameter other = (Parameter)obj;
        return Objects.equals(name, other.name)
            && Objects.equals(in, other.in)
            && Objects.equals(description, other.description)
            && Objects.equals(required, other.required)
            && Objects.equals(schema, other.schema)
            && Objects.equals(type, other.type)
            && Objects.equals(format, other.format)
            && Objects.equals(allowEmptyValue, other.allowEmptyValue)
            && Objects.equals(items, other.items)
            && Objects.equals(collectionFormat, other.collectionFormat)
            && Objects.equals(_default, other._default)
            && Objects.equals(maximum, other.maximum)
            && Objects.equals(exclusiveMaximum, other.exclusiveMaximum)
            && Objects.equals(minimum, other.minimum)
            && Objects.equals(exclusiveMinimum, other.exclusiveMinimum)
            && Objects.equals(maxLength, other.maxLength)
            && Objects.equals(minLength, other.minLength)
            && Objects.equals(pattern, other.pattern)
            && Objects.equals(maxItems, other.maxItems)
            && Objects.equals(minItems, other.minItems)
            && Objects.equals(uniqueItems, other.uniqueItems)
            && Objects.equals(_enum, other._enum)
            && Objects.equals(multipleOf, other.multipleOf)
            && Objects.equals(vendorExtensions, other.vendorExtensions);
    }

    @Override public int hashCode() {
        return Objects.hash(
            name,
            in,
            description,
            required,
            schema,
            type,
            format,
            allowEmptyValue,
            items,
            collectionFormat,
            _default,
            maximum,
            exclusiveMaximum,
            minimum,
            exclusiveMinimum,
            maxLength,
            minLength,
            pattern,
            maxItems,
            minItems,
            uniqueItems,
            _enum,
            multipleOf,
            vendorExtensions);
    }

    public void copyTo(Parameter destination) {
        destination.name = this.name;
        destination.in = this.in;
        destination.description = this.description;
        destination.required = this.required;
        destination.schema = this.schema;
        destination.type = this.type;
        destination.format = this.format;
        destination.allowEmptyValue = this.allowEmptyValue;
        destination.items = this.items;
        destination.collectionFormat = this.collectionFormat;
        destination.maximum = this.maximum;
        destination.exclusiveMaximum = this.exclusiveMaximum;
        destination.minimum = this.minimum;
        destination.exclusiveMinimum = this.exclusiveMinimum;
        destination.maxLength = this.maxLength;
        destination.minLength = this.minLength;
        destination.pattern = this.pattern;
        destination.maxItems = this.maxItems;
        destination.minItems = this.minItems;
        destination.uniqueItems = this.uniqueItems;
        destination.multipleOf = this.multipleOf;
    }
}
