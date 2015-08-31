package fr.hgwood.fanfaron;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#responsesDefinitionsObject
 */
public class ResponsesDefinitions extends ForwardingMap<String, Response> {
    private final Map<String, Response> responses = new HashMap<>();

    @Override protected Map<String, Response> delegate() {
        return responses;
    }
}
