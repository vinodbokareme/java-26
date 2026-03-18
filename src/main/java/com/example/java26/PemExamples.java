package com.example.java26;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PEMDecoder;
import java.security.PEMEncoder;
import java.security.PublicKey;

/**
 * Demonstrates Java 26 PEM encoding/decoding APIs.
 */
public final class PemExamples {

    private PemExamples() {
    }

    public static KeyPair generateRsaKeyPair() throws GeneralSecurityException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        return generator.generateKeyPair();
    }

    public static String encodePublicKey(KeyPair keyPair) {
        return PEMEncoder.of().encodeToString(keyPair.getPublic());
    }

    public static PublicKey decodePublicKey(String pemText) {
        return PEMDecoder.of().decode(pemText, PublicKey.class);
    }
}
