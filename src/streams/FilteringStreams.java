package streams;

import beans.enums.Category;
import beans.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;

public class FilteringStreams {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays
                .asList(2, 4, 8, 10, 20, 11, 12, 33, 34, 20, 50, 78, 20, 34, 34, 50, 8, 2);

        System.out.println("A. Numeric streams");
        // find Unique even numbers

        // using distinct()
        System.out.println("1. Unique even numbers using distinct()");
        numbers.stream()
                .filter(n -> n%2 == 0)
                .distinct()
                .forEach(i -> System.out.print(" "+i));

        // using Collectors.toSet()
        System.out.println("\n2. Unique even numbers using Collectors.toSet()");
        numbers.stream()
                .filter(n -> n%2 == 0)
                .collect(Collectors.toSet())
                .forEach(i -> System.out.print(" "+i));

        Long count = numbers.stream()
                .filter(n -> n%2 == 0)
                .distinct()
                .count();

        System.out.println("\n3. Count of unique even numbers ="+count);

        System.out.println("\n4. Unique even numbers in sorted way:");
        numbers.stream()
                .filter(n -> n%2 == 0)
                .distinct()
                .sorted()
                .forEach(x -> System.out.print(" "+x));

        System.out.println("\n ------------------------------------------------------------------------------");

        List<Dish> specialMenu = Arrays.asList(
                new Dish(501,"Chicken Lollipop Dry", 198, 180, Category.CHICKEN,false),
                new Dish(507,"Tandoori Chicken", 201, 380, Category.CHICKEN,false),

                new Dish(805,"Mutton Paya Soup", 170, 280, Category.MEAT,false),
                new Dish(826,"Mutton Fry", 240, 362, Category.MEAT,false),

                new Dish(245,"Veg Handi", 78, 165, Category.VEG, true),
                new Dish(243,"Veg Hyderabadi", 71, 195, Category.VEG, true),

                new Dish(728,"Surmai Masala Fry", 175, 350, Category.FISH,false),
                new Dish(735,"Surmai Gaon Curry", 155, 400, Category.FISH,false),

                new Dish(301,"French Fries", 90, 530, Category.STARTER ,true),
                new Dish(318,"Masala Dosa", 70, 160, Category.STARTER,true),

                new Dish(101,"seasonal fruit salad", 42, 120.0, Category.FRUIT,true),

                new Dish(521,"Butter Chicken", 195, 470, Category.CHICKEN,false),

                new Dish(108,"Mango Milk Shake", 55, 135.0, Category.FRUIT,true),

                new Dish(605,"Fried Egg", 128, 90, Category.EGG,false),

                new Dish(705,"Stuffed Prawns ", 180, 300, Category.FISH,false),
                new Dish(702,"Prawns Biryani", 172, 340, Category.FISH,false),

                new Dish(725,"Bombil Fry", 165, 245, Category.FISH,false),

                new Dish(201,"Steam Rice", 45, 81, Category.VEG, true),
                new Dish(207,"Jeera Fried Rice", 45, 87, Category.VEG, true),

                new Dish(255,"Paneer Tikka Masala", 98, 185, Category.VEG, true),

                new Dish(709,"Prawns Khichadi", 195, 385, Category.FISH,false),
                new Dish(721,"Pomfret Rawa Fry", 175, 357, Category.FISH,false),

                new Dish(107,"Watermelon Juice", 35, 70.0, Category.FRUIT,true),
                new Dish(110,"Chikoo Milk Shake", 59, 95.0, Category.FRUIT,true),

                new Dish(609,"Egg Fried Rice", 168, 180, Category.EGG,false),
                new Dish(604,"Egg Bhurji", 184, 165, Category.EGG,false),

                new Dish(211,"Dal Khichadi", 85, 125, Category.VEG, true),
                new Dish(223,"Veg Biryani", 75, 145, Category.VEG, true),

                new Dish(523,"Chicken Tikka Masala", 195, 480, Category.CHICKEN,false),
                new Dish(517,"Chicken Salad", 155, 400, Category.CHICKEN,false),

                new Dish(323,"Veg Spring Roll", 75, 210, Category.STARTER,true),
                new Dish(328,"Paneer Crispy", 80, 220, Category.STARTER,true),

                new Dish(531,"Chicken Biryani", 175, 410, Category.CHICKEN,false),
                new Dish(529,"Chicken Kheema", 210, 450, Category.CHICKEN,false),

                new Dish(329,"Veg Crispy", 72, 205, Category.STARTER,true),

                new Dish(821,"Mutton Masala", 190, 385, Category.MEAT,false),
                new Dish(815,"Mutton Biryani", 210, 372, Category.MEAT,false),

                new Dish(738,"Fish Curry", 145, 350, Category.FISH,false),
                new Dish(731,"Fish Masala", 172, 365, Category.FISH,false)
        );

