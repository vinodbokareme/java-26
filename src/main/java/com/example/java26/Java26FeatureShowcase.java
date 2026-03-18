package com.example.java26;

import java.security.KeyPair;
import java.util.Arrays;

/**
 * Entry point that exercises the feature examples in this repository.
 *
 * <p>This class is intentionally lightweight: each feature lives in its own helper class so the
 * examples are easy to copy into articles, demos, or workshops.
 */
public final class Java26FeatureShowcase {

    private Java26FeatureShowcase() {
    }

    public static void main(String[] args) throws Exception {
        System.out.println("=== Java 26 Feature Showcase ===");

        var dashboard = StructuredConcurrencyExamples.loadDashboard("user-42");
        System.out.println("Structured concurrency => " + dashboard);

        System.out.println(
                "Primitive switch => " + PrimitivePatternSwitchExamples.describeTemperature(21.5f));

        System.out.println("Lazy constant keys => " + LazyConstantExamples.config().keySet());

        KeyPair keyPair = PemExamples.generateRsaKeyPair();
        String pem = PemExamples.encodePublicKey(keyPair);
        System.out.println("PEM public key header => " + pem.lines().findFirst().orElse("<empty>"));

        float[] summed = VectorApiExamples.add(
                new float[] {1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f},
                new float[] {8f, 7f, 6f, 5f, 4f, 3f, 2f, 1f});
        System.out.println("Vector API => " + Arrays.toString(summed));

        System.out.println("HTTP/3 builder => " + Http3Examples.newHttp3Client().version());
    }
}
