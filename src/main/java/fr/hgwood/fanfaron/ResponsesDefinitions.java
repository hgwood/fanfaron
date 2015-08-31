package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.utils.DynamicObject;

import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#responsesDefinitionsObject
 */
public class ResponsesDefinitions extends DynamicObject<Response> {
    public ResponsesDefinitions(Map<String, Response> responsesDefinitions) {
        super(responsesDefinitions);
    }

    public ResponsesDefinitions() {
        super();
    }
}
