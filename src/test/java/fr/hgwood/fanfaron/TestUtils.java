package fr.hgwood.fanfaron;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public class TestUtils {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T deserialize(Class<?> parentOfResource, String resourcePath, Class<T> targetClass) {
        URL resourceUrl = parentOfResource.getResource(resourcePath);
        requireNonNull(resourceUrl, format("resource '%s' of class '%s' not found", resourcePath, parentOfResource.getCanonicalName()));
        try {
            return objectMapper.readValue(resourceUrl, targetClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
