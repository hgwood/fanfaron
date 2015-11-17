package com.github.hgwood.fanfaron.utils.traversal;

import com.github.hgwood.fanfaron.*;

import java.util.Map;

public class SideEffectingDepthFirstVisit {

    private final Visitor visitor;

    public SideEffectingDepthFirstVisit(Visitor visitor) {
        this.visitor = visitor;
    }

    public void traverse(AdditionalProperties additionalProperties) {
        if (additionalProperties.schema != null) traverse(additionalProperties.schema);
        visitor.visit(additionalProperties);
    }

    public void traverse(Contact contact) {
        visitor.visit(contact);
    }

    public void traverse(Definitions definitions) {
        for (Map.Entry<String, Schema> entryInDefinitions : definitions.entrySet()) {
            traverse(entryInDefinitions.getValue(), entryInDefinitions.getKey());
        }
        visitor.visit(definitions);
    }

    public void traverse(Example example) {
        visitor.visit(example);
    }

    public void traverse(ExternalDocumentation externalDocumentation) {
        visitor.visit(externalDocumentation);
    }

    public void traverse(Header header) {
        if (header.items != null) traverse(header.items);
        visitor.visit(header);
    }

    public void traverse(Headers headers) {
        for (Map.Entry<String, Header> entryInHeaders : headers.entrySet()) {
            traverse(entryInHeaders.getValue());
        }
        visitor.visit(headers);
    }

    public void traverse(Info info) {
        if (info.contact != null) traverse(info.contact);
        if (info.license != null) traverse(info.license);
        visitor.visit(info);
    }

    public void traverse(Items items) {
        if (items.items != null) traverse(items.items);
        visitor.visit(items);
    }

    public void traverse(License license) {
        visitor.visit(license);
    }

    public void traverse(Operation operation) {
        if (operation.externalDocs != null) traverse(operation.externalDocs);
        if (operation.parameters != null) {
            for (ParameterOrReference parameterOrReference : operation.parameters) {
                traverse(parameterOrReference);
            }
        }
        if (operation.responses != null) traverse(operation.responses);
        if (operation.security != null) {
            for (SecurityRequirement securityRequirement : operation.security) {
                traverse(securityRequirement);
            }
        }
        visitor.visit(operation);
    }

    public void traverse(Parameter parameter, String name) {
        if (parameter.schema != null) traverse(parameter.schema);
        if (parameter.items != null) traverse(parameter.items);
        visitor.visit(parameter, name);
    }

    public void traverse(ParameterOrReference parameterOrReference) {
        if (parameterOrReference.schema != null) traverse(parameterOrReference.schema);
        if (parameterOrReference.items != null) traverse(parameterOrReference.items);
        visitor.visit(parameterOrReference);
    }

    public void traverse(ParametersDefinitions parametersDefinitions) {
        for (Map.Entry<String, Parameter> entryInParameters : parametersDefinitions.entrySet()) {
            traverse(entryInParameters.getValue(), entryInParameters.getKey());
        }
        visitor.visit(parametersDefinitions);
    }

    public void traverse(PathItem pathItem, String path) {
        if (pathItem.get != null) traverse(pathItem.get);
        if (pathItem.put != null) traverse(pathItem.put);
        if (pathItem.post != null) traverse(pathItem.post);
        if (pathItem.delete != null) traverse(pathItem.delete);
        if (pathItem.options != null) traverse(pathItem.options);
        if (pathItem.head != null) traverse(pathItem.head);
        if (pathItem.patch != null) traverse(pathItem.patch);
        if (pathItem.parameters != null) {
            for (ParameterOrReference parameterOrReference : pathItem.parameters) {
                traverse(parameterOrReference);
            }
        }
        visitor.visit(pathItem, path);
    }

    public void traverse(Paths paths) {
        for (Map.Entry<String, PathItem> entryInPaths : paths.entrySet()) {
            traverse(entryInPaths.getValue(), entryInPaths.getKey());
        }
        visitor.visit(paths);
    }

    public void traverse(Properties properties) {
        for (Map.Entry<String, Schema> entryInProperties : properties.entrySet()) {
            traverse(entryInProperties.getValue(), entryInProperties.getKey());
        }
        visitor.visit(properties);
    }

