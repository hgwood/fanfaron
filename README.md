# Fanfaron

A no-surprise Java model of the [Swagger 2.0 specification](https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md).

## Swagger 2.0 Specification Support

Fanfaron is able to deserialize the subset of the specification defined by the [Pet Store example](http://petstore.swagger.io/v2/swagger.json).
That means the Pet Store example can be fully deserialized into a Fanfaron model, but that any Swagger that makes use
of a property that does not appear in the Pet Store example will fail to deserialize.

## Features

- Structural equality
