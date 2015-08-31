package fr.hgwood.fanfaron;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#headersObject
 */
public class Headers extends ForwardingMap<String, Header> {
    private final Map<String, Header> headers = new HashMap<>();

    @Override protected Map<String, Header> delegate() {
        return headers;
    }
}
