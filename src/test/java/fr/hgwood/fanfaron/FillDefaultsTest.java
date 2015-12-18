package fr.hgwood.fanfaron;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import fr.hgwood.fanfaron.utils.DefaultFiller;
import fr.hgwood.fanfaron.utils.traversal.SideEffectingDepthFirstVisit;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Predicates.notNull;
import static com.google.common.collect.Iterables.*;
import static org.junit.Assert.assertEquals;

public class FillDefaultsTest {

    @Test public void operation_deprecated_defaults_to_false() {
        Operation operation = new Operation();
        new DefaultFiller().visit(operation);
        assertEquals("default was not set", false, operation.deprecated);
    }

    @Test public void operation_deprecated_no_override() {
        Operation operation = new Operation();
        operation.deprecated = true;
        new DefaultFiller().visit(operation);
        assertEquals("existing value was overridden", true, operation.deprecated);
    }

    @Test public void parameter_required_defaults_to_false() {
        Parameter parameter = new Parameter();
        new DefaultFiller().visit(parameter, null);
        assertEquals("default was not set", false, parameter.required);
    }

    @Test public void parameter_required_no_override() {
        Parameter parameter = new Parameter();
        parameter.required = true;
        new DefaultFiller().visit(parameter, null);
        assertEquals("existing value was overridden", true, parameter.required);
    }

    @Test public void parameter_allowEmptyValue_defaults_to_false() {
        Parameter parameter = new Parameter();
        new DefaultFiller().visit(parameter, null);
        assertEquals("default was not set", false, parameter.allowEmptyValue);
    }

    @Test public void parameter_allowEmptyValue_no_override() {
        Parameter parameter = new Parameter();
        parameter.allowEmptyValue = true;
        new DefaultFiller().visit(parameter, null);
        assertEquals("existing value was overridden", true, parameter.allowEmptyValue);
    }

    @Test public void parameter_collectionFormat_defaults_to_csv() {
        Parameter parameter = new Parameter();
        new DefaultFiller().visit(parameter, null);
        assertEquals("default was not set", "csv", parameter.collectionFormat);
    }

    @Test public void parameter_collectionFormat_no_override() {
        Parameter parameter = new Parameter();
        parameter.collectionFormat = "pipes";
        new DefaultFiller().visit(parameter, null);
        assertEquals("existing value was overridden", "pipes", parameter.collectionFormat);
    }

    @Test public void items_collectionFormat_defaults_to_csv() {
        Items items = new Items();
        new DefaultFiller().visit(items);
        assertEquals("default was not set", "csv", items.collectionFormat);
    }

    @Test public void items_collectionFormat_no_override() {
        Items items = new Items();
        items.collectionFormat = "pipes";
        new DefaultFiller().visit(items);
        assertEquals("existing value was overridden", "pipes", items.collectionFormat);
    }

    @Test public void header_collectionFormat_defaults_to_csv() {
        Header header = new Header();
        new DefaultFiller().visit(header);
        assertEquals("default was not set", "csv", header.collectionFormat);
    }

    @Test public void header_collectionFormat_no_override() {
        Header header = new Header();
        header.collectionFormat = "pipes";
        new DefaultFiller().visit(header);
        assertEquals("existing value was overridden", "pipes", header.collectionFormat);
    }

    @Test public void schema_readOnly_defaults_to_false() {
        Schema schema = new Schema();
        new DefaultFiller().visit(schema, null);
        assertEquals("default was not set", false, schema.readOnly);
    }

    @Test public void schema_readOnly_no_override() {
        Schema schema = new Schema();
        schema.readOnly = true;
        new DefaultFiller().visit(schema, null);
        assertEquals("existing value was overridden", true, schema.readOnly);
    }

    @Test public void xml_attribute_defaults_to_false() {
        Xml xml = new Xml();
        new DefaultFiller().visit(xml);
        assertEquals("default was not set", false, xml.attribute);
    }

    @Test public void xml_attribute_no_override() {
        Xml xml = new Xml();
        xml.attribute = true;
        new DefaultFiller().visit(xml);
        assertEquals("existing value was overridden", true, xml.attribute);
    }

    @Test public void xml_wrapped_defaults_to_false() {
        Xml xml = new Xml();
        new DefaultFiller().visit(xml);
        assertEquals("default was not set", false, xml.wrapped);
    }

    @Test public void xml_wrapped_no_override() {
        Xml xml = new Xml();
        xml.wrapped = true;
        new DefaultFiller().visit(xml);
        assertEquals("existing value was overridden", true, xml.wrapped);
    }

    @Test public void travels_down_intermediaries_avoiding_nulls() {
        DefaultFiller defaultFiller = new DefaultFiller();
        defaultFiller.visit(new Swagger());
        defaultFiller.visit(new Response(), null);
        defaultFiller.visit(new PathItem(), null);
    }

    // TODO: this is a really a test of SideEffectingDepthFirstVisit and should move to another test class
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
        new SideEffectingDepthFirstVisit(new DefaultFiller()).traverse(swagger);

        // Then
        assertEquals(size(getOperations(swagger)), size(getOperations(swagger)));
        for (Operation operationWithDefaults : getOperations(swagger)) {
            assertEquals(false, operationWithDefaults.deprecated);
        }

        assertEquals(size(getParameters(swagger)), size(getParameters(swagger)));
        for (Parameter parameterWithDefaults : getParameters(swagger)) {
            assertEquals(false, parameterWithDefaults.required);
            assertEquals(false, parameterWithDefaults.allowEmptyValue);
            assertEquals("csv", parameterWithDefaults.collectionFormat);
        }

        assertEquals(size(getHeaders(swagger)), size(getHeaders(swagger)));
        for (Header headerWithDefaults : getHeaders(swagger)) {
            assertEquals("csv", headerWithDefaults.collectionFormat);
        }

        assertEquals(size(getItems(swagger)), size(getItems(swagger)));
        for (Items itemsWithDefaults : getItems(swagger)) {
            assertEquals("csv", itemsWithDefaults.collectionFormat);
        }

        assertEquals(size(getSchemas(swagger)), size(getSchemas(swagger)));
        for (Schema schemaWithDefaults : getSchemas(swagger)) {
            assertEquals(false, schemaWithDefaults.readOnly);
        }

        assertEquals(size(getXmls(swagger)), size(getXmls(swagger)));
        for (Xml xmlWithDefaults : getXmls(swagger)) {
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
