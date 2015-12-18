package com.github.hgwood.fanfaron;

import com.github.hgwood.fanfaron.utils.DynamicObject;

import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#headersObject
 */
public class Headers extends DynamicObject<Header> {
    public Headers(Map<String, Header> headers) {
        super(headers);
    }

    public Headers() {
        super();
    }
}
