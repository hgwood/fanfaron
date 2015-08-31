package fr.hgwood.fanfaron;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#exampleObject
 */
public class Example extends ForwardingMap<String, Object> {
    private final Map<String, Object> examples = new HashMap<>();

    @Override protected Map<String, Object> delegate() {
        return examples;
    }
}
