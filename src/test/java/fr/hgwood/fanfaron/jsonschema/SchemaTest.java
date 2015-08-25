package fr.hgwood.fanfaron.jsonschema;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class SchemaTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test public void supports_free_additional_properties() throws Exception {
        objectMapper.readValue("{\"additionalProperties\": true}", Schema.class);
    }

}
