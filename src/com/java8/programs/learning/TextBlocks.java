package com.java8.programs.learning;

/*Java made text blocks in Java 15 as a standard feature to handle multiline strings like JSON/XML/HTML etc.
It was introduced in Java 13 as a preview feature.

        Text Block allows to write multiline strings easily without using \r\n.

        Text Block string have same methods as string (String class methods) like contains(), indexOf(), and length() functions.

        Purpose of introducing text block is mainly to declare multi-line strings most efficiently. Prior to text block,
        we can declare multi-line strings using string concatenation, string builder append method, string join method but that approach is quite messy.
        As we have to use line terminators, delimiters etc to mark a new line. Text block provides a better and alternate approach to define multiline
        string using a """, 3 double-quotes mark.*/

public class TextBlocks {
    public static void main(String[] args) {
        String stringJSON = "{\r\n"
                + "   \"Name\" : \"Mahesh\",\r\n"
                + "   \"RollNO\" : \"32\"\r\n"
                + "}";

        System.out.println(stringJSON);

        String textBlockJSON = """
      {
         "name" : "Mahesh",
         "RollNO" : "32"
      }
      """;
        System.out.println(textBlockJSON);
    }
}
