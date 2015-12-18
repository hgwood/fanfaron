package com.github.hgwood.fanfaron;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PetStoreTest {

    @Test public void deserializes_pet_store_successfully() throws Exception {
        deserializePetStore();
    }

    @Test public void two_models_deserialized_from_the_same_source_are_equal() throws Exception {
        assertEquals("structural equality contract not fulfilled",
            deserializePetStore(),
            deserializePetStore());
    }

    private Swagger deserializePetStore() {
        return TestUtils.deserialize(getClass(), "petstore.swagger.json", Swagger.class);
    }

}
