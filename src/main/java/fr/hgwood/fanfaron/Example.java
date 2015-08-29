package fr.hgwood.fanfaron;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;

public class Example extends ForwardingMap<String, Object> {

    private final Map<String, Object> examples = new HashMap<>();

    @Override protected Map<String, Object> delegate() {
        return examples;
    }
}
