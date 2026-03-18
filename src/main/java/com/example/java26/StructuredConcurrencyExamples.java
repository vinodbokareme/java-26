package com.example.java26;

import java.time.Duration;
import java.util.concurrent.StructuredTaskScope;

/**
 * Java 26 structured concurrency example.
 *
 * <p>The example simulates a classic backend aggregation call where a controller or service needs
 * to fetch profile, orders, and recommendations together. The scope guarantees that the subtasks
 * have a single, explicit lifecycle.
 */
public final class StructuredConcurrencyExamples {

    private StructuredConcurrencyExamples() {
    }

    public static Dashboard loadDashboard(String userId) throws Exception {
        try (var scope = StructuredTaskScope.open()) {
            StructuredTaskScope.Subtask<String> profile = scope.fork(() -> fetchProfile(userId));
            StructuredTaskScope.Subtask<String> orders = scope.fork(() -> fetchOrders(userId));
            StructuredTaskScope.Subtask<String> recommendations =
                    scope.fork(() -> fetchRecommendations(userId));

            scope.join();

            return new Dashboard(profile.get(), orders.get(), recommendations.get());
        }
    }

    private static String fetchProfile(String userId) throws InterruptedException {
        Thread.sleep(Duration.ofMillis(40));
        return "Profile(" + userId + ")";
    }

    private static String fetchOrders(String userId) throws InterruptedException {
        Thread.sleep(Duration.ofMillis(20));
        return "Orders(last-5 for " + userId + ")";
    }

    private static String fetchRecommendations(String userId) throws InterruptedException {
        Thread.sleep(Duration.ofMillis(25));
        return "Recommendations(personalized for " + userId + ")";
    }

    public record Dashboard(String profile, String orders, String recommendations) {
    }
}
