package com.java8.programs.interview.string;

public class StringToStringBuilder {
    public static void main(String[] args) {
        String[] strs = {"Scaler", "by", "InterviewBit!"};
        StringBuilder sb = new StringBuilder();
        sb.append(strs[0]);
        sb.append(" ").append(strs[1]);
        sb.append(" ").append(strs[2]);
        System.out.println(sb);
    }
}
