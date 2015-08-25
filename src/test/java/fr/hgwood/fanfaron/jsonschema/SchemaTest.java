package fr.hgwood.fanfaron.jsonschema;

import org.junit.Test;

import static fr.hgwood.fanfaron.TestUtils.deserialize;
import static fr.hgwood.fanfaron.TestUtils.objectMapper;

public class SchemaTest {

    @Test public void supports_free_additional_properties() throws Exception {
        objectMapper.readValue("{\"additionalProperties\": true}", Schema.class);
    }

    @Test public void deserializes_swagger_2_schema_successfully() throws Exception {
        deserialize(getClass(), "swagger2.schema.json", Schema.class);
    }

}
