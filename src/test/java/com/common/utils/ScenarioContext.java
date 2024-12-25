package com.common.utils;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Map<String, Object> context;

    public ScenarioContext() {
        context = new HashMap<>();
    }

    public void set(String key, Object value) {
        context.put(key, value);
    }

    public <T> T get(String key) {
        return (T) context.get(key);
    }

    public boolean containsKey(String key) {
        return context.containsKey(key);
    }
}
