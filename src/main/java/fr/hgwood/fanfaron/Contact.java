package fr.hgwood.fanfaron;

import java.util.Objects;

public class Contact {
    public String name;
    public String url;
    public String email;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Contact)) return false;
        Contact other = (Contact)obj;
        return Objects.equals(name, other.name)
            && Objects.equals(url, other.url)
            && Objects.equals(email, other.email);
    }

    @Override public int hashCode() {
        return Objects.hash(name, url, email);
    }
}
