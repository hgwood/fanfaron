package fr.hgwood.fanfaron.jsonschema;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;

public class Properties extends ForwardingMap<String, Schema> {

    private final Map<String, Schema> properties = new HashMap<>();

    @Override protected Map<String, Schema> delegate() {
        return properties;
    }
}
