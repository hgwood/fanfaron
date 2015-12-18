package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.utils.vendorextensions.VendorExtensions;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

import static java.lang.String.format;
import static java.util.Collections.emptyList;
import static org.junit.Assert.assertNotEquals;

public class StructuralEqualityTest {

    @Test public void test() throws Exception {
        assertStructuralEquality(Swagger.class);
    }

    private <T> void assertStructuralEquality(Class<T> type) throws Exception {
        Set<Class<?>> visited = new HashSet<>();
        Queue<Class<?>> remaining = new LinkedList<>();
        remaining.add(type);
        while (!remaining.isEmpty()) {
            Class<?> current = remaining.remove();
            for (Class<?> nestedType : nestedTypes(current)) {
                if (isFromFanfaron(nestedType) && visited.add(nestedType)) remaining.add(nestedType);
            }
        }
    }

    private boolean isFromFanfaron(Class<?> mapType) {
        return mapType.getCanonicalName().startsWith(getClass().getPackage().getName());
    }

    private Class<?> typeOfValues(Class<?> type) {
        Type typeOfValues = ((ParameterizedType)type.getGenericSuperclass()).getActualTypeArguments()[0];
        if (typeOfValues instanceof ParameterizedType) {
            typeOfValues = ((ParameterizedType)typeOfValues).getActualTypeArguments()[0];
        }
        return (Class<?>)typeOfValues;
    }

    private <T> Collection<Class<?>> nestedTypes(Class<T> type) throws Exception {
        if (Map.class.isAssignableFrom(type)) {
            return Collections.<Class<?>>singletonList(typeOfValues(type));
        }
        Collection<Class<?>> nestedTypes = new ArrayList<>();
        for (Field field : type.getFields()) {
            assertIsInEqual(type, field);
            if (List.class.isAssignableFrom(field.getType())) {
                nestedTypes.add((Class<?>)((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0]);
            } else {
                nestedTypes.add(field.getType());
            }
        }
        return nestedTypes;
    }

    private <T> void assertIsInEqual(Class<T> _class, Field field) throws Exception {
        T reference = _class.newInstance();
        T mutated = _class.newInstance();
        if (field.getType() == List.class) field.set(mutated, emptyList());
        else if (field.getType() == boolean.class) field.set(mutated, true);
        else if (field.getType() == Boolean.class) field.set(mutated, true);
        else if (field.getType() == BigInteger.class) field.set(mutated, BigInteger.ONE);
        else if (field.getType() == BigDecimal.class) field.set(mutated, BigDecimal.ONE);
        else if (field.getName().equals("vendorExtensions")) {
            VendorExtensions mutatedVendorExtensions = new VendorExtensions();
            mutatedVendorExtensions.put("x-key", "value");
            field.set(mutated, mutatedVendorExtensions);
        } else {
            try {
                field.set(mutated, field.getType().newInstance());
            } catch (InstantiationException e) {
                throw new RuntimeException(format("cannot instantiate type '%s' for field '%s' of class '%s'",
                    field.getType().getCanonicalName(), field.getName(), _class.getCanonicalName()), e);
            }
        }
        assertNotEquals(
            format("the field '%s' is missing from equals in class '%s'", field.getName(), _class.getCanonicalName()),
            reference,
            mutated);
    }

}
