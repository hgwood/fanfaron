package fr.hgwood.fanfaron;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#pathsObject
 */
public class Paths extends ForwardingMap<String, PathItem> {
    private final Map<String, PathItem> paths = new HashMap<>();

    @Override protected Map<String, PathItem> delegate() {
        return paths;
    }
}
