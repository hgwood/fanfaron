package fr.hgwood.fanfaron.jsonschema;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class BooleanOrSchemaTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test public void accepts_true() throws Exception {
        BooleanOrSchema booleanOrSchema = objectMapper.readValue("true", BooleanOrSchema.class);
        assertTrue(booleanOrSchema.allowed);
    }

    @Test public void accepts_false() throws Exception {
        BooleanOrSchema booleanOrSchema = objectMapper.readValue("false", BooleanOrSchema.class);
        assertFalse(booleanOrSchema.allowed);
    }

    @Test public void accepts_object() throws Exception {
        BooleanOrSchema booleanOrSchema = objectMapper.readValue("{}", BooleanOrSchema.class);
        assertNotNull(booleanOrSchema.schema);
    }

}
