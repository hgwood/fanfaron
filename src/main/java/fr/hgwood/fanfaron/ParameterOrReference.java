package fr.hgwood.fanfaron;

import java.util.Objects;

public class ParameterOrReference extends Parameter {
    public String $ref;

    public ParameterOrReference() {

    }

    public ParameterOrReference(Parameter parameter) {
        parameter.copyTo(this);
        this.$ref = null;
    }

    @Override public boolean equals(Object obj) {
        return super.equals(obj) && Objects.equals($ref, ((ParameterOrReference)obj).$ref);
    }
}
