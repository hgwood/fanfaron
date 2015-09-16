package fr.hgwood.fanfaron;

import com.fasterxml.jackson.annotation.JsonCreator;
import fr.hgwood.fanfaron.utils.DynamicObjectWithVendorExtensions;

import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#pathsObject
 */
public class Paths extends DynamicObjectWithVendorExtensions<PathItem> {
    @JsonCreator public Paths(Map<String, ?> paths) {
        super(paths);
    }

    public Paths() {
        super();
    }
}
