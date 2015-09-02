package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.utils.DefaultFiller;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FillDefaultsTest {

    @Test public void operation_deprecated_defaults_to_false() {
        Operation withDefaults = new DefaultFiller().fillDefaults(new Operation());
        assertEquals("default was not set", false, withDefaults.deprecated);
    }

    @Test public void operation_deprecated_no_override() {
        Operation operation = new Operation();
        operation.deprecated = true;
        Operation withDefaults = new DefaultFiller().fillDefaults(operation);
        assertEquals("existing value was overridden", true, withDefaults.deprecated);
    }

    @Test public void parameter_required_defaults_to_false() {
        Parameter withDefaults = new DefaultFiller().fillDefaults(new Parameter());
        assertEquals("default was not set", false, withDefaults.required);
    }

    @Test public void parameter_required_no_override() {
        Parameter parameter = new Parameter();
        parameter.required = true;
        Parameter withDefaults = new DefaultFiller().fillDefaults(parameter);
        assertEquals("existing value was overridden", true, withDefaults.required);
    }

    @Test public void parameter_allowEmptyValue_defaults_to_false() {
        Parameter withDefaults = new DefaultFiller().fillDefaults(new Parameter());
        assertEquals("default was not set", false, withDefaults.allowEmptyValue);
    }

    @Test public void parameter_allowEmptyValue_no_override() {
        Parameter parameter = new Parameter();
        parameter.allowEmptyValue = true;
        Parameter withDefaults = new DefaultFiller().fillDefaults(parameter);
        assertEquals("existing value was overridden", true, withDefaults.allowEmptyValue);
    }

    @Test public void parameter_collectionFormat_defaults_to_csv() {
        Parameter withDefaults = new DefaultFiller().fillDefaults(new Parameter());
        assertEquals("default was not set", "csv", withDefaults.collectionFormat);
    }

    @Test public void parameter_collectionFormat_no_override() {
        Parameter parameter = new Parameter();
        parameter.collectionFormat = "pipes";
        Parameter withDefaults = new DefaultFiller().fillDefaults(parameter);
        assertEquals("existing value was overridden", "pipes", withDefaults.collectionFormat);
    }

    @Test public void items_collectionFormat_defaults_to_csv() {
        Items withDefaults = new DefaultFiller().fillDefaults(new Items());
        assertEquals("default was not set", "csv", withDefaults.collectionFormat);
    }

    @Test public void items_collectionFormat_no_override() {
        Items items = new Items();
        items.collectionFormat = "pipes";
        Items withDefaults = new DefaultFiller().fillDefaults(items);
        assertEquals("existing value was overridden", "pipes", withDefaults.collectionFormat);
    }

    @Test public void header_collectionFormat_defaults_to_csv() {
        Header withDefaults = new DefaultFiller().fillDefaults(new Header());
        assertEquals("default was not set", "csv", withDefaults.collectionFormat);
    }

    @Test public void header_collectionFormat_no_override() {
        Header header = new Header();
        header.collectionFormat = "pipes";
        Header withDefaults = new DefaultFiller().fillDefaults(header);
        assertEquals("existing value was overridden", "pipes", withDefaults.collectionFormat);
    }

    @Test public void schema_readOnly_default_to_false() {
        Schema withDefaults = new DefaultFiller().fillDefaults(new Schema());
        assertEquals("default was not set", false, withDefaults.readOnly);
    }

    @Test public void schema_readOnly_no_override() {
        Schema schema = new Schema();
        schema.readOnly = true;
        Schema withDefaults = new DefaultFiller().fillDefaults(schema);
        assertEquals("existing value was overridden", true, withDefaults.readOnly);
    }

    @Test public void xml_attribute_default_to_false() {
        Xml withDefaults = new DefaultFiller().fillDefaults(new Xml());
        assertEquals("default was not set", false, withDefaults.attribute);
    }

    @Test public void xml_attribute_no_override() {
        Xml xml = new Xml();
        xml.attribute = true;
        Xml withDefaults = new DefaultFiller().fillDefaults(xml);
        assertEquals("existing value was overridden", true, withDefaults.attribute);
    }

    @Test public void xml_wrapped_default_to_false() {
        Xml withDefaults = new DefaultFiller().fillDefaults(new Xml());
        assertEquals("default was not set", false, withDefaults.wrapped);
    }

    @Test public void xml_wrapped_no_override() {
        Xml xml = new Xml();
        xml.wrapped = true;
        Xml withDefaults = new DefaultFiller().fillDefaults(xml);
        assertEquals("existing value was overridden", true, withDefaults.wrapped);
    }

}
