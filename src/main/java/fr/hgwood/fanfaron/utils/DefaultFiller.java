package fr.hgwood.fanfaron.utils;

import fr.hgwood.fanfaron.*;

import java.util.Map;

public class DefaultFiller {

    public Swagger fillDefaults(Swagger swagger) {
        Swagger result = new Swagger();
        result.paths = fillDefaults(swagger.paths);
        result.parameters = fillDefaults(swagger.parameters);
        result.responses = fillDefaults(swagger.responses);
        return result;
    }

    private ResponsesDefinitions fillDefaults(ResponsesDefinitions responsesDefinitions) {
        ResponsesDefinitions result = new ResponsesDefinitions();
        for (Map.Entry<String, Response> entryInResponses : responsesDefinitions.entrySet()) {
            result.put(entryInResponses.getKey(), fillDefaults(entryInResponses.getValue()));
        }
        return result;
    }

    private Response fillDefaults(Response response) {
        Response result = new Response();
        result.schema = fillDefaults(response.schema);
        result.headers = fillDefaults(response.headers);
        return result;
    }

    private Headers fillDefaults(Headers headers) {
        Headers result = new Headers();
        for (Map.Entry<String, Header> entryInHeaders : headers.entrySet()) {
            result.put(entryInHeaders.getKey(), fillDefaults(entryInHeaders.getValue()));
        }
        return result;
    }

    private ParametersDefinitions fillDefaults(ParametersDefinitions parametersDefinitions) {
        ParametersDefinitions result = new ParametersDefinitions();
        for (Map.Entry<String, Parameter> entryInParameters : parametersDefinitions.entrySet()) {
            result.put(entryInParameters.getKey(), fillDefaults(entryInParameters.getValue()));
        }
        return result;
    }

    public Paths fillDefaults(Paths paths) {
        Paths result = new Paths();
        for (Map.Entry<String, PathItem> entryInPaths : paths.entrySet()) {
            result.put(entryInPaths.getKey(), fillDefault(entryInPaths.getValue()));
        }
        return result;
    }

    private PathItem fillDefault(PathItem pathItem) {
        PathItem result = new PathItem();
        result.get = fillDefaults(pathItem.get);
        return result;
    }

    public Operation fillDefaults(Operation operation) {
        Operation result = new Operation();
        result.deprecated = firstNonNull(operation.deprecated, false);
        return result;
    }

    public Parameter fillDefaults(Parameter parameter) {
        Parameter result = new Parameter();
        result.required = firstNonNull(parameter.required, false);
        result.allowEmptyValue = firstNonNull(parameter.allowEmptyValue, false);
        result.collectionFormat = firstNonNull(parameter.collectionFormat, "csv");
        if (parameter.items != null) result.items = fillDefaults(parameter.items);
        return result;
    }

    public Items fillDefaults(Items items) {
        Items result = new Items();
        result.collectionFormat = firstNonNull(items.collectionFormat, "csv");
        return result;
    }

    public Header fillDefaults(Header header) {
        Header result = new Header();
        result.collectionFormat = firstNonNull(header.collectionFormat, "csv");
        return result;
    }

    public Schema fillDefaults(Schema schema) {
        Schema result = new Schema();
        result.readOnly = firstNonNull(schema.readOnly, false);
        if (schema.xml != null) result.xml = fillDefaults(schema.xml);
        return result;
    }

    public Xml fillDefaults(Xml xml) {
        Xml result = new Xml();
        result.attribute = firstNonNull(xml.attribute, false);
        result.wrapped = firstNonNull(xml.wrapped, false);
        return result;
    }

    private <T> T firstNonNull(T a, T b) {
        return a == null ? b : a;
    }
}
