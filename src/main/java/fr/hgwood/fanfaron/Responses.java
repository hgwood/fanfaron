package fr.hgwood.fanfaron;

import com.fasterxml.jackson.annotation.JsonCreator;
import fr.hgwood.fanfaron.utils.vendorextensions.DynamicObjectWithVendorExtensions;

import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#responsesObject
 */
public class Responses extends DynamicObjectWithVendorExtensions<ResponseOrReference> {
    @JsonCreator public Responses(Map<String, ?> responses) {
        super(responses);
    }

    public Responses() {
        super();
    }
}
