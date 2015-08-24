package fr.hgwood.fanfaron;

import java.util.Objects;

public class PathItem {
    public Operation get;
    public Operation put;
    public Operation post;
    public Operation delete;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof PathItem)) return false;
        PathItem other = (PathItem)obj;
        return Objects.equals(get, other.get)
            && Objects.equals(put, other.put)
            && Objects.equals(post, other.post)
            && Objects.equals(delete, other.delete);
    }

    @Override public int hashCode() {
        return Objects.hash(get, put, post, delete);
    }
}
