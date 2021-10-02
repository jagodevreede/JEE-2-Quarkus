package com.acme;

import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;

public final class Base64Helper {

    public static String convertToBase64(String input) {
        return new BASE64Encoder().encode(input.getBytes(StandardCharsets.UTF_8));
    }
}
