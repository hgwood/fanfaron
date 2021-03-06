package com.github.hgwood.fanfaron;

import com.github.hgwood.fanfaron.utils.vendorextensions.WithVendorExtensions;

import java.util.Objects;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#infoObject
 */
public class Info extends WithVendorExtensions {
    public String title;
    public String description;
    public String termsOfService;
    public Contact contact;
    public License license;
    public String version;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Info)) return false;
        Info other = (Info)obj;
        return Objects.equals(title, other.title)
            && Objects.equals(description, other.description)
            && Objects.equals(termsOfService, other.termsOfService)
            && Objects.equals(contact, other.contact)
            && Objects.equals(license, other.license)
            && Objects.equals(version, other.version)
            && Objects.equals(vendorExtensions, other.vendorExtensions);
    }

    @Override public int hashCode() {
        return Objects.hash(title, description, termsOfService, contact, license, version, vendorExtensions);
    }
}
