package fr.hgwood.fanfaron.jsonschema;

import fr.hgwood.fanfaron.utils.DynamicObject;

import java.util.Map;

public class Definitions extends DynamicObject<Schema> {
    public Definitions(Map<String, Schema> definitions) {
        super(definitions);
    }

    public Definitions() {
        super();
    }
}
