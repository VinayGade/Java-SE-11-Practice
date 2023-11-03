package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import beans.enums.Category;
import beans.Dish;

import static java.util.stream.Collectors.toList;

public class CollectingStreams {

    public static void main(String[] args) {

        CollectingStreams collectingStreams = new CollectingStreams();

        List<Dish> menuCard = collectingStreams.populateDishes();

        long howManyDishes = menuCard.stream().collect(Collectors.counting());
        long howManyDishes2 = menuCard.stream().count();

        //simple way
        long howManyDishes3 = menuCard.size();

        //simple efficient best way
        long dishCount = menuCard.parallelStream().count();

        //fastest way to collect
        long parallelDishCount = menuCard.parallelStream().count();

        System.out.println("\nMenucard dishes count ="+howManyDishes);

        System.out.println("\nMenucard dishes count with stream.count() ="+dishCount);

        System.out.println("\nMenucard dishes count with parallel Stream ="+parallelDishCount);


        // Min and Max Dishes

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

        Comparator<Dish> dishCostComparator = Comparator.comparingDouble(Dish::getPrice);

        Optional<Dish> maxCaloriesDish = menuCard.stream()
                .collect(Collectors.maxBy(dishCaloriesComparator));

        Optional<Dish> minCostDish = menuCard.parallelStream()
                .collect(Collectors.minBy(dishCostComparator));

        System.out.println("\n Maximum calories Dish on Menu Card ="+maxCaloriesDish.get().toString());

        System.out.println("\n Cheapest Dish on Menu Card ="+minCostDish.get().toString());

        System.out.println("\nSummerization");

        int totalCalories = menuCard.stream()
                .collect(Collectors.summingInt(Dish::getCalories));

        double averageCalories = menuCard.stream()
                .collect(Collectors.averagingInt(Dish::getCalories));

        System.out.println("\n Total Calories on Menu Card ="+totalCalories);

        System.out.println("\n Average Calories on Menu Card ="+averageCalories);

        System.out.println("\n Summerizing Calories on Menu Card :{count, sum, min, average, max}");
        IntSummaryStatistics menuStatistics = menuCard.stream()
                .collect(Collectors.summarizingInt(Dish::getCalories));

        System.out.println(menuStatistics);

        System.out.println("\nDisplay summerized properties of Dish calories :");

        System.out.println("average ="+menuStatistics.getAverage());
        System.out.println("min ="+menuStatistics.getMin());
        System.out.println("max ="+menuStatistics.getMax());
        System.out.println("sum ="+menuStatistics.getSum());
        System.out.println("count ="+menuStatistics.getCount());

        System.out.println("\n Joining Fruit Dishes Strings");

        String fruitMenuNames = menuCard.stream()
                .filter(menu -> menu.getCategory() == Category.FRUIT)
                .map(Dish::getName)
                .collect(Collectors.joining(",\n"));

        System.out.println("\nMenu Names ="+fruitMenuNames);

        System.out.println("\nGeneralized summarization with reduction :");

        int totalCaloriesReduce = menuCard.stream()
                .collect(Collectors
                        .reducing(0, Dish::getCalories, (i, j) -> i + j));

        Optional<Dish> mostCalorieDish = menuCard.stream()
                .collect(Collectors.reducing(
                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

        System.out.println("\ntotalCaloriesReduce ="+totalCaloriesReduce);

        System.out.println("\nmostCalorieDish Reduce ="+mostCalorieDish.get().toString());

        int totalCaloriesCollect = menuCard.stream()
                .collect(Collectors.reducing(0,
                        Dish::getCalories,
                        Integer::sum));

        int totalCaloriesMap = menuCard.stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum)
                .get();

        int totalCaloriesSum = menuCard.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        System.out.println("\ntotal Calories with Stream Reduce ="+totalCaloriesCollect);

        System.out.println("\ntotal Calories with map, Reduce ="+totalCaloriesMap);

        System.out.println("\ntotal Calories with sum ="+totalCaloriesSum);

        collectingStreams.grouping(menuCard);

        int totalFishCalories = menuCard
                .parallelStream()
                .filter(dish->dish.getCategory() == Category.FISH)
                .collect(Collectors.summingInt(Dish::getCalories));

        System.out.println("total calories in Fish dishes ="+totalFishCalories);

    }

    public void grouping(List<Dish> dishes) {

        Map<Category, List<Dish>> menuCardByType =
                dishes.stream()
                        .collect(Collectors.groupingBy(Dish::getCategory));

        displayDishCategory(menuCardByType);

        System.out.println("\nHigh Calorie Dishes :");

        Map<Category, List<Dish>> highCalorieMenus =
                dishes.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .collect(Collectors.groupingBy(Dish::getCategory));

        displayDishCategory(highCalorieMenus);

        Map<Category, List<Dish>> lowCaloriesDiet =
                dishes.stream()
                        .collect(Collectors.groupingBy(Dish::getCategory,
                                Collectors.filtering(dish -> dish.getCalories() <= 300, toList())));

        displayDishCategory(lowCaloriesDiet);

        // Veg Dish with minimum calories
        Optional<Dish> highestCalorieVegMenu = dishes.parallelStream()
                .filter(Dish::isVegOnly)
                .collect(Collectors.minBy(
                 Comparator.comparingInt(Dish::getCalories
                )));

        highestCalorieVegMenu.ifPresent(dish -> System.out.println(dish.toString()));

        // Non-Veg Dish with highest calories

        Optional<Dish> highestCalorieNonVegMenu = dishes.parallelStream()
                .filter(dish -> !dish.isVegOnly())
                .collect(Collectors.maxBy(
                        Comparator.comparingInt(Dish::getCalories)));

        highestCalorieNonVegMenu.ifPresent(dish -> System.out.println(dish.toString()));
    }

    public void displayDishCategory(Map<Category, List<Dish>> menuCardByType) {
        System.out.println("\nPopulate Dish as per Category:");
        menuCardByType.forEach((key, value) -> {
            System.out.println("\nCategory =" + key.name());
            System.out.println("Dishes :");
            value.forEach(dish -> System.out.println(dish.toString()));
        });
    }

    public List<Dish> populateDishes(){
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish(101, "Roasted Mutton salad", 500 , 210.0, Category.MEAT, false));
        dishes.add(new Dish(271, "Boiled chicken Breast salad", 350 , 190.0, Category.CHICKEN, false));
        dishes.add(new Dish(908, "Mixed Vegetables salad with Mozerella Cheese", 250 , 170.0, Category.VEG, true));
        dishes.add(new Dish(315, "Fried Egg Sandwich with Almond Butter", 300 , 150.0, Category.EGG, false));

        dishes.add(new Dish(917, "French Fries with Coke", 150 , 50.0, Category.STARTER, true));
        dishes.add(new Dish(378, "Spaghetti Bolognese", 240 , 250.0, Category.EGG, false));
        dishes.add(new Dish(375, "Egg Fried Rice", 250 , 200.0, Category.EGG, false));
        dishes.add(new Dish(901, "Season Fruit Salad", 140 , 120.0, Category.FRUIT, true));

        dishes.add(new Dish(508, "Prawns Biryani", 250 , 240.0, Category.FISH, false));
        dishes.add(new Dish(518, "Roasted Shrimp Salad with Mixed Vegetables", 360 , 270.0, Category.FISH, false));
        dishes.add(new Dish(574, "Stuffed Salmon with Soy Sauce", 310 , 240.0, Category.FISH, false));
        dishes.add(new Dish(581, "Stuffed BombayDuck with Red Chilli Sauce and Peanut Butter", 350 , 340.0, Category.FISH, false));
        dishes.add(new Dish(593, "Stuffed Basa with Fried Egg", 360 , 280.0, Category.FISH, false));

        return dishes;
    }

    //pork, chicken, french fries, rice, season fruit, pizza, prawns, salmon

}

