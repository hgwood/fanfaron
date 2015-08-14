package fr.hgwood.fanfaron;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;

public class Scopes extends ForwardingMap<String, String> {

    private final Map<String, String> scopes = new HashMap<>();

    @Override protected Map<String, String> delegate() {
        return scopes;
    }
}
