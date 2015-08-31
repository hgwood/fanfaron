package fr.hgwood.fanfaron;

import java.util.Objects;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#responseObject
 */
public class Response {
    public String $ref;
    public String description;
    public Schema schema;
    public Headers headers;
    public Example examples;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Response)) return false;
        Response other = (Response)obj;
        return Objects.equals($ref, other.$ref)
            && Objects.equals(description, other.description)
            && Objects.equals(schema, other.schema)
            && Objects.equals(headers, other.headers)
            && Objects.equals(examples, other.examples);
    }

    @Override public int hashCode() {
        return Objects.hash($ref, description, schema, headers, examples);
    }
}
