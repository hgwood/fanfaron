package fr.hgwood.fanfaron;

import java.util.Objects;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#securitySchemeObject
 */
public class SecurityScheme {
    public String type;
    public String description;
    public String name;
    public String in;
    public String flow;
    public String authorizationUrl;
    public String tokenUrl;
    public Scopes scopes;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof SecurityScheme)) return false;
        SecurityScheme other = (SecurityScheme)obj;
        return Objects.equals(type, other.type)
            && Objects.equals(description, other.description)
            && Objects.equals(name, other.name)
            && Objects.equals(in, other.in)
            && Objects.equals(flow, other.flow)
            && Objects.equals(authorizationUrl, other.authorizationUrl)
            && Objects.equals(tokenUrl, other.tokenUrl)
            && Objects.equals(scopes, other.scopes);
    }

    @Override public int hashCode() {
        return Objects.hash(type, description, name, in, flow, authorizationUrl, tokenUrl, scopes);
    }
}
