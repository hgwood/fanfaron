package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.utils.DynamicObject;

import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#exampleObject
 */
public class Example extends DynamicObject<Object> {
    public Example(Map<String, Object> examples) {
        super(examples);
    }

    public Example() {
        super();
    }
}
