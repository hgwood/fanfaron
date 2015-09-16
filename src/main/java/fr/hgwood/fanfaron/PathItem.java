package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.utils.WithVendorExtensions;

import java.util.List;
import java.util.Objects;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#pathItemObject
 */
public class PathItem extends WithVendorExtensions {
    public String $ref;
    public Operation get;
    public Operation put;
    public Operation post;
    public Operation delete;
    public Operation options;
    public Operation head;
    public Operation patch;
    public List<ParameterOrReference> parameters;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof PathItem)) return false;
        PathItem other = (PathItem)obj;
        return Objects.equals($ref, other.$ref)
            && Objects.equals(get, other.get)
            && Objects.equals(put, other.put)
            && Objects.equals(post, other.post)
            && Objects.equals(delete, other.delete)
            && Objects.equals(options, other.options)
            && Objects.equals(head, other.head)
            && Objects.equals(patch, other.patch)
            && Objects.equals(parameters, other.parameters)
            && Objects.equals(vendorExtensions, other.vendorExtensions);
    }

    @Override public int hashCode() {
        return Objects.hash($ref, get, put, post, delete, options, head, patch, parameters, vendorExtensions);
    }
}
