package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.utils.DynamicObject;

import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#scopesObject
 */
public class Scopes extends DynamicObject<String> {
    public Scopes(Map<String, String> scopes) {
        super(scopes);
    }

    public Scopes() {
        super();
    }
}
