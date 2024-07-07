package com.java8.programs.learning;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Tester {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String stringToEncode = "TutorialsPoint?java";
        // Encode using basic encoder
        String base64encodedString = Base64.getEncoder().encodeToString(stringToEncode.getBytes("utf-8"));
        System.out.println("Encoded String: " + base64encodedString);

        // Decode the base64 encoded string using basic decoder
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        // print the decoded string
        System.out.println("Decoded String: " + new String(base64decodedBytes, "utf-8"));
    }
}
