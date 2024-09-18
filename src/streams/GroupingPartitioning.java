package streams;

import beans.Dish;
import beans.Instructor;
import beans.enums.Category;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class GroupingPartitioning {

    //SQL GROUP BY and HAVING

    public static void main(String[] args) {

        // Type 1 : groupingBy(classifier)

        List<String> programmingLanguages = List
                .of("Java", "Scala", "Python", "Go", "Ruby", "Perl", "C#", "C++", "C",
                        "SQL", "JavaScript", "TypeScript", "R", "Elixir", "Erlang", "Rust",
                        "OCaml", "Racket", "F#", "Lisp", "Cobol", "Haskell", "Closure", "Julia");


        Map<Integer, List<String>> programmingGroups =
                programmingLanguages.stream()
                        .collect(Collectors.groupingBy(String::length));

        System.out.println("\n Programming Languages group by length :");

        programmingGroups.forEach((length, languages) -> {
            System.out.println("length =" + length);
            System.out.println(" languages :" + languages);
        });

        System.out.println("\n  Group Instructors by Online");

        Map<Boolean, List<Instructor>> onlineInstructors = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::isOnlineCourses));

        onlineInstructors.forEach((isOnline, instructors) -> {
            System.out.println(isOnline ? "Online" : "Offline");
            instructors.forEach(System.out::println);
        });

        DishesGenerator dishesGenerator = new DishesGenerator();

        List<Dish> menuCard = dishesGenerator.populateSpecialMenu();

        System.out.println("\n  Veg dish per Category");

        Map<Category, List<Dish>> categorizedDishes = menuCard.stream()
                .filter(Dish::isVegOnly)
                .collect(Collectors.groupingBy(Dish::getCategory));

        categorizedDishes.forEach((category, dishes) -> {
            System.out.println("Category =" + category);
            dishes.forEach(System.out::println);
        });

        System.out.println("\nHigh Calorie and Low Calorie Non-Veg Menu :");
        Map<String, List<Dish>> nonVegMenu = menuCard.stream()
                .filter((dish -> !dish.isVegOnly()))
                .collect(Collectors.groupingBy(
                        dish -> dish.getCalories() <= 170 ? "Low Calorie Menu" : "High Calorie Menu"));

        nonVegMenu.forEach((calories, menu) -> {
            System.out.println(calories);
            menu.forEach(System.out::println);
        });

        // Type 2 : groupingBy(classifier, downstream)
        Map<Category, List<Dish>> vegMenu = menuCard.stream()
                .collect(Collectors.groupingBy(Dish::getCategory,
                        Collectors.filtering(Dish::isVegOnly, Collectors.toList())
                ));


        System.out.println("\nVeg Menu Group by category:");
        for (Map.Entry<Category, List<Dish>> vegMenuEntry : vegMenu.entrySet()) {
            Category category = vegMenuEntry.getKey();
            switch (category) {
                //case EGG, CHICKEN, FISH, MEAT:  // Java 14+
                case EGG:
                case CHICKEN:
                case FISH:
                case MEAT:
                    continue;
                default:
                    System.out.println(category.name());
                    vegMenuEntry.getValue().forEach(System.out::println);
            }
        }
        /*
        vegMenu.forEach((category, menu) -> {
            switch(category){
                case Category.EGG, Category.CHICKEN, Category.FISH, Category.MEAT:
                    continue;
                default:
                    System.out.println(category.name());
                    menu.forEach(System.out::println);
            }

        });

         */

        //grouping by length of string and also checking that the names contains e
        //and only return those name which has e in it
        List<String> name = List.of("Sid", "Mike", "Jenny", "Gene", "Rajeev");
        Map<Integer, List<String>> result = name.stream()
                .collect(Collectors.groupingBy(String::length, Collectors
                        .filtering(s -> s.contains("e"), Collectors.toList())));

        System.out.println("\nresult = " + result);
        System.out.println("\n------------------ Senior and Junior Instructors :");

        //instructor grouping them by Senior(>10) and Junior(<10) and filter them
        //on online courses
        Map<String, List<Instructor>> instructorByExpAndOnline = Instructors.getAll()
                .stream().collect(Collectors.groupingBy(instructor ->
                                instructor.getYearsOfExperience() > 10 ? "SENIOR" : "JUNIOR",
                        Collectors.filtering(Instructor::isOnlineCourses,
                                Collectors.toList())));

        instructorByExpAndOnline.forEach((key, value) -> {
            System.out.println("key  = " + key + " value = " + value);
        });

        // Type 3 : groupingBy(classifier, "map-factory", downstream)

        Map<Integer, List<String>> result2 = name.stream()
                .collect(Collectors.groupingBy(String::length,
                        LinkedHashMap::new,
                        Collectors.filtering(s -> s.contains("e"), Collectors.toList())));
        System.out.println("\nresult2 = " + result2);

        List<String> list = new ArrayList<>(Arrays.asList("Foo", "Bar", "Bar", "Bar", "Foo"));

        Map<String, Long> strings = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(Long.valueOf(2).equals(strings.get("Foo")));
        System.out.println(Long.valueOf(3).equals(strings.get("Bar")));

        System.out.println("\n  Maximum calorie dish per Category");

        Map<Category, Optional<Dish>> maxCalorieDishesPerCategory = menuCard.stream()
                .collect(Collectors.groupingBy(Dish::getCategory,
                        Collectors.maxBy(Comparator.comparingInt(
                                Dish::getCalories))));

        maxCalorieDishesPerCategory.forEach((category, dish) -> {
            System.out.println(category.toString());
            dish.ifPresent(System.out::println);
        });

        //collectingAndThen
        System.out.println("\n  Minimum calorie Non Veg dish per Category");

        Map<Category, Dish> minCalorieNonVegDishesPerCategory = menuCard.stream()
                .filter(dish -> !dish.isVegOnly())
                .collect(Collectors.groupingBy(Dish::getCategory,
                        LinkedHashMap::new,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingInt(
                                        Dish::getCalories)),
                                Optional::get)));

        minCalorieNonVegDishesPerCategory.forEach((category, dish) -> {
            System.out.println(category.toString());
            System.out.println(dish);
        });

        System.out.println("\n  Maximum calorie Veg dish per Category");

        Map<Category, Dish> maxCalorieVegDishesPerCategory = menuCard.stream()
                .filter(Dish::isVegOnly)
                .collect(Collectors.toMap(Dish::getCategory,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingInt(
                                Dish::getCalories))));

        maxCalorieVegDishesPerCategory.forEach((category, dish) -> {
            System.out.println(category.name());
            System.out.println(dish);
        });

        System.out.println("\n  Maximum calorie dish per Category");

        Map<Category, Dish> maxCalorieDishCategory = menuCard.stream()
                .collect(Collectors.toMap(Dish::getCategory,
                        Function.identity(),
                        BinaryOperator.maxBy(
                                Comparator.comparingInt(Dish::getCalories)
                        )
                ));

        maxCalorieDishCategory.forEach((category, dish) -> {
            System.out.println("\nCategory: "+category.name());
            System.out.println("Dish: "+dish.toString());
        });

        System.out.println("\n  Average calories of dishes per Category");

        Map<Category, Double> averageCalorieDishPerCategory = menuCard.stream()
                .collect(Collectors.groupingBy(Dish::getCategory,
                        Collectors.averagingInt(
                                Dish::getCalories)));

        averageCalorieDishPerCategory.forEach((category, avgCalories) -> {
            System.out.println(category.name());
            System.out.println(avgCalories);
        });

        System.out.println("\n  Summary of calories of dishes per Category");

        Map<Category, IntSummaryStatistics> summarizeCalorieDishPerCategory = menuCard.stream()
                .collect(Collectors.groupingBy(Dish::getCategory,
                        Collectors.summarizingInt(
                                Dish::getCalories)));

        summarizeCalorieDishPerCategory.forEach((category, avgCalories) -> {
            System.out.println(category.name());
            System.out.println(avgCalories);
        });

        System.out.println("\n  Summary of cost of dishes per Category");

        Map<Category, DoubleSummaryStatistics> summarizeCostDishPerCategory = menuCard.stream()
                .collect(Collectors.groupingBy(Dish::getCategory,
                        Collectors.summarizingDouble(
                                Dish::getPrice)));

        long chickenCount = summarizeCostDishPerCategory.get(Category.CHICKEN).getCount();

        System.out.println("Chicken Dish count = "+chickenCount);

        summarizeCostDishPerCategory.forEach((category, avgCalories) -> {
            System.out.println(category.name());
            System.out.println(avgCalories);
        });

        System.out.println("\n\n----------------------------Part 2 : Partitioning -------------------------------");

        System.out.println("\nPartition Veg and Non Veg Menus :");

        Map<Boolean, List<Dish>> partitionByType = menuCard.stream()
                .collect(Collectors.partitioningBy(Dish::isVegOnly));

        partitionByType.forEach((type, dishes) -> {
            System.out.println(type ? "Veg" : "Non-Veg");
            dishes.forEach(System.out::println);
        });

        System.out.println("\nPartition by Category :");

        Map<Boolean, Set<Dish>> partitionByCategory = menuCard.stream()
                .collect(Collectors.partitioningBy(dish ->
                                dish.getCategory().ordinal() < 3,
                        Collectors.toSet()));

        partitionByCategory.forEach((type, dishes) -> {
            System.out.println(type ? "Veg" : "Non-Veg");
            dishes.forEach(System.out::println);
        });

        System.out.println("\nPartition even/odd numbers from 1 to N :");

        Map<Boolean, List<Integer>> partitionEvens = IntStream.range(1, 100)
                .boxed() // Convert IntStream to Stream<Integer>
                .collect(Collectors.partitioningBy(x -> x%2==0, Collectors.toList()));

        partitionEvens.forEach((isEven, nums) -> {
            System.out.println(isEven ? "Even Numbers" : "Odd Numbers");
            nums.forEach(System.out::println);
        });

        System.out.println("\n\n----------------------------Part 3 : character count in String -------------------------------");

        String str = "java 8 functional interfaces and streams";

        String[] characters = str.split("");

        Map<String, List<String>> charMap = Arrays.stream(characters)
                .filter(s -> !s.equals(" "))
                .collect(Collectors.groupingBy(s -> s));

        Map<String, Long> charFrequencyMap = Arrays.stream(characters)
                .filter(s -> !s.equals(" "))
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));

        List<String> repeatingChars=
        charFrequencyMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(charMap);

        System.out.println("\nChar Frequency Map" + charFrequencyMap);

        System.out.println("\nrepeatingChars in str " + charFrequencyMap);

        System.out.println("\n\n----------------------------Duplicate elements in String -------------------------------");

        List<String> duplicates = Arrays.stream(characters)
                .filter(s -> !s.equals(" "))
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("\n Duplicate elements :" + duplicates);

        System.out.println("\n\n----------------------------Distinct characters in String -------------------------------");

        List<String> distinctChars = Arrays.stream(characters)
                .filter(s -> !s.equals(" "))
                .distinct()
                .collect(Collectors.groupingBy(s -> s))
                .values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        distinctChars.forEach(ch -> System.out.print(ch + " "));

    }
}