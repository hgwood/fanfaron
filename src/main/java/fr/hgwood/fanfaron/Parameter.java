package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.jsonschema.Schema;

import java.math.BigDecimal;

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
}
