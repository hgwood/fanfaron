package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.utils.vendorextensions.WithVendorExtensions;

import java.util.List;
import java.util.Objects;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#operationObject
 */
public class Operation extends WithVendorExtensions {
    public List<String> tags;
    public String summary;
    public String description;
    public ExternalDocumentation externalDocs;
    public String operationId;
    public List<String> consumes;
    public List<String> produces;
    public List<ParameterOrReference> parameters;
    public Responses responses;
    public List<String> schemes;
    public Boolean deprecated;
    public List<SecurityRequirement> security;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Operation)) return false;
        Operation other = (Operation)obj;
        return Objects.equals(tags, other.tags)
            && Objects.equals(summary, other.summary)
            && Objects.equals(description, other.description)
            && Objects.equals(externalDocs, other.externalDocs)
            && Objects.equals(operationId, other.operationId)
            && Objects.equals(consumes, other.consumes)
            && Objects.equals(produces, other.produces)
            && Objects.equals(parameters, other.parameters)
            && Objects.equals(responses, other.responses)
            && Objects.equals(schemes, other.schemes)
            && Objects.equals(deprecated, other.deprecated)
            && Objects.equals(security, other.security)
            && Objects.equals(vendorExtensions, other.vendorExtensions);
    }

    @Override public int hashCode() {
        return Objects.hash(
            tags,
            summary,
            description,
            externalDocs,
            operationId,
            consumes,
            parameters,
            responses,
            schemes,
            deprecated,
            security,
            vendorExtensions);
    }
}
