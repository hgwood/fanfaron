package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.utils.DynamicObject;

import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#responsesObject
 */
public class Responses extends DynamicObject<Response> {
    public Responses(Map<String, Response> responses) {
        super(responses);
    }

    public Responses() {
        super();
    }
}
