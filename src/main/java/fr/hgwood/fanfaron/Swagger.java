package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.utils.WithVendorExtensions;

import java.util.List;
import java.util.Objects;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#swagger-object
 */
public class Swagger extends WithVendorExtensions {
    public String swagger;
    public Info info;
    public String host;
    public String basePath;
    public List<String> schemes;
    public List<String> consumes;
    public List<String> produces;
    public Paths paths;
    public Definitions definitions;
    public ParametersDefinitions parameters;
    public ResponsesDefinitions responses;
    public SecurityDefinitions securityDefinitions;
    public List<SecurityRequirement> security;
    public List<Tag> tags;
    public ExternalDocumentation externalDocs;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Swagger)) return false;
        Swagger other = (Swagger)obj;
        return Objects.equals(swagger, other.swagger)
            && Objects.equals(info, other.info)
            && Objects.equals(host, other.host)
            && Objects.equals(basePath, other.basePath)
            && Objects.equals(schemes, other.schemes)
            && Objects.equals(consumes, other.consumes)
            && Objects.equals(produces, other.produces)
            && Objects.equals(paths, other.paths)
            && Objects.equals(definitions, other.definitions)
            && Objects.equals(parameters, other.parameters)
            && Objects.equals(responses, other.responses)
            && Objects.equals(securityDefinitions, other.securityDefinitions)
            && Objects.equals(security, other.security)
            && Objects.equals(tags, other.tags)
            && Objects.equals(externalDocs, other.externalDocs)
            && Objects.equals(vendorExtensions, other.vendorExtensions);
    }

    @Override public int hashCode() {
        return Objects.hash(
            swagger,
            info,
            host,
            basePath,
            schemes,
            consumes, produces,
            paths,
            definitions,
            parameters,
            responses,
            securityDefinitions,
            security,
            tags,
            externalDocs,
            vendorExtensions);
    }
}