    public void traverse(Response response, String name) {
        if (response.schema != null) traverse(response.schema);
        if (response.headers != null) traverse(response.headers);
        if (response.examples != null) traverse(response.examples);
        visitor.visit(response, name);
    }

    public void traverse(ResponseOrReference responseOrReference, String statusCode) {
        if (responseOrReference.schema != null) traverse(responseOrReference.schema);
        if (responseOrReference.headers != null) traverse(responseOrReference.headers);
        if (responseOrReference.examples != null) traverse(responseOrReference.examples);
        visitor.visit(responseOrReference, statusCode);
    }

    public void traverse(Responses responses) {
        for (Map.Entry<String, ResponseOrReference> entryInResponses :  responses.entrySet()) {
            traverse(entryInResponses.getValue(), entryInResponses.getKey());
        }
        visitor.visit(responses);
    }

    public void traverse(ResponsesDefinitions responsesDefinitions) {
        for (Map.Entry<String, Response> entryInResponses : responsesDefinitions.entrySet()) {
            traverse(entryInResponses.getValue(), entryInResponses.getKey());
        }
        visitor.visit(responsesDefinitions);
    }

    public void traverse(Schema schema, String name) {
        traverseFields(schema);
        visitor.visit(schema, name);
    }

    public void traverse(Schema schema) {
        traverseFields(schema);
        visitor.visit(schema);
    }

    public void traverse(SchemaOrListOfSchemas schemaOrListOfSchemas) {
        if (schemaOrListOfSchemas.schema != null) traverse(schemaOrListOfSchemas.schema);
        else if (schemaOrListOfSchemas.schemas != null) {
            for (Schema schema : schemaOrListOfSchemas.schemas) {
                traverse(schema);
            }
        }
        visitor.visit(schemaOrListOfSchemas);
    }

    private void traverseFields(Schema schema) {
        if (schema.items != null) traverse(schema.items);
        if (schema.allOf != null) {
            for (Schema schemaInAllOf : schema.allOf) {
                traverse(schemaInAllOf);
            }
        }
        if (schema.properties != null) traverse(schema.properties);
        if (schema.additionalProperties != null) traverse(schema.additionalProperties);
        if (schema.xml != null) traverse(schema.xml);
        if (schema.externalDocs != null) traverse(schema.externalDocs);
    }

    public void traverse(Scopes scopes) {
        visitor.visit(scopes);
    }

    public void traverse(SecurityDefinitions securityDefinitions) {
        for (Map.Entry<String, SecurityScheme> entryInSecurityDefinitions : securityDefinitions.entrySet()) {
            traverse(entryInSecurityDefinitions.getValue(), entryInSecurityDefinitions.getKey());
        }
        visitor.visit(securityDefinitions);
    }

    public void traverse(SecurityRequirement securityRequirement) {
        visitor.visit(securityRequirement);
    }

    public void traverse(SecurityScheme securityScheme, String name) {
        if (securityScheme.scopes != null) traverse(securityScheme.scopes);
        visitor.visit(securityScheme, name);
    }

    public void traverse(Swagger swagger) {
        if (swagger.info != null) traverse(swagger.info);
        if (swagger.paths != null) traverse(swagger.paths);
        if (swagger.definitions != null) traverse(swagger.definitions);
        if (swagger.parameters != null) traverse(swagger.parameters);
        if (swagger.responses != null) traverse(swagger.responses);
        if (swagger.securityDefinitions != null) traverse(swagger.securityDefinitions);
        if (swagger.security != null) {
            for (SecurityRequirement securityRequirement : swagger.security) {
                traverse(securityRequirement);
            }
        }
        if (swagger.tags != null) {
            for (Tag tag : swagger.tags) {
                traverse(tag);
            }
        }
        if (swagger.externalDocs != null) traverse(swagger.externalDocs);
        visitor.visit(swagger);
    }

    public void traverse(Tag tag) {
        if (tag.externalDocs != null) traverse(tag.externalDocs);
        visitor.visit(tag);
    }

    public void traverse(Xml xml) {
        visitor.visit(xml);
    }

}
