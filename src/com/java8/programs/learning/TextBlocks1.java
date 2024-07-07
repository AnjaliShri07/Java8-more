package com.java8.programs.learning;

public class TextBlocks1 {
    public static void main(String[] args) {
        String stringJSON = "Mahesh";

        String textBlockJSON = """
      Mahesh""";
        // compare the content
        System.out.println(textBlockJSON.equals(stringJSON));

        // compare the objects
        System.out.println(textBlockJSON == stringJSON);

        // text block supports all string operations
        System.out.println("Contains: " + textBlockJSON.contains("Mahesh"));
        System.out.println("indexOf: " + textBlockJSON.indexOf("Mahesh"));
        System.out.println("Length: " + textBlockJSON.length());
    }
}
