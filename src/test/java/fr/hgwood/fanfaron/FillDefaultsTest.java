package fr.hgwood.fanfaron;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.*;
import fr.hgwood.fanfaron.utils.DefaultFiller;
import org.junit.Test;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
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

    @Test public void schema_readOnly_defaults_to_false() {
        Schema withDefaults = new DefaultFiller().fillDefaults(new Schema());
        assertEquals("default was not set", false, withDefaults.readOnly);
    }

    @Test public void schema_readOnly_no_override() {
        Schema schema = new Schema();
        schema.readOnly = true;
        Schema withDefaults = new DefaultFiller().fillDefaults(schema);
        assertEquals("existing value was overridden", true, withDefaults.readOnly);
    }

    @Test public void xml_attribute_defaults_to_false() {
        Xml withDefaults = new DefaultFiller().fillDefaults(new Xml());
        assertEquals("default was not set", false, withDefaults.attribute);
    }

    @Test public void xml_attribute_no_override() {
        Xml xml = new Xml();
        xml.attribute = true;
        Xml withDefaults = new DefaultFiller().fillDefaults(xml);
        assertEquals("existing value was overridden", true, withDefaults.attribute);
    }

    @Test public void xml_wrapped_defaults_to_false() {
        Xml withDefaults = new DefaultFiller().fillDefaults(new Xml());
        assertEquals("default was not set", false, withDefaults.wrapped);
    }

    @Test public void xml_wrapped_no_override() {
        Xml xml = new Xml();
        xml.wrapped = true;
        Xml withDefaults = new DefaultFiller().fillDefaults(xml);
        assertEquals("existing value was overridden", true, withDefaults.wrapped);
    }

    @Test public void recursively_sets_defaults() {
        // Given
        Swagger swagger = new Swagger();

        Operation operation = new Operation();
        PathItem pathItem = new PathItem();
        pathItem.get = operation;
        pathItem.put = operation;
        pathItem.post = operation;
        pathItem.delete = operation;
        pathItem.options = operation;
        pathItem.head = operation;
        pathItem.patch = operation;
        Paths paths = new Paths(ImmutableMap.of("", pathItem));
        swagger.paths = paths;

        ParameterOrReference parameter = new ParameterOrReference();
        ParametersDefinitions parametersDefinitions = new ParametersDefinitions(ImmutableMap.of("", (Parameter)parameter));
        swagger.parameters = parametersDefinitions;
        pathItem.parameters = ImmutableList.of(parameter);
        operation.parameters = ImmutableList.of(parameter);

        Header header = new Header();
        Headers headers = new Headers(ImmutableMap.of("", header));
        Response response = new Response();
        response.headers = headers;
        ResponsesDefinitions responsesDefinitions = new ResponsesDefinitions(ImmutableMap.of("", response));
        swagger.responses = responsesDefinitions;

        Items items = new Items();
        items.items = new Items();
        parameter.items = items;
        header.items = items;

        Schema schema = new Schema();
        parameter.schema = schema;
        response.schema = schema;
        Definitions definitions = new Definitions(ImmutableMap.of("", schema));
        swagger.definitions = definitions;

        Xml xml = new Xml();
        schema.xml = xml;

        // When
        Swagger withDefaults = new DefaultFiller().fillDefaults(swagger);

        // Then
        for (Operation operationWithDefaults : getOperations(withDefaults)) {
            assertEquals(false, operationWithDefaults.deprecated);
        }

        for (Parameter parameterWithDefaults : getParameters(withDefaults)) {
            assertEquals(false, parameterWithDefaults.required);
            assertEquals(false, parameterWithDefaults.allowEmptyValue);
            assertEquals("csv", parameterWithDefaults.collectionFormat);
        }

        for (Header headerWithDefaults : getHeaders(withDefaults)) {
            assertEquals("csv", headerWithDefaults.collectionFormat);
        }

        for (Items itemsWithDefaults : getItems(withDefaults)) {
            assertEquals("csv", itemsWithDefaults.collectionFormat);
        }

        for (Schema schemaWithDefaults : getSchemas(withDefaults)) {
            assertEquals(false, schemaWithDefaults.readOnly);
        }

        for (Xml xmlWithDefaults : getXmls(withDefaults)) {
            assertEquals(false, xmlWithDefaults.attribute);
            assertEquals(false, xmlWithDefaults.wrapped);
        }
    }

    private Iterable<Xml> getXmls(Swagger swagger) {
        return nonNulls(Iterables.transform(getSchemas(swagger), new Function<Schema, Xml>() {
            @Override public Xml apply(Schema input) {
                return input.xml;
            }
        }));
    }

    private Iterable<Schema> getSchemas(Swagger swagger) {
        return nonNulls(Iterables.concat(
            Iterables.transform(getParameters(swagger), new Function<Parameter, Schema>() {
                @Override public Schema apply(Parameter input) {
                    return input.schema;
                }
            }),
            Iterables.transform(getResponses(swagger), new Function<Response, Schema>() {
                @Override public Schema apply(Response input) {
                    return input.schema;
                }
            }),
            getValues(swagger.definitions)
        ));
    }

    private <T> Iterable<T> getValues(Map<?, T> map) {
        return map == null ? Collections.<T>emptyList() : map.values();
    }

    private <T> Iterable<T> getValues(Iterable<T> iterable) {
        return iterable == null ? Collections.<T>emptyList() : iterable;
    }

    private Iterable<Items> getItems(Swagger swagger) {
        Iterable<Items> items = nonNulls(Iterables.concat(
            Iterables.transform(getParameters(swagger), new Function<Parameter, Items>() {
                @Override public Items apply(Parameter input) {
                    return input.items;
                }
            }),
            Iterables.transform(getHeaders(swagger), new Function<Header, Items>() {
                @Override public Items apply(Header input) {
                    return input.items;
                }
            })));
        Iterable<Items> nestedItems = nonNulls(Iterables.transform(items, new Function<Items, Items>() {
            @Override public Items apply(Items input) {
                return input.items;
            }
        }));
        return Iterables.concat(items, nestedItems);
    }

    private Iterable<Operation> getOperations(Swagger swagger) {
        return Iterables.concat(Iterables.transform(swagger.paths.values(), new Function<PathItem, Iterable<Operation>>() {
            @Override public Iterable<Operation> apply(PathItem pathItem) {
                return getOperations(pathItem);
            }
        }));
    }

    private Iterable<Operation> getOperations(PathItem pathItem) {
        return nonNulls(asList(pathItem.get, pathItem.put, pathItem.post, pathItem.delete, pathItem.options, pathItem.head, pathItem.patch));
    }

    private <T> Iterable<T> nonNulls(Iterable<T> iterable) {
        return Iterables.filter(iterable, Predicates.notNull());
    }

    private Iterable<Parameter> getParameters(Swagger swagger) {
        return Iterables.concat(
            getValues(swagger.parameters),
            Iterables.concat(Iterables.transform(swagger.paths.values(), new Function<PathItem, Iterable<? extends Parameter>>() {
                @Override public Iterable<? extends Parameter> apply(PathItem input) {
                    return getParameters(input);
                }
            })));
    }

    private Iterable<Parameter> getParameters(PathItem pathItem) {
        return nonNulls(Iterables.concat(
            getValues(pathItem.parameters),
            Iterables.concat(Iterables.transform(getOperations(pathItem), new Function<Operation, Iterable<? extends Parameter>>() {
                @Override public Iterable<? extends Parameter> apply(Operation input) {
                    return getValues(input.parameters);
                }
            }))));
    }

    private Iterable<Response> getResponses(Swagger swagger) {
        return nonNulls(Iterables.concat(
            getValues(swagger.responses),
            Iterables.concat(Iterables.transform(getOperations(swagger), new Function<Operation, Iterable<? extends Response>>() {
                @Override public Iterable<? extends Response> apply(Operation input) {
                    return getValues(input.responses);
                }
            }))));
    }

    private Iterable<Header> getHeaders(Swagger swagger) {
        return nonNulls(Iterables.concat(Iterables.transform(getResponses(swagger), new Function<Response, Iterable<Header>>() {
            @Override public Iterable<Header> apply(Response input) {
                return getValues(input.headers);
            }
        })));
    }

}
