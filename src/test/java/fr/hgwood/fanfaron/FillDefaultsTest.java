package fr.hgwood.fanfaron;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import fr.hgwood.fanfaron.utils.DefaultFiller;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Predicates.notNull;
import static com.google.common.collect.Iterables.*;
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

    @Test public void travels_down_intermediaries_avoiding_nulls() {
        DefaultFiller defaultFiller = new DefaultFiller();
        defaultFiller.fillDefaults(new Swagger());
        defaultFiller.fillDefaults(new Response());
        defaultFiller.fillDefaults(new PathItem());
    }

    @Test public void recursively_sets_defaults() {
        // Given
        Swagger swagger = new Swagger();

        Operation operation = new Operation();
        PathItem pathItem = new PathItem();
        pathItem.get = new Operation();
        pathItem.put = new Operation();
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
        assertEquals(size(getOperations(swagger)), size(getOperations(withDefaults)));
        for (Operation operationWithDefaults : getOperations(withDefaults)) {
            assertEquals(false, operationWithDefaults.deprecated);
        }

        assertEquals(size(getParameters(swagger)), size(getParameters(withDefaults)));
        for (Parameter parameterWithDefaults : getParameters(withDefaults)) {
            assertEquals(false, parameterWithDefaults.required);
            assertEquals(false, parameterWithDefaults.allowEmptyValue);
            assertEquals("csv", parameterWithDefaults.collectionFormat);
        }

        assertEquals(size(getHeaders(swagger)), size(getHeaders(withDefaults)));
        for (Header headerWithDefaults : getHeaders(withDefaults)) {
            assertEquals("csv", headerWithDefaults.collectionFormat);
        }

        assertEquals(size(getItems(swagger)), size(getItems(withDefaults)));
        for (Items itemsWithDefaults : getItems(withDefaults)) {
            assertEquals("csv", itemsWithDefaults.collectionFormat);
        }

        assertEquals(size(getSchemas(swagger)), size(getSchemas(withDefaults)));
        for (Schema schemaWithDefaults : getSchemas(withDefaults)) {
            assertEquals(false, schemaWithDefaults.readOnly);
        }

        assertEquals(size(getXmls(swagger)), size(getXmls(withDefaults)));
        for (Xml xmlWithDefaults : getXmls(withDefaults)) {
            assertEquals(false, xmlWithDefaults.attribute);
            assertEquals(false, xmlWithDefaults.wrapped);
        }
    }

    private Iterable<Xml> getXmls(Swagger swagger) {
        return FluentIterable
            .from(getSchemas(swagger))
            .transform(new Function<Schema, Xml>() {
                @Override public Xml apply(Schema input) {
                    return input.xml;
                }
            })
            .filter(notNull());
    }

    private Iterable<Schema> getSchemas(Swagger swagger) {
        Iterable<Schema> schemasFromParameters = FluentIterable.from(getParameters(swagger))
            .transform(new Function<Parameter, Schema>() {
                @Override public Schema apply(Parameter input) {
                    return input.schema;
                }
            });
        Iterable<Schema> schemasfromResponses = FluentIterable.from(getResponses(swagger))
            .transform(new Function<Response, Schema>() {
                @Override public Schema apply(Response input) {
                    return input.schema;
                }
            });
        return FluentIterable.from(getValues(swagger.definitions))
            .append(schemasFromParameters)
            .append(schemasfromResponses)
            .filter(notNull());
    }

    private <T> Iterable<T> getValues(Map<?, T> map) {
        return filter(firstNonNull(map, Collections.<Object, T>emptyMap()).values(), notNull());
    }

    private <T> Iterable<T> getValues(Iterable<T> iterable) {
        return filter(firstNonNull(iterable, Collections.<T>emptyList()), notNull());
    }

    private Iterable<Items> getItems(Swagger swagger) {
        FluentIterable<Items> itemsFromParameters = FluentIterable.from(getParameters(swagger))
            .transform(new Function<Parameter, Items>() {
                @Override public Items apply(Parameter input) {
                    return input.items;
                }
            })
            .filter(notNull());
        FluentIterable<Items> itemsFromHeaders = FluentIterable.from(getHeaders(swagger))
            .transform(new Function<Header, Items>() {
                @Override public Items apply(Header input) {
                    return input.items;
                }
            })
            .filter(notNull());
        Iterable<Items> itemsFromItems = itemsFromParameters.append(itemsFromHeaders)
            .transform(new Function<Items, Items>() {
                @Override public Items apply(Items input) {
                    return input.items;
                }
            })
            .filter(notNull());
        return concat(itemsFromParameters, itemsFromHeaders, itemsFromItems);
    }

    private Iterable<Operation> getOperations(Swagger swagger) {
        return FluentIterable.from(getValues(swagger.paths))
            .transformAndConcat(new Function<PathItem, Iterable<Operation>>() {
                @Override public Iterable<Operation> apply(PathItem pathItem) {
                    return getOperations(pathItem);
                }
            });
    }

    private Iterable<Operation> getOperations(PathItem pathItem) {
        return FluentIterable.of(new Operation[] {
            pathItem.get, pathItem.put, pathItem.post, pathItem.delete, pathItem.options, pathItem.head, pathItem.patch
        }).filter(notNull());
    }

    private Iterable<Parameter> getParameters(Swagger swagger) {
        return FluentIterable.from(getValues(swagger.paths))
            .transformAndConcat(new Function<PathItem, Iterable<? extends Parameter>>() {
                @Override public Iterable<? extends Parameter> apply(PathItem input) {
                    return getParameters(input);
                }
            })
            .append(getValues(swagger.parameters));
    }

    private Iterable<Parameter> getParameters(PathItem pathItem) {
        return FluentIterable.from(getOperations(pathItem))
            .transformAndConcat(new Function<Operation, Iterable<? extends Parameter>>() {
                @Override public Iterable<? extends Parameter> apply(Operation input) {
                    return getValues(input.parameters);
                }
            })
            .append(getValues(pathItem.parameters));
    }

    private Iterable<Response> getResponses(Swagger swagger) {
        return FluentIterable.from(getOperations(swagger))
            .transformAndConcat(new Function<Operation, Iterable<? extends Response>>() {
                @Override public Iterable<? extends Response> apply(Operation input) {
                    return getValues(input.responses);
                }
            })
            .append(getValues(swagger.responses));
    }

    private Iterable<Header> getHeaders(Swagger swagger) {
        return FluentIterable.from(getResponses(swagger))
            .transformAndConcat(new Function<Response, Iterable<Header>>() {
                @Override public Iterable<Header> apply(Response input) {
                    return getValues(input.headers);
                }
            });
    }

}
