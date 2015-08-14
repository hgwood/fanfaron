package fr.hgwood.fanfaron;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.Map;

public class SecurityDefinitions extends ForwardingMap<String, SecurityScheme> {

    private final Map<String, SecurityScheme> securitySchemes = new HashMap<>();

    @Override protected Map<String, SecurityScheme> delegate() {
        return securitySchemes;
    }
}
