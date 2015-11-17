package com.github.hgwood.fanfaron;

import org.junit.Test;

import static com.github.hgwood.fanfaron.TestUtils.deserialize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ArrayItemsTest {

    @Test public void items_accepts_an_array_value() {
        Schema schema = deserialize(getClass(), "arrayItems.json", Schema.class);
        assertEquals(2, schema.items.schemas.size());
        assertNull(schema.items.schema);
    }

    @Test public void items_accepts_an_schema_value() {
        Schema schema = deserialize(getClass(), "schemaItems.json", Schema.class);
        assertNotNull(schema.items.schema);
        assertNull(schema.items.schemas);
    }

}
