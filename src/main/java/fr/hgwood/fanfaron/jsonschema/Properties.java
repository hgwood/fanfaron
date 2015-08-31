package fr.hgwood.fanfaron.jsonschema;

import fr.hgwood.fanfaron.utils.DynamicObject;

import java.util.Map;

public class Properties extends DynamicObject<Schema> {
    public Properties(Map<String, Schema> properties) {
        super(properties);
    }

    public Properties() {
        super();
    }
}
