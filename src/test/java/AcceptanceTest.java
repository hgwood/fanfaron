import com.fasterxml.jackson.databind.ObjectMapper;
import fr.hgwood.fanfaron.Swagger;
import org.junit.Test;

public class AcceptanceTest {

    @Test public void deserializes_pet_store_successfully() throws Exception {
        deserialize("petstore.swagger.json");
    }

    private void deserialize(String resourcePath) throws Exception {
        new ObjectMapper().readValue(getClass().getResource(resourcePath), Swagger.class);
    }

}
