package fr.hgwood.fanfaron.jsonschema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

public class Schema {
    // JSON Schema only properties
    public String id;
    public String $schema;
    public PatternProperties patternProperties;
    public Definitions definitions;
    public Schema not;
    public List<Schema> oneOf;
    public BooleanOrSchema additionalItems;
    public List<Schema> anyOf;

    // JSON Schema properties supported in Swagger 2
    public String $ref;
    public String format;
    public String title;
    public String description;
    @JsonProperty("default") public Object _default;
    public String pattern;
    public BigInteger minItems;
    public Boolean uniqueItems;
    public BigInteger minProperties;
    public Properties properties;
    public List<String> required;
    @JsonProperty("enum") public List<Object> _enum;
    public String type;
    public Schema items;
    public BooleanOrSchema additionalProperties;

    // Swagger 2 extensions
    public Xml xml;
    public Object example;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Schema)) return false;
        Schema other = (Schema)obj;
        return Objects.equals($ref, other.$ref)
            && Objects.equals(format, other.format)
            && Objects.equals(description, other.description)
            && Objects.equals(_default, other._default)
            && Objects.equals(properties, other.properties)
            && Objects.equals(required, other.required)
            && Objects.equals(_enum, other._enum)
            && Objects.equals(type, other.type)
            && Objects.equals(items, other.items)
            && Objects.equals(additionalProperties, other.additionalProperties)
            && Objects.equals(xml, other.xml)
            && Objects.equals(example, other.example);
    }

    @Override public int hashCode() {
        return Objects.hash($ref, format, description, _default, properties, required, _enum, type, items, additionalProperties, xml, example);
    }
}
