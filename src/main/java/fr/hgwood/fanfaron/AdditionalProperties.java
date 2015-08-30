package fr.hgwood.fanfaron;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public class AdditionalProperties {
    public Boolean allowed;
    public Schema schema;

    public AdditionalProperties() {

    }

    @JsonCreator
    public AdditionalProperties(Boolean allowed) {
        this.allowed = allowed;
    }

    @JsonCreator public AdditionalProperties(Schema schema) {
        this.schema = schema;
    }

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof AdditionalProperties)) return false;
        AdditionalProperties other = (AdditionalProperties)obj;
        return Objects.equals(allowed, other.allowed)
                && Objects.equals(schema, other.schema);
    }

    @Override public int hashCode() {
        return Objects.hash(allowed, schema);
    }

}
