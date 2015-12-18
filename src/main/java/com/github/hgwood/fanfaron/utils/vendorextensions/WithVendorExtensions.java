package com.github.hgwood.fanfaron.utils.vendorextensions;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

public class WithVendorExtensions {
    @JsonIgnore public VendorExtensions vendorExtensions = new VendorExtensions();

    @JsonAnySetter private void addVendorExtension(String key, Object value) {
        vendorExtensions.put(key, value);
    }

    @JsonAnyGetter private Map<String, Object> getVendorExtensions() {
        return vendorExtensions;
    }
}
