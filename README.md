# Fanfaron

A no-surprise Java model of the [Swagger 2.0 specification](https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md).

## Swagger 2.0 Specification Support

Fanfaron is able to deserialize all objects defined in the Swagger 2.0 specification, except for `Schema` and `Xml`,
for which limitations apply. Vendor extensions are not supported. The [Pet Store example](http://petstore.swagger.io/v2/swagger.json)
can be deserialized.

The `Schema` class is meant to be able to deserialize both the [Schema Object](https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#schemaObject)
from the Swagger 2.0 specification and JSON schemas from the [JSON Schema Draft 4 specification](http://json-schema.org/).
The [JSON schema for Swagger 2.0](https://github.com/swagger-api/swagger-spec/blob/master/schemas/v2.0/schema.json) (at
commit [aefeb4d](https://github.com/swagger-api/swagger-spec/commit/aefeb4d140035f98a64d5c1b5fba5fd152096952)) can be
deserialized. Support is defined by the union of the subsets defined by the Pet Store example and the Swagger 2.0 JSON
schema.

Non-exhausitve list of limitations:
- `Schema.items` can only be a schema, not a list of schemas

## Other Features

- Structural equality

## Technical choices

The objects defined by the spec are modeled in the simplest way possible: Java classes with public fields and a correct
`equals` implementation. The types of the fields match the types defined in the spec with the following mapping:

|Type in spec|Type in Fanfaron|
|-|-|
|string|String|
|integer|BigInteger|
|number|BigDecimal|
|boolean|Boolean|
|*|Object|
|T|T|
|[T]|List\<T\>|
|T \| Reference Object|T has a `$ref` field|
|boolean \| Schema|BooleanOrSchema|

Furthermore, objects with dynamically-named fields of type `T` are mapped using classes that implement `Map<String, T>`.

The classes directly mapping the spec are only meant to do just that, and nothing else. They will never have accessors
or any kind of validation. Those belong in adapters and validators, which may be added into this library in the future.

## Changelog

The versioning follows semantic versioning.

### 3.1.0

- feat: support for all fields of all objects defined in the Swagger 2.0 specification except for `Schema` and `Xml`

### 3.0.1

- fix: structural equality broken for `Schema`

### 3.0.0

- *breaking* feat: can deserialize the Swagger 2 JSON schema
  - `AdditionalProperties` class was removed
  - `Schema.additionalProperties` is now of type `BooleanOrSchema` instead of `AdditionalProperties`
  - `Items` class was removed
  - `Schema.items` is now of type `Schema` instead of `Items`

### 2.0.0

- *breaking* feat: support for allowed and forbidden additional properties in a schema
  - `Schema.additionalProperties` is now of type `AdditionalProperties` instead of `Schema`.

### 1.1.0

- feat: structural equality

### 1.0.0

- feat: can deserialize pet store
