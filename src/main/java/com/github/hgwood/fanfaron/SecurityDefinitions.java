package com.github.hgwood.fanfaron;

import com.github.hgwood.fanfaron.utils.DynamicObject;

import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#securityDefinitionsObject
 */
public class SecurityDefinitions extends DynamicObject<SecurityScheme> {
    public SecurityDefinitions(Map<String, SecurityScheme> securityDefinitions) {
        super(securityDefinitions);
    }

    public SecurityDefinitions() {
        super();
    }
}
