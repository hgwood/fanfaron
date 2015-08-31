package fr.hgwood.fanfaron;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#scopesObject
 */
public class Scopes extends ForwardingMap<String, String> {
    private final Map<String, String> scopes = new HashMap<>();

    @Override protected Map<String, String> delegate() {
        return scopes;
    }
}
