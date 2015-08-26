package fr.hgwood.fanfaron.jsonschema;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public class BooleanOrSchema {

    public Boolean allowed;
    public Schema schema;

    public BooleanOrSchema() {

    }

    @JsonCreator public BooleanOrSchema(boolean allowed) {
        this.allowed = allowed;
    }

    @JsonCreator public BooleanOrSchema(Schema schema) {
        this.schema = schema;
    }

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof BooleanOrSchema)) return false;
        BooleanOrSchema other = (BooleanOrSchema)obj;
        return Objects.equals(allowed, other.allowed)
            && Objects.equals(schema, other.schema);
    }

    @Override public int hashCode() {
        return Objects.hash(allowed, schema);
    }
}
