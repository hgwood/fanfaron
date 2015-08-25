package fr.hgwood.fanfaron.jsonschema;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class PatternProperties extends ForwardingMap<String, Schema> {

    private final Map<String, Schema> patternProperties = new HashMap<>();

    @Override protected Map<String, Schema> delegate() {
        return patternProperties;
    }

}
