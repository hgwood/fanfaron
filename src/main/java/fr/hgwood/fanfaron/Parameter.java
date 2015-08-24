package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.jsonschema.Schema;

import java.math.BigDecimal;
import java.util.Objects;

public class Parameter {
    public String name;
    public String in;
    public String description;
    public boolean required = false;
    public Schema schema;
    public String type;
    public String format;
    public Items items;
    public String collectionFormat;
    public BigDecimal maximum;
    public BigDecimal minimum;

    @Override public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Parameter)) return false;
        Parameter other = (Parameter)obj;
        return Objects.equals(name, other.name)
            && Objects.equals(in, other.in)
            && Objects.equals(description, other.description)
            && Objects.equals(required, other.required)
            && Objects.equals(schema, other.schema)
            && Objects.equals(type, other.type)
            && Objects.equals(format, other.format)
            && Objects.equals(items, other.items)
            && Objects.equals(collectionFormat, other.collectionFormat)
            && Objects.equals(maximum, other.maximum)
            && Objects.equals(minimum, other.minimum);
    }

    @Override public int hashCode() {
        return Objects.hash(name, in, description, required, schema, type, format, items, collectionFormat, maximum, minimum);
    }
}
