package ru.gavryushkin.parser.bitmex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Hex {

    public Hex() {
    }

    public static String hmacSha256(String value, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] keyBytes = key.getBytes();
        SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);
        byte[] rawHmac = mac.doFinal(value.getBytes());
        System.out.println(String.format("%0" + (rawHmac.length << 1) + "x", new BigInteger(1, rawHmac)));
        return String.format("%0" + (rawHmac.length << 1) + "x", new BigInteger(1, rawHmac));
    }
}



