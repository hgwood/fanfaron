package fr.hgwood.fanfaron.utils.vendorextensions;

import fr.hgwood.fanfaron.utils.DynamicObject;

import static java.lang.String.format;

public class VendorExtensions extends DynamicObject<Object> {

    @Override public Object put(String key, Object value) {
        if (isVendorExtension(key)) return super.put(key, value);
        else throw new IllegalArgumentException(format("Unrecognized field '%s' (%s)", key, getClass()));
    }

    public static boolean isVendorExtension(String key) {
        return key.startsWith("x-");
    }

}
