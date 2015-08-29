package fr.hgwood.fanfaron;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;

public class ResponsesDefinitions extends ForwardingMap<String, Response> {

    private final Map<String, Response> responses = new HashMap<>();

    @Override protected Map<String, Response> delegate() {
        return responses;
    }

}
