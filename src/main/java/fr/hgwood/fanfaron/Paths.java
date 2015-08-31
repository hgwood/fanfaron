package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.utils.DynamicObject;

import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#pathsObject
 */
public class Paths extends DynamicObject<PathItem> {
    public Paths(Map<String, PathItem> paths) {
        super(paths);
    }

    public Paths() {
        super();
    }
}
