package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.jsonschema.Schema;

import java.util.Objects;

public class Response {
    public String description;
    public Schema schema;
    public Headers headers;
    public Example examples;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Response)) return false;
        Response other = (Response)obj;
        return Objects.equals(description, other.description)
            && Objects.equals(schema, other.schema)
            && Objects.equals(headers, other.headers)
            && Objects.equals(examples, other.examples);
    }

    @Override public int hashCode() {
        return Objects.hash(description, schema, headers, examples);
    }
}
