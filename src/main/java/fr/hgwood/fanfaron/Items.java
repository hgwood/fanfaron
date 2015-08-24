package fr.hgwood.fanfaron;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Items {
    public String type;
    @JsonProperty("default") public Object _default;
    @JsonProperty("enum") public List<Object> _enum;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Items)) return false;
        Items other = (Items)obj;
        return Objects.equals(type, other.type)
            && Objects.equals(_default, other._default)
            && Objects.equals(_enum, other._enum);
    }

    @Override public int hashCode() {
        return Objects.hash(type, _default, _enum);
    }
}
