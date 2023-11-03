package com.openjdk11;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> weekDays = new ArrayList<>();

        weekDays.add("Sunday");
        weekDays.add("Monday");
        weekDays.add("Tuesday");
        weekDays.add("Wednesday");

        weekDays.add("Thursday");
        weekDays.add("Friday");
        weekDays.add("Saturday");

        weekDays.forEach(System.out::println);

    }

}
