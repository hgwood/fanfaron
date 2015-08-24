package fr.hgwood.fanfaron;

import java.util.Objects;

public class SecurityScheme {
    public String type;
    public String name;
    public String in;
    public String flow;
    public String authorizationUrl;
    public Scopes scopes;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof SecurityScheme)) return false;
        SecurityScheme other = (SecurityScheme)obj;
        return Objects.equals(type, other.type)
            && Objects.equals(name, other.name)
            && Objects.equals(in, other.in)
            && Objects.equals(flow, other.flow)
            && Objects.equals(authorizationUrl, other.authorizationUrl)
            && Objects.equals(scopes, other.scopes);
    }

    @Override public int hashCode() {
        return Objects.hash(type, name, in, flow, authorizationUrl, scopes);
    }
}
