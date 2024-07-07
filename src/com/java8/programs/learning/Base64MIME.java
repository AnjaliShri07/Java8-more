package com.java8.programs.learning;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class Base64MIME {
    public static void main(String[] args) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 10; ++i) {
            stringBuilder.append(UUID.randomUUID().toString());
            stringBuilder.append(",");
        }

        byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
        System.out.println("Base64 Encoded String (MIME) : " + mimeEncodedString);

        // Decode the base64 encoded string using url decoder
        byte[] base64decodedBytes = Base64.getMimeDecoder().decode(mimeEncodedString);
        // print the decoded string
        System.out.println("Decoded String: " + new String(base64decodedBytes, "utf-8"));
    }
}