        // enlist all non-veg items

       Set<Dish> slicedMenu1 = specialMenu.stream()
               .filter(dish -> dish.getCalories() > 100)
               .collect(Collectors.toSet());

       // enlist all veg items

        List<Dish> vegDishes = specialMenu.stream()
                .filter(Dish::isVegOnly)
                .collect(Collectors.toList());

        System.out.println("B. Special Dishes : stream of Dish objects");

        System.out.println("\nB1. Display all veg dishes:");

        vegDishes.forEach(dish -> System.out.println(" "+dish.toString()));

        List<Dish> starters = specialMenu.stream()
                .filter(dish -> dish.getCategory() == Category.STARTER)
                .collect(Collectors.toList());

        System.out.println("\nDisplay Starter menus :");

        starters.forEach(dish -> System.out.println(" "+dish.toString()));

        long starterCount = specialMenu.stream()
                .filter(dish -> dish.getCategory().ordinal() == 6)
                .count();

        System.out.println("\nB2. Total number of starters =" +starterCount);

        System.out.println("\nB3. Display all Fish menus sorted by cost:");

        List<Dish> fishMenus = specialMenu.stream()
                .filter(dish -> dish.getCategory().name().equals("FISH"))
                .sorted(Comparator.comparingDouble(Dish :: getPrice))
                .collect(Collectors.toList());

        fishMenus.forEach(dish -> System.out.println(" "+dish.toString()));

        System.out.println("\nB4. Display High calorie Chicken Dishes:");

        List<Dish> highCalorieChickenDishes = specialMenu.stream()
                .filter(dish -> dish.getCategory().name().equals("CHICKEN"))
                .sorted(Comparator.comparingInt(Dish :: getCalories).reversed())
                .limit(4)
                .collect(Collectors.toList());

        highCalorieChickenDishes.forEach(dish -> System.out.println(" "+dish.toString()));

        System.out.println("\nB5. Display Mutton Dishes sorted by cost:");

        List<Dish> muttonDishes = specialMenu.stream()
                .filter(dish -> dish.getCategory().name().equals("MEAT"))
                .sorted(Comparator.comparingDouble(Dish :: getPrice))
                .collect(Collectors.toList());

        muttonDishes.forEach(dish -> System.out.println(" "+dish.toString()));

