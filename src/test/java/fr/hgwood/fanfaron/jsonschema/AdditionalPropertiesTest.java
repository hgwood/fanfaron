package fr.hgwood.fanfaron.jsonschema;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdditionalPropertiesTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test public void accepts_true() throws Exception {
        AdditionalProperties additionalProperties = objectMapper.readValue("true", AdditionalProperties.class);
        assertTrue(additionalProperties.allowed);
    }

    @Test public void accepts_false() throws Exception {
        AdditionalProperties additionalProperties = objectMapper.readValue("false", AdditionalProperties.class);
        assertFalse(additionalProperties.allowed);
    }

    @Test public void accepts_object() throws Exception {
        AdditionalProperties additionalProperties = objectMapper.readValue("{}", AdditionalProperties.class);
        assertNotNull(additionalProperties.schema);
    }

}
