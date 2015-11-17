package com.github.hgwood.fanfaron;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#schemaObject
 */
public class Schema {
    public String $ref;
    public String format;
    public String title;
    public String description;
    @JsonProperty("default") public Object _default;
    public BigDecimal multipleOf;
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
    public BigInteger maxProperties;
    public BigInteger minProperties;
    public List<String> required;
    @JsonProperty("enum") public List<Object> _enum;
    public String type;
    public SchemaOrListOfSchemas items;
    public List<Schema> allOf;
    public Properties properties;
    public AdditionalProperties additionalProperties;
    public String discriminator;
    public Boolean readOnly;
    public Xml xml;
    public ExternalDocumentation externalDocs;
    public Object example;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Schema)) return false;
        Schema other = (Schema)obj;
        return Objects.equals($ref, other.$ref)
                && Objects.equals(format, other.format)
                && Objects.equals(title, other.title)
                && Objects.equals(description, other.description)
                && Objects.equals(_default, other._default)
                && Objects.equals(multipleOf, other.multipleOf)
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
                && Objects.equals(maxProperties, other.maxProperties)
                && Objects.equals(minProperties, other.minProperties)
                && Objects.equals(required, other.required)
                && Objects.equals(_enum, other._enum)
                && Objects.equals(type, other.type)
                && Objects.equals(items, other.items)
                && Objects.equals(allOf, other.allOf)
                && Objects.equals(properties, other.properties)
                && Objects.equals(additionalProperties, other.additionalProperties)
                && Objects.equals(discriminator, other.discriminator)
                && Objects.equals(readOnly, other.readOnly)
                && Objects.equals(xml, other.xml)
                && Objects.equals(externalDocs, other.externalDocs)
                && Objects.equals(example, other.example);
    }

    @Override public int hashCode() {
        return Objects.hash(
                $ref,
                format,
                title,
                description,
                _default,
                multipleOf,
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
                maxProperties,
                minProperties,
                required,
                _enum,
                type,
                items,
                allOf,
                properties,
                additionalProperties,
                discriminator,
                readOnly,
                xml,
                externalDocs,
                example);
    }
}
