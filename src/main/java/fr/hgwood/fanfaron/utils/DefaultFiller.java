package fr.hgwood.fanfaron.utils;

import fr.hgwood.fanfaron.*;

public class DefaultFiller {

    public Operation fillDefaults(Operation operation) {
        Operation result = new Operation();
        result.deprecated = firstNonNull(operation.deprecated, false);
        return result;
    }

    public Parameter fillDefaults(Parameter parameter) {
        Parameter result = new Parameter();
        result.required = firstNonNull(parameter.required, false);
        result.allowEmptyValue = firstNonNull(parameter.allowEmptyValue, false);
        result.collectionFormat = firstNonNull(parameter.collectionFormat, "csv");
        return result;
    }

    public Items fillDefaults(Items items) {
        Items result = new Items();
        result.collectionFormat = firstNonNull(items.collectionFormat, "csv");
        return result;
    }

    public Header fillDefaults(Header header) {
        Header result = new Header();
        result.collectionFormat = firstNonNull(header.collectionFormat, "csv");
        return result;
    }

    public Schema fillDefaults(Schema schema) {
        Schema result = new Schema();
        result.readOnly = firstNonNull(schema.readOnly, false);
        return result;
    }

    public Xml fillDefaults(Xml xml) {
        Xml result = new Xml();
        result.attribute = firstNonNull(xml.attribute, false);
        result.wrapped = firstNonNull(xml.wrapped, false);
        return result;
    }

    private <T> T firstNonNull(T a, T b) {
        return a == null ? b : a;
    }
}
