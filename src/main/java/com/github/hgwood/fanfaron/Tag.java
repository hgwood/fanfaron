package com.github.hgwood.fanfaron;

import com.github.hgwood.fanfaron.utils.vendorextensions.WithVendorExtensions;

import java.util.Objects;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#tagObject
 */
public class Tag extends WithVendorExtensions {
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
            && Objects.equals(externalDocs, other.externalDocs)
            && Objects.equals(vendorExtensions, other.vendorExtensions);
    }

    @Override public int hashCode() {
        return Objects.hash(name, description, externalDocs, vendorExtensions);
    }
}
