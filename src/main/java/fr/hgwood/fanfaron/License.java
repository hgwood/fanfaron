package fr.hgwood.fanfaron;

import java.util.Objects;

public class License {
    public String name;
    public String url;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof License)) return false;
        License other = (License)obj;
        return Objects.equals(name, other.name)
            && Objects.equals(url, other.url);
    }

    @Override public int hashCode() {
        return Objects.hash(name, url);
    }
}
