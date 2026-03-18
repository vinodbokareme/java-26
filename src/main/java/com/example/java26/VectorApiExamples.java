package com.example.java26;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

/**
 * Demonstrates the incubating Vector API with a simple array addition example.
 */
public final class VectorApiExamples {

    private static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    private VectorApiExamples() {
    }

    public static float[] add(float[] left, float[] right) {
        if (left.length != right.length) {
            throw new IllegalArgumentException("Both arrays must have the same length");
        }

        float[] result = new float[left.length];
        int index = 0;
        int upperBound = SPECIES.loopBound(left.length);

        for (; index < upperBound; index += SPECIES.length()) {
            FloatVector leftVector = FloatVector.fromArray(SPECIES, left, index);
            FloatVector rightVector = FloatVector.fromArray(SPECIES, right, index);
            leftVector.add(rightVector).intoArray(result, index);
        }

        for (; index < left.length; index++) {
            result[index] = left[index] + right[index];
        }

        return result;
    }
}
