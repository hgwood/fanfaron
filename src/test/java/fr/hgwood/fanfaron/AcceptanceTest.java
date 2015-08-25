package fr.hgwood.fanfaron;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.net.URL;

import static java.util.Objects.requireNonNull;
import static org.junit.Assert.assertEquals;

public class AcceptanceTest {

    @Test public void deserializes_pet_store_successfully() throws Exception {
        deserialize("petstore.swagger.json");
    }

    @Test public void two_models_deserialized_from_the_same_source_are_equal() throws Exception {
        assertEquals("structural equality contract not fulfilled",
            deserialize("petstore.swagger.json"),
            deserialize("petstore.swagger.json"));
    }

    private Swagger deserialize(String resourcePath) throws Exception {
        URL resourceUrl = getClass().getResource(resourcePath);
        requireNonNull(resourceUrl, "resource not found: " + resourcePath);
        return new ObjectMapper().readValue(resourceUrl, Swagger.class);
    }

}
