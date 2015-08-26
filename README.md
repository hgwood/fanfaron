# Fanfaron

A no-surprise Java model of the [Swagger 2.0 specification](https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md).

## Swagger 2.0 Specification Support

Fanfaron is able to deserialize the subset of the specification defined by the [Pet Store example](http://petstore.swagger.io/v2/swagger.json).
That means the Pet Store example can be fully deserialized into a Fanfaron model, but that any Swagger that makes use
of a property that does not appear in the Pet Store example will fail to deserialize.

## Features

- Structural equality

## Changelog

The versioning follows semantic versioning.

### 3.0.1

- fix: structural equality broken for Schema

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
