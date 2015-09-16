package fr.hgwood.fanfaron;

import com.fasterxml.jackson.annotation.JsonCreator;
import fr.hgwood.fanfaron.utils.DynamicObjectWithVendorExtensions;

import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#scopesObject
 */
public class Scopes extends DynamicObjectWithVendorExtensions<String> {
    @JsonCreator public Scopes(Map<String, String> scopes) {
        super(scopes);
    }

    public Scopes() {
        super();
    }
}
