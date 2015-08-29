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

}
