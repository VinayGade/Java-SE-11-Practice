package streams;

import beans.Dish;
import beans.enums.Category;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Reducing {

    public static void main(String[] args) {

        DishesGenerator dishesGenerator= new DishesGenerator();

        List<Dish> allMenus = dishesGenerator.populateSpecialMenu();

        int menuCount = allMenus.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a+b);

        System.out.println("total count of special dishes ="+menuCount);

        int parallelCount = allMenus.parallelStream()
                .map(d -> 1)
                .reduce(0, Integer::sum);

        System.out.println("total parallel count of special dishes ="+menuCount);

        double totalStarterCost = allMenus.parallelStream()
                .filter(dish -> dish.getCategory() == Category.STARTER)
                .map(Dish::getPrice)
                .reduce(0.0d, Double::sum);

        System.out.println("\ntotal cost of Starter special dishes ="+totalStarterCost);

        // Veg Dish with highest calories
        Optional<Dish> highestCalorieVegMenu = allMenus.parallelStream()
                .filter(Dish::isVegOnly)
                .max(Comparator.comparingInt(Dish::getCalories));
        highestCalorieVegMenu.ifPresent(dish ->
                System.out.println("\nVeg Dish with highest calories =" + dish.toString()));

        // Non-Veg Dish with minimum calories
        Optional<Dish> highestCalorieNonVegMenu = allMenus.parallelStream()
                .filter(dish-> !dish.isVegOnly())
                .min(Comparator.comparingInt(Dish::getCalories));

        highestCalorieNonVegMenu.ifPresent(dish ->
                System.out.println("\nNon Veg Dish with highest calories =" + dish.toString()));

        int totalCaloriesStarter = allMenus.stream()
                .filter(menu -> menu.getCategory() == Category.STARTER)
                .collect(Collectors.summingInt(Dish::getCalories));

        int totalCaloriesEgg = allMenus.stream()
                .filter(menu -> menu.getCategory() == Category.EGG)
                .mapToInt(Dish::getCalories).sum();

        System.out.println("\nTotal calories in Starter Menu ="+totalCaloriesStarter);

        System.out.println("\nTotal calories in EGG Menu ="+totalCaloriesEgg);

        System.out.println("\nChicken Menu Summary :");

        IntSummaryStatistics chickenMenuStatistics = allMenus.parallelStream()
                .filter(menu -> menu.getCategory() == Category.CHICKEN)
                .collect(Collectors.summarizingInt(Dish::getCalories));

        System.out.println(chickenMenuStatistics);

    }
}
