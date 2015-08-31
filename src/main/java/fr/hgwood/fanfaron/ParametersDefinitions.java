package fr.hgwood.fanfaron;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#parametersDefinitionsObject
 */
public class ParametersDefinitions extends ForwardingMap<String, Parameter> {
    private final Map<String, Parameter> parameters = new HashMap<>();

    @Override protected Map<String, Parameter> delegate() {
        return parameters;
    }
}
