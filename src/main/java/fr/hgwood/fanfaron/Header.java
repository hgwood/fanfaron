package fr.hgwood.fanfaron;

import java.util.Objects;

public class Header {
    public String description;
    public String type;
    public String format;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Header)) return false;
        Header other = (Header)obj;
        return Objects.equals(description, other.description)
            && Objects.equals(type, other.type)
            && Objects.equals(format, other.format);
    }

    @Override public int hashCode() {
        return Objects.hash(description, type, format);
    }
}
