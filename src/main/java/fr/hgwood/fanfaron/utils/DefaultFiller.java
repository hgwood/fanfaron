package fr.hgwood.fanfaron.utils;

import fr.hgwood.fanfaron.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultFiller {

    public Swagger fillDefaults(Swagger swagger) {
        Swagger result = new Swagger();
        if (swagger.paths != null) result.paths = fillDefaults(swagger.paths);
        if (swagger.parameters != null) result.parameters = fillDefaults(swagger.parameters);
        if (swagger.responses != null) result.responses = fillDefaults(swagger.responses);
        if (swagger.definitions != null) result.definitions = fillDefaults(swagger.definitions);
        return result;
    }

    public Definitions fillDefaults(Definitions definitions) {
        Definitions result = new Definitions();
        for (Map.Entry<String, Schema> entryInDefinitions : definitions.entrySet()) {
            result.put(entryInDefinitions.getKey(), fillDefaults(entryInDefinitions.getValue()));
        }
        return result;
    }

    public ResponsesDefinitions fillDefaults(ResponsesDefinitions responsesDefinitions) {
        ResponsesDefinitions result = new ResponsesDefinitions();
        for (Map.Entry<String, Response> entryInResponses : responsesDefinitions.entrySet()) {
            result.put(entryInResponses.getKey(), fillDefaults(entryInResponses.getValue()));
        }
        return result;
    }

    public Response fillDefaults(Response response) {
        Response result = new Response();
        if (response.schema != null) result.schema = fillDefaults(response.schema);
        if (response.headers != null) result.headers = fillDefaults(response.headers);
        return result;
    }

    public Headers fillDefaults(Headers headers) {
        Headers result = new Headers();
        for (Map.Entry<String, Header> entryInHeaders : headers.entrySet()) {
            result.put(entryInHeaders.getKey(), fillDefaults(entryInHeaders.getValue()));
        }
        return result;
    }

    public ParametersDefinitions fillDefaults(ParametersDefinitions parametersDefinitions) {
        ParametersDefinitions result = new ParametersDefinitions();
        for (Map.Entry<String, Parameter> entryInParameters : parametersDefinitions.entrySet()) {
            result.put(entryInParameters.getKey(), fillDefaults(entryInParameters.getValue()));
        }
        return result;
    }

    public Paths fillDefaults(Paths paths) {
        Paths result = new Paths();
        for (Map.Entry<String, PathItem> entryInPaths : paths.entrySet()) {
            result.put(entryInPaths.getKey(), fillDefaults(entryInPaths.getValue()));
        }
        return result;
    }

    public PathItem fillDefaults(PathItem pathItem) {
        PathItem result = new PathItem();
        if (pathItem.get != null) result.get = fillDefaults(pathItem.get);
        if (pathItem.put != null) result.put = fillDefaults(pathItem.put);
        if (pathItem.post != null) result.post = fillDefaults(pathItem.post);
        if (pathItem.delete != null) result.delete = fillDefaults(pathItem.delete);
        if (pathItem.options != null) result.options = fillDefaults(pathItem.options);
        if (pathItem.head != null) result.head = fillDefaults(pathItem.head);
        if (pathItem.patch != null) result.patch = fillDefaults(pathItem.patch);
        if (pathItem.parameters != null) {
            List<ParameterOrReference> parameters = new ArrayList<>();
            for (ParameterOrReference parameterOrReference : pathItem.parameters) {
                parameters.add(parameterOrReference.$ref == null ?
                    new ParameterOrReference(fillDefaults(parameterOrReference)) :
                    parameterOrReference);
            }
            result.parameters = parameters;
        }
        return result;
    }

    public Operation fillDefaults(Operation operation) {
        Operation result = new Operation();
        result.deprecated = firstNonNull(operation.deprecated, false);
        if (operation.parameters != null) {
            List<ParameterOrReference> parameters = new ArrayList<>();
            for (ParameterOrReference parameterOrReference : operation.parameters) {
                parameters.add(parameterOrReference.$ref == null ?
                    new ParameterOrReference(fillDefaults(parameterOrReference)) :
                    parameterOrReference);
            }
            result.parameters = parameters;
        }
        return result;
    }

    public Parameter fillDefaults(Parameter parameter) {
        Parameter result = new Parameter();
        result.required = firstNonNull(parameter.required, false);
        result.allowEmptyValue = firstNonNull(parameter.allowEmptyValue, false);
        result.collectionFormat = firstNonNull(parameter.collectionFormat, "csv");
        if (parameter.items != null) result.items = fillDefaults(parameter.items);
        if (parameter.schema != null) result.schema = fillDefaults(parameter.schema);
        return result;
    }

    public Items fillDefaults(Items items) {
        Items result = new Items();
        result.collectionFormat = firstNonNull(items.collectionFormat, "csv");
        if (items.items != null) result.items = fillDefaults(items.items);
        return result;
    }

    public Header fillDefaults(Header header) {
        Header result = new Header();
        result.collectionFormat = firstNonNull(header.collectionFormat, "csv");
        if (header.items != null) result.items = fillDefaults(header.items);
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
