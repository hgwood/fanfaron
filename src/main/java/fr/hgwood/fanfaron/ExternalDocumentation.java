package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.utils.WithVendorExtensions;

import java.util.Objects;

public class ExternalDocumentation extends WithVendorExtensions {
    public String description;
    public String url;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof ExternalDocumentation)) return false;
        ExternalDocumentation other = (ExternalDocumentation)obj;
        return Objects.equals(description, other.description)
            && Objects.equals(url, other.url)
            && Objects.equals(vendorExtensions, other.vendorExtensions);
    }

    @Override public int hashCode() {
        return Objects.hash(description, url, vendorExtensions);
    }
}
