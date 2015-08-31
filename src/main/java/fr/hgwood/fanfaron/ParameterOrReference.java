package fr.hgwood.fanfaron;

import java.util.Objects;

public class ParameterOrReference extends Parameter {
    public String $ref;

    @Override public boolean equals(Object obj) {
        return super.equals(obj) && Objects.equals($ref, ((ParameterOrReference)obj).$ref);
    }
}
