package fr.hgwood.fanfaron;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

public class Parameter {
    public String $ref;
    public String name;
    public String in;
    public String description;
    public boolean required = false;
    public Schema schema;
    public String type;
    public String format;
    public Boolean allowEmptyValue;
    public Items items;
    public String collectionFormat;
    @JsonProperty("default") public Object _default;
    public BigDecimal maximum;
    public Boolean exclusiveMaximum = false;
    public BigDecimal minimum;
    public Boolean exclusiveMinimum = false;
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
        return Objects.equals($ref, other.$ref)
            && Objects.equals(name, other.name)
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
            && Objects.equals(multipleOf, other.multipleOf);
    }

    @Override public int hashCode() {
        return Objects.hash(
            $ref,
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
            multipleOf);
    }
}
