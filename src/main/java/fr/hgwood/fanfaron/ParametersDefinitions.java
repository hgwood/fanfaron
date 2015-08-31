package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.utils.DynamicObject;

import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#parametersDefinitionsObject
 */
public class ParametersDefinitions extends DynamicObject<Parameter> {
    public ParametersDefinitions(Map<String, Parameter> parametersDefinitions) {
        super(parametersDefinitions);
    }

    public ParametersDefinitions() {
        super();
    }
}
