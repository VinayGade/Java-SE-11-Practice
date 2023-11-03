package com.openjdk11;

import java.util.Arrays;
import java.util.List;

public class Collection2Arr {
    public static void main(String[] args) {
        List sampleList = Arrays.asList("Java", "Kotlin");
        String[] sampleArray = (String[])sampleList.toArray(String[]::new);

        for(String s : sampleArray)
            System.out.println(s);
    }
}
