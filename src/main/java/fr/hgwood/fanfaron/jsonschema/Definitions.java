package fr.hgwood.fanfaron.jsonschema;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;

public class Definitions extends ForwardingMap<String, Schema> {

    private final Map<String, Schema> definitions = new HashMap<>();

    @Override protected Map<String, Schema> delegate() {
        return definitions;
    }
}
