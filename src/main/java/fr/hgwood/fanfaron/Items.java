package fr.hgwood.fanfaron;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Items {
    public String type;
    @JsonProperty("default") public Object _default;
    @JsonProperty("enum") public List<Object> _enum;
}
