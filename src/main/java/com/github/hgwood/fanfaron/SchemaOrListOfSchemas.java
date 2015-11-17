package com.github.hgwood.fanfaron;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;
import java.util.Objects;

public class SchemaOrListOfSchemas {
    public Schema schema;
    public List<Schema> schemas;

    public SchemaOrListOfSchemas() {

    }

    @JsonCreator public SchemaOrListOfSchemas(Schema schema) {
        this.schema = schema;
    }

    @JsonCreator public SchemaOrListOfSchemas(List<Schema> schemas) {
        this.schemas = schemas;
    }

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof SchemaOrListOfSchemas)) return false;
        SchemaOrListOfSchemas other = (SchemaOrListOfSchemas)obj;
        return Objects.equals(schema, other.schema)
            && Objects.equals(schemas, other.schemas);
    }

    @Override public int hashCode() {
        return Objects.hash(schema, schemas);
    }
}
