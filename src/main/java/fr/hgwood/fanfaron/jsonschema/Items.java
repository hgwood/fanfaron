package fr.hgwood.fanfaron.jsonschema;

import java.util.Objects;

public class Items {
    public String $ref;
    public String type;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Items)) return false;
        Items other = (Items)obj;
        return Objects.equals($ref, other.$ref)
            && Objects.equals(type, other.type);
    }

    @Override public int hashCode() {
        return Objects.hash($ref, type);
    }
}
