package fr.hgwood.fanfaron;

import java.util.Objects;

public class Xml {
    public String name;
    public Boolean wrapped = false;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Xml)) return false;
        Xml other = (Xml)obj;
        return Objects.equals(name, other.name)
            && Objects.equals(wrapped, other.wrapped);
    }

    @Override public int hashCode() {
        return Objects.hash(name, wrapped);
    }
}
