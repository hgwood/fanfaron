import com.fasterxml.jackson.databind.ObjectMapper;
import fr.hgwood.fanfaron.Swagger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AcceptanceTest {

    @Test public void deserializes_pet_store_successfully() throws Exception {
        deserialize("petstore.swagger.json");
    }

    @Test public void two_models_deserialized_from_the_same_source_are_equal() throws Exception {
        assertEquals(deserialize("petstore.swagger.json"), deserialize("petstore.swagger.json"));
    }

    private Swagger deserialize(String resourcePath) throws Exception {
        return new ObjectMapper().readValue(getClass().getResource(resourcePath), Swagger.class);
    }

}
