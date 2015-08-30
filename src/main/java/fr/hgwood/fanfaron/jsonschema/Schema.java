package fr.hgwood.fanfaron.jsonschema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

public class Schema {
    public String id;
    public String $schema;
    public PatternProperties patternProperties;
    public Definitions definitions;
    public Schema not;
    public List<Schema> oneOf;
    public BooleanOrSchema additionalItems;
    public List<Schema> anyOf;

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

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Schema)) return false;
        Schema other = (Schema)obj;
        return Objects.equals(id, other.id)
            && Objects.equals($schema, other.$schema)
            && Objects.equals(patternProperties, other.patternProperties)
            && Objects.equals(definitions, other.definitions)
            && Objects.equals(not, other.not)
            && Objects.equals(oneOf, other.oneOf)
            && Objects.equals(additionalItems, other.additionalItems)
            && Objects.equals(anyOf, other.anyOf)
            && Objects.equals($ref, other.$ref)
            && Objects.equals(format, other.format)
            && Objects.equals(title, other.title)
            && Objects.equals(description, other.description)
            && Objects.equals(_default, other._default)
            && Objects.equals(pattern, other.pattern)
            && Objects.equals(minItems, other.minItems)
            && Objects.equals(uniqueItems, other.uniqueItems)
            && Objects.equals(minProperties, other.minProperties)
            && Objects.equals(properties, other.properties)
            && Objects.equals(required, other.required)
            && Objects.equals(_enum, other._enum)
            && Objects.equals(type, other.type)
            && Objects.equals(items, other.items)
            && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override public int hashCode() {
        return Objects.hash(
            id,
            $schema,
            patternProperties,
            definitions,
            not,
            oneOf,
            additionalItems,
            anyOf,
            $ref,
            format,
            title,
            description,
            _default,
            pattern,
            minItems,
            uniqueItems,
            minProperties,
            properties,
            required,
            _enum,
            type,
            items,
            additionalProperties);
    }
}
