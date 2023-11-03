package lambda;

import beans.Dish;
import streams.DishesGenerator;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Predicates {
    public static void main(String[] args) {
        DishesGenerator dishesGenerator= new DishesGenerator();

        List<Dish> allMenus = dishesGenerator.populateSpecialMenu();

        printVegMenu(allMenus, Dish::isVegOnly);

        int n=100, x=5;
        BiPredicate<Integer, Integer> isFactor = (u, v) -> u%v==0;
        factor(n, x, isFactor);

        String src = "geeksforgeeks";
        String key = "geek";
        BiPredicate<String, String> isSubString = (a, b) -> a.contains(b);

        substr(src, key, isSubString);
    }

    // Predicate Dish::isVegOnly
    private static void printVegMenu(List<Dish> menuCard, Predicate<Dish> vegChecker) {
        for (Dish dish : menuCard) {
            if (vegChecker.test(dish))
                System.out.println(dish + " ");
        }
        System.out.println();
    }

    // BiPredicate Dish::isVegOnly
    private static void factor(int number, int x, BiPredicate<Integer, Integer> isFactor){
        if(isFactor.test(number, x))
           System.out.println(x +" is factor of "+number);
        else
            System.out.println(x +" is not factor of "+number);
    }

    private static void substr(String source, String str, BiPredicate<String, String> substring){
        if(substring.test(source, str))
            System.out.println(source + " is substring of "+str);
        else
            System.out.println(source + " is not substring of "+str);
    }
}