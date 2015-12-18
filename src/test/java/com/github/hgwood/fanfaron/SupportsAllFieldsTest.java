package com.github.hgwood.fanfaron;

import org.junit.Test;

public class SupportsAllFieldsTest {

    @Test public void swagger() {
        TestUtils.deserialize(getClass(), "swagger.json", Swagger.class);
    }

    @Test public void info() {
        TestUtils.deserialize(getClass(), "info.json", Info.class);
    }

    @Test public void contact() {
        TestUtils.deserialize(getClass(), "contact.json", Contact.class);
    }

    @Test public void license() {
        TestUtils.deserialize(getClass(), "license.json", License.class);
    }

    @Test public void pathItem() {
        TestUtils.deserialize(getClass(), "pathItem.json", PathItem.class);
    }

    @Test public void operation() {
        TestUtils.deserialize(getClass(), "operation.json", Operation.class);
    }

    @Test public void externalDocs() {
        TestUtils.deserialize(getClass(), "externalDocumentation.json", ExternalDocumentation.class);
    }

    @Test public void parameter() {
        TestUtils.deserialize(getClass(), "parameter.json", Parameter.class);
    }

    @Test public void items() {
        TestUtils.deserialize(getClass(), "items.json", Items.class);
    }

    @Test public void response() {
        TestUtils.deserialize(getClass(), "response.json", Response.class);
    }

    @Test public void header() {
        TestUtils.deserialize(getClass(), "header.json", Header.class);
    }

    @Test public void securityScheme() {
        TestUtils.deserialize(getClass(), "securityScheme.json", SecurityScheme.class);
    }

    @Test public void tag() {
        TestUtils.deserialize(getClass(), "tag.json", Tag.class);
    }

    @Test public void schema() {
        TestUtils.deserialize(getClass(), "schema.json", Schema.class);
    }

    @Test public void xml() {
        TestUtils.deserialize(getClass(), "xml.json", Xml.class);
    }

    @Test public void parameterOrReference() {
        TestUtils.deserialize(getClass(), "parameter.json", ParameterOrReference.class);
        TestUtils.deserialize(getClass(), "reference.json", ParameterOrReference.class);
    }

    @Test public void responseOrReference() {
        TestUtils.deserialize(getClass(), "response.json", ResponseOrReference.class);
        TestUtils.deserialize(getClass(), "reference.json", ResponseOrReference.class);
    }

}
