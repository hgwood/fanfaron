package fr.hgwood.fanfaron;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;

public class Paths extends ForwardingMap<String, PathItem> {

    private final Map<String, PathItem> paths = new HashMap<>();

    @Override protected Map<String, PathItem> delegate() {
        return paths;
    }

}
