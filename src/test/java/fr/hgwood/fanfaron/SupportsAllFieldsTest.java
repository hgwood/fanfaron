package fr.hgwood.fanfaron;

import org.junit.Test;

import static fr.hgwood.fanfaron.TestUtils.deserialize;

public class SupportsAllFieldsTest {

    @Test public void swagger() {
        deserialize(getClass(), "swagger.json", Swagger.class);
    }

    @Test public void info() {
        deserialize(getClass(), "info.json", Info.class);
    }

    @Test public void contact() {
        deserialize(getClass(), "contact.json", Contact.class);
    }

    @Test public void license() {
        deserialize(getClass(), "license.json", License.class);
    }

    @Test public void pathItem() {
        deserialize(getClass(), "pathItem.json", PathItem.class);
    }

    @Test public void operation() {
        deserialize(getClass(), "operation.json", Operation.class);
    }

    @Test public void externalDocs() {
        deserialize(getClass(), "externalDocumentation.json", ExternalDocumentation.class);
    }

    @Test public void parameter() {
        deserialize(getClass(), "parameter.json", Parameter.class);
    }

    @Test public void items() {
        deserialize(getClass(), "items.json", Items.class);
    }

    @Test public void response() {
        deserialize(getClass(), "response.json", Response.class);
    }

    @Test public void header() {
        deserialize(getClass(), "header.json", Header.class);
    }

    @Test public void securityScheme() {
        deserialize(getClass(), "securityScheme.json", SecurityScheme.class);
    }

    @Test public void tag() {
        deserialize(getClass(), "tag.json", Tag.class);
    }

    @Test public void schema() {
        deserialize(getClass(), "schema.json", Schema.class);
    }

}
