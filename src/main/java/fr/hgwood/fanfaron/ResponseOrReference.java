package fr.hgwood.fanfaron;

import java.util.Objects;

public class ResponseOrReference extends Response {
    public String $ref;

    @Override public boolean equals(Object obj) {
        return super.equals(obj) && Objects.equals($ref, ((ResponseOrReference)obj).$ref);
    }
}
