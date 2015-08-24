package fr.hgwood.fanfaron;

import java.util.Objects;

public class Tag {
    public String name;
    public String description;
    public ExternalDocumentation externalDocs;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Tag)) return false;
        Tag other = (Tag)obj;
        return Objects.equals(name, other.name)
            && Objects.equals(description, other.description)
            && Objects.equals(externalDocs, other.externalDocs);
    }

    @Override public int hashCode() {
        return Objects.hash(name, description, externalDocs);
    }
}
