package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.utils.DynamicObject;

import java.util.Map;

/**
 * http://json-schema.org/latest/json-schema-validation.html#anchor64
 */
public class Properties extends DynamicObject<Schema> {
    public Properties(Map<String, Schema> properties) {
        super(properties);
    }

    public Properties() {
        super();
    }
}
