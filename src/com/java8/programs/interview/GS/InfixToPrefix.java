package com.java8.programs.interview.GS;

import java.util.Stack;
import java.util.stream.Collectors;

//Infix: (A+B)*(C-D)
//Prefix: *+AB-CD //Reverse the postfix: *+AB-CD
public class InfixToPrefix {
    // Function to reverse the expression  // Reverse the expression: )(D-C)*(B+A(
    private static String reverse(String expression) {
        return new StringBuilder(expression).reverse().toString();
    }

    // Function to switch parentheses //Change parentheses: (D-C)*(B+A)
    private static String switchParentheses(String expression) {
        return expression.chars()
                .mapToObj(c -> (char) c)
                .map(c -> c == '(' ? ')' : c == ')' ? '(' : c)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    // Function to convert infix to postfix //Convert to postfix: DC-BA+*
    private static String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    // Function to get precedence of operators
    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Function to convert infix to prefix   // Reverse the postfix: *+AB-CD
    public static String infixToPrefix(String expression) {
        String reversed = reverse(expression);
        String switched = switchParentheses(reversed);
        String postfix = infixToPostfix(switched);
        return reverse(postfix);
    }

    public static void main(String[] args) {
        String infixExpression = "(A+B)*(C-D)";
        String prefixExpression = infixToPrefix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Prefix Expression: " + prefixExpression);
    }
    }
