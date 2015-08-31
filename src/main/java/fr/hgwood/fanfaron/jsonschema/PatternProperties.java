package fr.hgwood.fanfaron.jsonschema;

import fr.hgwood.fanfaron.utils.DynamicObject;

import java.util.Map;

public class PatternProperties extends DynamicObject<Schema> {
    public PatternProperties(Map<String, Schema> patternProperties) {
        super(patternProperties);
    }

    public PatternProperties() {
        super();
    }
}
