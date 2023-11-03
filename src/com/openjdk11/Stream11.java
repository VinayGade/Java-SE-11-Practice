package com.openjdk11;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream11 {
    public static void main(String[] args) {
        var nums1 = Stream.of(1, 2, 3, 2, 1)
                .dropWhile(n -> n < 3)
                .collect(Collectors.toList());  // [3, 2, 1]

        var nums2 = Stream.of(1, 2, 3, 2, 1)
                .takeWhile(n -> n < 3)
                .collect(Collectors.toList());

        System.out.println("Nums1 : \n");
        nums1.forEach(System.out::println);

        System.out.println("Nums2 : \n");
        nums2.forEach(System.out::println);
    }
}
