package fr.hgwood.fanfaron;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#securityDefinitionsObject
 */
public class SecurityDefinitions extends ForwardingMap<String, SecurityScheme> {
    private final Map<String, SecurityScheme> securitySchemes = new HashMap<>();

    @Override protected Map<String, SecurityScheme> delegate() {
        return securitySchemes;
    }
}
