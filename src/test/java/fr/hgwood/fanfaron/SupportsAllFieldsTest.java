package fr.hgwood.fanfaron;

import org.junit.Test;

import static fr.hgwood.fanfaron.TestUtils.deserialize;

public class SupportsAllFieldsTest {

    @Test public void swagger() {
        deserialize(getClass(), "swagger.json", Swagger.class);
    }

}
