package fr.hgwood.fanfaron.jsonschema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Schema {
    public String $ref;
    public String format;
    public String description;
    @JsonProperty("default") public Object _default;
    public Properties properties;
    public List<String> required;
    @JsonProperty("enum") public List<Object> _enum;
    public String type;
    public Items items;
    public Schema additionalProperties;
    public Xml xml;
    public Object example;
}
