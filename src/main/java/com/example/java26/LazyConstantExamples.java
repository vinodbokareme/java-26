package com.example.java26;

import java.lang.LazyConstant;
import java.time.Instant;
import java.util.Map;

/**
 * Demonstrates lazy constants for values that should be initialized on first use instead of at
 * class loading time.
 */
public final class LazyConstantExamples {

    private static final LazyConstant<Map<String, String>> CONFIG =
            LazyConstant.of(LazyConstantExamples::loadConfiguration);

    private LazyConstantExamples() {
    }

    public static Map<String, String> config() {
        return CONFIG.get();
    }

    private static Map<String, String> loadConfiguration() {
        return Map.of(
                "feature.structuredConcurrency", "enabled",
                "feature.http3", "enabled",
                "loadedAt", Instant.now().toString());
    }
}
