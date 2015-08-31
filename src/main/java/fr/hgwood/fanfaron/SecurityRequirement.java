package fr.hgwood.fanfaron;

import com.google.common.collect.ForwardingMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#securityRequirementObject
 */
public class SecurityRequirement extends ForwardingMap<String, List<String>> {
    private final Map<String, List<String>> securityRequirements = new HashMap<>();

    @Override protected Map<String, List<String>> delegate() {
        return securityRequirements;
    }
}
