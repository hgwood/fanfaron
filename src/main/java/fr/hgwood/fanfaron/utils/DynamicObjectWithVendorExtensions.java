package fr.hgwood.fanfaron.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

import static fr.hgwood.fanfaron.utils.VendorExtensions.isVendorExtension;

public class DynamicObjectWithVendorExtensions<T> extends DynamicObject<T> {
    @JsonIgnore public VendorExtensions vendorExtensions = new VendorExtensions();

    @JsonCreator public DynamicObjectWithVendorExtensions(Map<String, ?> properties) {
        for (Map.Entry<String, ?> property : properties.entrySet()) {
            if (isVendorExtension(property.getKey())) vendorExtensions.put(property.getKey(), property.getValue());
            else super.put(property.getKey(), (T)property.getValue());
        }
    }

    public DynamicObjectWithVendorExtensions() {
        this(new HashMap<String, Object>());
    }
}
