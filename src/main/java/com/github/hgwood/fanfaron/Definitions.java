package com.github.hgwood.fanfaron;

import com.github.hgwood.fanfaron.utils.DynamicObject;

import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#definitionsObject
 */
public class Definitions extends DynamicObject<Schema> {
    public Definitions(Map<String, Schema> definitions) {
        super(definitions);
    }

    public Definitions() {
        super();
    }
}
