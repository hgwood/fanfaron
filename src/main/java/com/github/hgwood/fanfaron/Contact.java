package com.github.hgwood.fanfaron;

import com.github.hgwood.fanfaron.utils.vendorextensions.WithVendorExtensions;

import java.util.Objects;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#contactObject
 */
public class Contact extends WithVendorExtensions {
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
            && Objects.equals(email, other.email)
            && Objects.equals(vendorExtensions, other.vendorExtensions);
    }

    @Override public int hashCode() {
        return Objects.hash(name, url, email, vendorExtensions);
    }
}
