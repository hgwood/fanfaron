package fr.hgwood.fanfaron.jsonschema;

import org.junit.Test;

import static fr.hgwood.fanfaron.TestUtils.deserialize;
import static org.junit.Assert.assertEquals;

public class Swagger2SchemaTest {

    @Test public void deserializes_swagger_2_schema_successfully() throws Exception {
        deserializeSwagger2Schema();
    }

    @Test public void two_models_deserialized_from_the_same_source_are_equal() throws Exception {
        assertEquals("structural equality contract not fulfilled",
            deserializeSwagger2Schema(),
            deserializeSwagger2Schema());
    }

    private Schema deserializeSwagger2Schema() {
        return deserialize(getClass(), "swagger2.schema.json", Schema.class);
    }

}
