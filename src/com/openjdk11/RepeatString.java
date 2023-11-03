package com.openjdk11;

public class RepeatString {

    public static void main(String[] args) {

        String str = "Welcome to Java 11";
        var count = 5;
        System.out.println("Repeat Str "+count+" times :");
        System.out.println(str.repeat(count));
    }
}
