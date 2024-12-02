package basics;

import beans.Instructor;
import streams.Instructors;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class VarLambda {
    public static void main(String[] args) {

        var instructorList = Instructors.getAll();

        Predicate<Instructor> seniorPredicate = (var x) -> x.getYearsOfExperience()>6;

        instructorList.forEach(instructor -> {
            if(seniorPredicate.test(instructor)){
                var result = instructor.getName();
                System.out.println("senior : "+result);
            }
        });

        BiFunction<Integer, Integer, Integer> sum = Integer::sum;
        BiFunction<Integer, Integer, Integer> subtract = (Integer x, Integer y) -> x - y;
        BiFunction<Integer, Integer, Integer> multiply = (x, y) -> x * y;
        BiFunction<Integer, Integer, Integer> div = (var x, var y) -> x / y;
        // (int x, int y) -> x / y; // CF   ... incompatible parameter types , expected Integer fount int
        BiFunction<Integer, Integer, Integer> mod = (var x, var y) -> x % y;

        System.out.println("sum = "+sum.apply(10, 20));
        System.out.println("subtract ="+subtract.apply(101, 29));
        System.out.println("multiply = "+multiply.apply(5, 21));
        System.out.println("div= "+div.apply(10, 2));
        System.out.println("mod= "+mod.apply(99, 4));

    }
}
