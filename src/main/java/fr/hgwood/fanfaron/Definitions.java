package fr.hgwood.fanfaron;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#definitionsObject
 */
public class Definitions extends ForwardingMap<String, Schema> {
    private final Map<String, Schema> definitions = new HashMap<>();

    @Override protected Map<String, Schema> delegate() {
        return definitions;
    }
}
