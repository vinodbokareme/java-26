package com.example.java26;

/**
 * Demonstrates Java 26 primitive-aware switch patterns.
 */
public final class PrimitivePatternSwitchExamples {

    private PrimitivePatternSwitchExamples() {
    }

    public static String describeTemperature(float celsius) {
        return switch (celsius) {
            case 0f -> "freezing point";
            case float value when value < 0f -> "below freezing: " + value + "°C";
            case float value when value < 18f -> "cool: " + value + "°C";
            case float value when value < 28f -> "comfortable: " + value + "°C";
            case float value -> "hot: " + value + "°C";
        };
    }

    public static String describePercentage(double ratio) {
        double percentage = ratio * 100d;
        return switch (percentage) {
            case 100d -> "perfect score";
            case double value when value >= 90d -> "excellent";
            case double value when value >= 75d -> "good";
            case double value when value >= 50d -> "needs improvement";
            case double value -> "critical: " + value + "%";
        };
    }
}