       // set of veg items
       Set<Dish> slicedMenu2 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 100)
                .collect(Collectors.toSet());

        // enlist veg dishes filtered by category sorted by calorie count
        List<Dish> vegMenus = specialMenu.stream()
                .filter(v -> v.getCategory().name().equalsIgnoreCase("VEG"))
                .sorted(Comparator.comparingInt(Dish::getCalories).reversed())
                .collect(Collectors.toList());

        List<Dish> vegMenuLowCalorieDiet = specialMenu.stream()
                .filter(Dish::isVegOnly)
                .sorted(Comparator.comparingInt(Dish::getCalories))
                .collect(Collectors.filtering(dish -> dish.getCalories() < 70, toList()));

        List<Dish> vegMenuHighCalorieDiet = specialMenu.stream()
                .filter(Dish::isVegOnly)
                .sorted(Comparator.comparingInt(Dish::getCalories).reversed())
                .limit(5)
                .collect(Collectors.filtering(not(dish -> dish.getCalories() <80), toList()));

       //takewhile - stop once you found a dish that is <= 100 calories

       System.out.println("\nB6. All non-veg dishes :");
       slicedMenu1.forEach(dish -> System.out.println(dish.toString()));

       System.out.println("\nB7. All veg dishes :");
       slicedMenu2.forEach(dish -> System.out.println(dish.toString()));

        System.out.println("\nB8. All veg dishes by category sorted by calorie count:");
        vegMenus.forEach(dish -> System.out.println(dish.toString()));

        System.out.println("\nB8A. All veg dishes : vegMenuLowCalorieDiet");
        vegMenuLowCalorieDiet.forEach(dish -> System.out.println(dish.toString()));

        System.out.println("\nB8B. Top 5 veg dishes : vegMenuHighCalorieDiet");
        vegMenuHighCalorieDiet.forEach(dish -> System.out.println(dish.toString()));

        System.out.println("\nB9. Display Top 10 high calorie non-veg dishes");

        List<Dish> highCalorieNonVegDishes = specialMenu.stream()
                .filter(dish -> !dish.isVegOnly())
                .sorted(Comparator.comparingInt(Dish::getCalories)
                        .reversed()
                        .thenComparing(Dish::getPrice))
                .limit(10)
                .collect(Collectors.toList());

        highCalorieNonVegDishes.forEach(dish -> System.out.println(" "+dish));


       /*
      `How about getting the other elements though?
       How about finding the elements that have greater than 100 calories?
       You can use the dropWhile operation for this
       * */

        /*
        The dropWhile operation is the complement of takeWhile. It throws away the elements at the start
        where the predicate is false.
        Once the predicate evaluates to true it stops and returns all the remaining elements, and
        it even works if there are an infinite number of remaining elements!
        * */
        System.out.println("\nB10. All dishes dropwhile :");
        specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 100)
                .forEach(dish -> System.out.println(dish.toString()));

        // limit first 2 veg and first 2 non-veg dishes

        System.out.println("\nB11. Top 2 veg and non-veg dishes :");

        List<Dish> specialVegMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 100)
                .limit(2)
                .collect(Collectors.toList());

        List<Dish> specialNonVegMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 100)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println("\nB12. Top 2 veg dishes :");
        specialVegMenu.forEach(dish->System.out.println(dish.toString()));

        System.out.println("\nB13. Top 2 non-veg dishes :");
        specialNonVegMenu.forEach(dish->System.out.println(dish.toString()));

        System.out.println("\nB14. Skip top Menus : ");
        specialMenu.stream()
                .skip(2)
                .forEach(menu -> System.out.println(menu.toString()));

        List<Dish> meatDishes =
                specialMenu.stream()
                        .filter(dish -> dish.getCategory() == Category.MEAT)
                        .limit(2)
                        .collect(toList());

        System.out.println("\nB15.Top 2 Meat Dishes :");

        meatDishes.forEach(meat->System.out.println(meat.toString()));

        System.out.println("\nB16. All High calorie dishes grouped by category");

        Map<Category, List<Dish>> menuCardByType =
                specialMenu.stream()
                        .filter(dish-> dish.getCalories() >95)
                        .collect(Collectors.groupingBy(Dish::getCategory,
                                Collectors.filtering(dish -> dish.getPrice() < 350.0d, toList())));

        System.out.println("\nB17. Populate Dish as per Category:");
        menuCardByType.forEach((category, dishes) -> {
            System.out.println("\nCategory =" + category.name());
            System.out.println("Dishes :");
            dishes.forEach(dish -> System.out.println(dish.toString()));
        });

        System.out.println("\nB18. Populate low cost Non-veg Dishes :");

        specialMenu.stream()
                .filter(dish -> !dish.isVegOnly() && dish.getPrice()<350)
                .sorted(Comparator.comparingDouble(Dish::getPrice))
                .limit(8)
                        .forEach(dish->System.out.println(" "+dish));

        System.out.println("\nB19. Group by veg and non-veg");

        Map<Boolean, List<Dish>>  groupedDishes = specialMenu.stream()
                .collect(Collectors.groupingBy(Dish::isVegOnly,
                        Collectors.filtering(dish -> dish.getPrice() < 350.0d, toList())));

        groupedDishes.forEach((vegOnly, dishes)->{
            System.out.println(vegOnly ? "Veg Dishes" : "Non Veg Dishes");
            dishes.forEach(dish -> System.out.println(" "+dish));
        });

        System.out.println("\n ------------------------------------------------------------------------------");
        System.out.println("\nC. Stream factory methods Stream.of(), iterate(), generate()");

        // use Stream.of() to create a Stream of similar type of data.

        Stream<Integer> numberStream = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).stream(); // list to stream

        Stream<Integer> streamOfNums = Stream.of(1, 2, 3, 4, 5, 6, 7, 8); // smiple and best

        Stream<Integer> streamOfNumArray = Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}); // array to stream

        numberStream.forEach(n -> System.out.print(n+" " ));

        System.out.println("\nC1. Iterating stream of integers");
        streamOfNums.forEach(System.out::print);

        System.out.println("\nC2. Iterating stream of integer array");
        streamOfNumArray.forEach(System.out::print);

        // Stream<Integer> evens = Stream.iterate(0, i->i+2);  //generates infinite even numbers
        Stream<Integer> evens = Stream.iterate(0, i->i+2).limit(10);

        Stream<Integer> odds = Stream.iterate(0, i->i+1).filter(not(i -> i%2==0)).limit(10);

        System.out.println("\nC3A. First 10 even numbers");
        evens.forEach(n->System.out.print(n+" "));

        System.out.println("\nC3B. First 10 odd numbers");
        odds.forEach(n->System.out.print(n+" "));

        System.out.println("\nC4. Generate 10 random numbers : ");

        Stream<Integer> randoms = Stream.generate(new Random()::nextInt).limit(10);
        randoms.forEach(random -> System.out.print(random+" "));

        // ways to represent numeric streams

        Stream<Integer> integers = Stream.of(100, 150, 180, 240, 360, 500);
        Stream<? extends Number> numbersL = Stream.of(1000L, 100000L, 4000000000L, 100);

    }
}
