package com.github.hgwood.fanfaron.utils.traversal;

import com.github.hgwood.fanfaron.*;

/**
 * Consider depending on {@link SimpleVisitor} instead of this interface to prevent your code from breaking when methods
 * are added.
 */
public interface Visitor {
    void visit(AdditionalProperties additionalProperties);
    void visit(Contact contact);
    void visit(Definitions definitions);
    void visit(Example example);
    void visit(ExternalDocumentation externalDocumentation);
    void visit(Header header);
    void visit(Headers headers);
    void visit(Info info);
    void visit(Items items);
    void visit(License license);
    void visit(Operation operation);
    void visit(Parameter parameter, String name);
    void visit(ParameterOrReference parameterOrReference);
    void visit(ParametersDefinitions parametersDefinitions);
    void visit(PathItem pathItem, String path);
    void visit(Paths paths);
    void visit(Properties properties);
    void visit(Response response, String name);
    void visit(ResponseOrReference responseOrReference, String statusCode);
    void visit(Responses responses);
    void visit(ResponsesDefinitions responsesDefinitions);
    void visit(Schema schema);
    void visit(Schema schema, String name);
    void visit(SchemaOrListOfSchemas schemaOrListOfSchemas);
    void visit(Scopes scopes);
    void visit(SecurityDefinitions securityDefinitions);
    void visit(SecurityRequirement securityRequirement);
    void visit(SecurityScheme securityScheme, String name);
    void visit(Swagger swagger);
    void visit(Tag tag);
    void visit(Xml xml);
}
