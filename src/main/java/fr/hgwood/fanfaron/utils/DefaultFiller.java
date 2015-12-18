package fr.hgwood.fanfaron.utils;

import fr.hgwood.fanfaron.*;

public class DefaultFiller extends SimpleVisitor {

    @Override
    public void visit(Operation operation) {
        operation.deprecated = firstNonNull(operation.deprecated, false);
    }

    @Override
    public void visit(Parameter parameter, String name) {
        parameter.required = firstNonNull(parameter.required, false);
        parameter.allowEmptyValue = firstNonNull(parameter.allowEmptyValue, false);
        parameter.collectionFormat = firstNonNull(parameter.collectionFormat, "csv");
    }

    @Override
    public void visit(Items items) {
        items.collectionFormat = firstNonNull(items.collectionFormat, "csv");
    }

    @Override
    public void visit(Header header) {
        header.collectionFormat = firstNonNull(header.collectionFormat, "csv");
    }

    @Override
    public void visit(Schema schema) {

    }

    @Override
    public void visit(Schema schema, String name) {
        schema.readOnly = firstNonNull(schema.readOnly, false);
    }

    @Override
    public void visit(Xml xml) {
        xml.attribute = firstNonNull(xml.attribute, false);
        xml.wrapped = firstNonNull(xml.wrapped, false);
    }

    private <T> T firstNonNull(T a, T b) {
        return a == null ? b : a;
    }
}
