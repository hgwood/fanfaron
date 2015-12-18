package com.github.hgwood.fanfaron;

import com.github.hgwood.fanfaron.utils.vendorextensions.WithVendorExtensions;

import java.util.Objects;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#xmlObject
 */
public class Xml extends WithVendorExtensions {
    public String name;
    public String namespace;
    public String prefix;
    public Boolean attribute;
    public Boolean wrapped;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Xml)) return false;
        Xml other = (Xml)obj;
        return Objects.equals(name, other.name)
            && Objects.equals(namespace, other.namespace)
            && Objects.equals(prefix, other.prefix)
            && Objects.equals(attribute, other.attribute)
            && Objects.equals(wrapped, other.wrapped)
            && Objects.equals(vendorExtensions, other.vendorExtensions);
    }

    @Override public int hashCode() {
        return Objects.hash(name, namespace, prefix, attribute, wrapped, vendorExtensions);
    }
}
