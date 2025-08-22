package com.example.api.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class TestDataLoader {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<Map<String, Object>> loadJsonArray(String filePath) {
        try (InputStream input = TestDataLoader.class.getClassLoader().getResourceAsStream(filePath)) {
            if (input == null) {
                throw new RuntimeException("Test data file not found: " + filePath);
            }
            return mapper.readValue(input, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test data: " + e.getMessage(), e);
        }
    }
}
