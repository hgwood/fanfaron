package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.utils.DynamicObject;

import java.util.List;
import java.util.Map;

/**
 * https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#securityRequirementObject
 */
public class SecurityRequirement extends DynamicObject<List<String>> {
    public SecurityRequirement(Map<String, List<String>> securityRequirements) {
        super(securityRequirements);
    }

    public SecurityRequirement() {
        super();
    }
}
