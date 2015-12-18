# Fanfaron

A no-surprise Java model of the [Swagger 2.0 specification](https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md).

Fanfaron allows developers to work with Swagger 2.0 definitions using Java. It is an alternative to the swagger-model
module of the swagger-core project. The main advantage over swagger-module is that it is better aligned with the
specification: the model is simpler and matches the specification more closely. This enables Fanfaron to better support
Swagger features, like global security requirements, which are impossible to extract today using swagger-model 1.5.3.

## Get Started

### [Get from Maven Central](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22fanfaron%22)...

```
<dependency>
  <groupId>com.github.hgwood.fanfaron</groupId>
  <artifactId>fanfaron</artifactId>
  <version>6.3.0</version>
</dependency>
```

```
group: 'com.github.hgwood.fanfaron', name: 'fanfaron', version: '6.3.0'
```

### ...or build from sources

```
mvn install
```

### Usage

Use [Jackson Databind](https://github.com/FasterXML/jackson-databind/)'s `ObjectMapper` to read the serialized Swagger
into Fanfaron's `Swagger` class.

```java
try (InputStream swaggerStream = getClass().getResourceAsStream("swagger.json")) {
    return new ObjectMapper().readValue(swaggerStream, fr.hgwood.fanfaron.Swagger.class);
}
```

## What's wrong with [Swagger Core](https://github.com/swagger-api/swagger-core)?

- It lags behind the spec, and the team is reluctant to catch up when it would incur breaking changes.
- The model is polluted because it wants to do everything: ensure backward-compatibility with getters and setters,
provide a builder interface, provide specific shortcut methods to handle collections. This means that there is a lot of
legacy code to maintain, and that the model is more complicated than required.

## Swagger 2.0 Specification Support

Fanfaron is able to deserialize all fields of all objects defined in the Swagger 2.0 specification, with the following
limitations:
- The `items` field of the [Schema Object](https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#schemaObject)
can only be a schema (not an array of schemas).

Furthermore, there is no kind of validation whatsoever, aside from very basic type correctness (see Type mapping). For
example, while the specification says the value of the root `swagger` field "MUST be `"2.0"`", Fanfaron makes no such
verification.

## Other Features

- Structural equality: if all fields of 2 objects are equal, then these 2 objects are equal.
- Traversal with user-defined side-effects (SAX-style).

```java
new SideEffectingDepthFirstVisit(new SimpleVisitor() {
  public void visit(PathItem pathItem, String path) {
    // this method will be called for all path items defined in the swagger definition
  }
  
  public void visit(Operation operation) {
    // same for operations
  }
  
  public void visit(Schema schema, String name) {
    // this method will be called for all named schemas defined in the swagger definition
    // use #visit(Schema) for unnamed schemas
  }
}).run(swagger);
```

- Value defaulting: all default values defined by the spec can be set on any model object. Can be combined with a 
traversal to set all defaults in a definition.

```java
// on a single object
Operation operation = new Operation();
new DefaultFiller().vist(operation);
assertEquals(false, operation.deprecated);

// on a definition
Operation operation = new Operation();
PathItem pathItem = new PathItem();
pathItem.get = operation;
Paths paths = new Paths();
paths.put("/path", pathItem);
Swagger swagger = new Swagger();
swagger.paths = paths;
new SideEffectingDepthFirstVisit(new DefaultFiller()).run(swagger);
assertEquals(false, operation.deprecated);
```

## Technical choices

The objects defined by the spec are modeled in the simplest way possible, which is as Java classes with public fields 
and `equals` and `hashCode` implementations that use all fields.

### Type mapping

The types of the fields match the types defined in the spec with the following mapping:

Type in spec | Type in Fanfaron
------------ | ----------------
string | String
integer | BigInteger
number | BigDecimal
boolean | Boolean
* | Object
T | T
[T] | List\<T\>
T \| Reference Object | TOrReference

Furthermore, objects with dynamically-named fields of type `T` are mapped using classes that implement `Map<String, T>`.

Only one class has a non-obvious mapping: `AdditionalProperties` (the type of the `additionalProperties` field in the
Schema Object). This is because this field can contain either a boolean value or a Schema Object, and that is not
representable in Java. Therefore, `AdditionalProperties` has 2 fields, one for each possibility: `allowed` for the
boolean, and `schema` for the Schema Object.

### Public fields??

The classes directly mapping the spec are only meant to do just that, and nothing else. They will never have accessors
or any kind of validation. Those belong in adapters and validators, which may be added into this library in the future.

## Roadmap

- 100% spec support
- Validation
- An easier way to build a model from Java
- An easier way to work with the model, either through utility functions that manipulate the JSON model, or a
higher-level model with proper Java types and useful methods.
  - Optional and empty collections instead of null
  - Value to key references for objects with patterned fields (operation to HTTP method, response to status code, ...)
  - Dereferencing
  - Traversal
  - Collecting all entities of the same type (all parameters, all responses, ...)
  - Types guarantee valid entities
  - Other things?

## Change log

The versioning follows semantic versioning.

### 6.3.1

- fix: recursive defaulting vastly improved
  - It no longer chokes on `null`s while traversing the object tree.
  - It no longer cuts out part of the object tree.

### 6.3.0

- feat: added vendor extensions support
- fix: added `hashCode` to `DynamicObject`

### 6.2.0

- chore: migrated build to Maven

### 6.1.0

- feat: recursive value defaulting
  - Any model object can be traversed to set all default values defined by the spec.
  
> **Edit**: it was found later that this new feature was incomplete and buggy due to insufficient testing. It was 
> improved in 6.3.1.

### 6.0.0

- *breaking* refactor: type mapping changed for `T | Reference Object`
  - Previously, all types that could be unioned with a Reference Object had a `$ref` field. However those types are also
  used standalone in the specification. To bring the type mapping closer to the specification, these types no longer
  have a `$ref` field. Impacted types are `Parameter` and `Response`. To deal with the union case, companion types were
  added and named using the pattern `TOrReference`: `ParameterOrReference` and `ResponseOrReference`. These two types
  extends their respective standalone type, and add a `$ref` field. It now as easy to distinguish places where
  references are accepted and those where they are not as it is in the specification.

### 5.0.1

- fix: missing `$ref` in `Response`
- refactor: replaced Guava's `ForwardingMap` by own class
  - Guava is no longer a dependency.

### 5.0.0

- *breaking* feat: removed all default values
  - `exclusiveMaximum` and `exclusiveMinimum` in `Header` no longer default to `false`.
  - `exclusiveMaximum` and `exclusiveMinimum` in `Items` no longer default to `false`.
  - `deprecated` in `Operation` no longer defaults to `false.`
  - `required` in `Parameter` is now of type `Boolean` instead of `boolean`.
  - `exclusiveMaximum` and `exclusiveMinimum` in `Parameter` no longer default to `false`.
  - `wrapped` in `Xml` no longer defaults to `false`.

### 4.0.0

- *breaking* refactor: `Schema` for Swagger 2 made distinct from `Schema` for JSON Schema Draft 4
  - All classes defined from objects found in the Swagger 2.0 specification are now found in the package
  `fr.hgwood.fanfaron`. Classes in `fr.hgwood.fanfaron.jsonschema` are not used to deserialize Swagger definitions.
  - The new `fr.hgwood.fanfaron.Schema` exactly matches the Schema Object defined by the Swagger 2.0 specification.
  - `Xml` was moved to `fr.hgwood.fanfaron`, as it is specific to Swagger 2.0.
  - `Properties` and `AdditionalProperties` were added to `fr.hgwood.fanfaron`. Those are not explicitly defined by
  the Swagger 2.0 specification, only implicitly.
  - Fields `xml` and `example`, which are specific to Swagger 2.0, were removed from `fr.hgwood.fanfaron.jsonschema.Schema`
  - Classes in `fr.hgwood.fanfaron.jsonschema` can still be used to deserialize the JSON schema subset defined by the
  Swagger 2.0 JSON schema, although that is no longer documented. Those classes might be moved to another library.
- feat: all fields for `Xml`

### 3.1.0

- feat: support for all fields of all objects defined in the Swagger 2.0 specification except for `Schema` and `Xml`

> **Edit**: it was found later that the `$ref` field was missing from `Response`. This is fixed in 5.0.1.

> **Edit**: it was found later that the `items` field from the spec's Schema object supports both a schema and an array
> of schemas. Fanfaron 3.1.0 only supports the first case.

### 3.0.1

- fix: structural equality broken for `Schema`

### 3.0.0

- *breaking* feat: can deserialize the Swagger 2 JSON schema
  - `AdditionalProperties` class was removed.
  - `Schema.additionalProperties` is now of type `BooleanOrSchema` instead of `AdditionalProperties`.
  - `Items` class was removed.
  - `Schema.items` is now of type `Schema` instead of `Items`.

### 2.0.0

- *breaking* feat: support for allowed and forbidden additional properties in a schema
  - `Schema.additionalProperties` is now of type `AdditionalProperties` instead of `Schema`.

### 1.1.0

- feat: structural equality

### 1.0.0

- feat: can deserialize pet store
