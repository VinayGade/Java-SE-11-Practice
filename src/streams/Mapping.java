package streams;

import beans.*;
import beans.enums.Category;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mapping {

    public void displayDishCategory(Map< Category, List< Dish >> menuCardByType) {
        System.out.println("\nPopulate Dish as per Category:");
        menuCardByType.forEach((key, value) -> {
            System.out.println("\nCategory =" + key.name());
            System.out.println("Dishes :");
            value.forEach(dish -> System.out.println(dish.toString()));
        });
    }

    public static int getPopulation(List<Country> countries, String continent){

        //Way 1 : Prior to Java 8
        /*
        int sum = 0;
        for(Country c: countries){
            if(c.getContinent().equals(continent))
                sum+=c.getPopulation();
        }
        return sum;
        */

        //Way 2 : using map and reduce
        /*
        Stream<Country> countriesInContinent = countries.stream()
                .filter(country -> {
                   return country.getContinent().equals(continent);
                });

        Stream<Integer> populations = countriesInContinent.map(
                Country::getPopulation
        );

        int population = populations.reduce(0, Integer::sum);
        return population;
         */

        //Way 3: Optimized way
        Stream<Integer> populationsContinent = countries.stream()
                .map(c -> c.getContinent().equals(continent) ? c.getPopulation() : 0);

        return populationsContinent.reduce(0, Integer::sum);
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60, 80, 100);
        List<Integer> squares = numbers.stream()
                .map(n -> n*n)
                .collect(Collectors.toList());

        System.out.println("\nnumbers:");
        numbers.forEach(n -> System.out.print(" " + n));

        System.out.println("\nSquare of numbers:");
        squares.forEach(s -> System.out.print(" " + s));

        System.out.println("\n***** Countries Population (in millions) based on continent *****");

        List<Country> countries = populateCountryList();

        int asia = getPopulation(countries, "Asia");
        int america = getPopulation(countries, "America");
        int europe = getPopulation(countries, "Europe");

        System.out.println("Asia : "+asia);
        System.out.println("America : "+america);
        System.out.println("Europe : "+europe);

        System.out.println("\n************** Special Dishes ******************");

        System.out.println("\nFish menu names:");

        Mapping mapping = new Mapping();
        //mapping.displayDishCategory();
        DishesGenerator dishesGenerator= new DishesGenerator();

        List<Dish> allMenus = dishesGenerator.populateDishes();
        List<Dish> specialMenus = dishesGenerator.populateSpecialMenu();

        List<String> fishMenu = allMenus.stream()
                .filter(menu -> menu.getCategory() == Category.FISH)
                .map(Dish::getName)
                .collect(Collectors.toList());

        fishMenu.forEach(System.out::println);

        System.out.println("\nFish menu ordered by price from special dishes:");

        List<DishCost> fishMenus = mapping.dishCostByCategory(specialMenus, Category.FISH);

        fishMenus.forEach(dishCost -> System.out.println(dishCost.toString()));

        System.out.println("\nChicken menu ordered by price from special dishes:");

        List<String> chickenMenus = mapping.dishByCategory(specialMenus, Category.CHICKEN);

        chickenMenus.forEach(System.out::println);

        System.out.println("\nVeg menu ordered by calories from special dishes:");

        List<Dish> vegDiet = specialMenus.stream()
                .filter(Dish::isVegOnly)
                .sorted(Comparator.comparingInt(Dish::getCalories).reversed())
                .limit(5)
                .collect(Collectors.toList());

        vegDiet.forEach(dish -> System.out.println(dish.toString()));

        System.out.println("\nfind any Veg menu with calories > 100 from special dishes:");

        specialMenus.stream()
                .filter(dish -> dish.isVegOnly() && dish.getCalories()>100)
                .findAny()
                .ifPresent(dish -> System.out.println(dish.getName()));

        System.out.println("\nfind starter Veg menu with highest calories from special dishes:");

        specialMenus.stream()
                .filter(dish -> dish.getCategory() == Category.STARTER)
                .sorted(Comparator.comparingInt(Dish::getCalories).reversed())
                .findFirst()
                .ifPresent(starter -> System.out.println(starter.toString()));

        System.out.println("\nfind Chicken menu in Non-Veg category with highest calories from special dishes:");

        specialMenus.stream()
                .filter(dish -> dish.getCategory() == Category.CHICKEN)
                .max(Comparator.comparingInt(Dish::getCalories))
                .ifPresent(starter -> System.out.println(starter.toString()));

        System.out.println("\nfind Egg menu with lowest price:");

        specialMenus.stream()
                .filter(dish -> dish.getCategory() == Category.EGG)
                .min(Comparator.comparingInt(Dish::getCalories))
                .ifPresent(starter -> System.out.println(starter.toString()));

        System.out.println("\nfind Chicken menu with lowest price:");

        specialMenus.stream()
                .filter(dish -> dish.getCategory() == Category.CHICKEN)
                .sorted(Comparator.comparingDouble(Dish::getPrice))
                .findFirst()
                .ifPresent(chickenMenu -> System.out.println(chickenMenu.toString()));

        boolean isHealthy = specialMenus.stream()
                .allMatch(dish -> dish.getCalories() < 350);

        System.out.println("\nIs there any healthy food in special diet:"+isHealthy);

        int totalFruitCalories = allMenus
                .parallelStream()
                .filter(dish -> dish.getCategory() == Category.FRUIT)
                .mapToInt(Dish::getCalories).sum();

        System.out.println("\ntotal calories in Fruit dishes ="+totalFruitCalories);

        // flatmap = map + flatten

        System.out.println("\nEnlist distinct courses provided by instructor (Set/ List):");  // List/ Set

        List<String> courses = Instructors.getAll()
                .stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        courses.forEach(System.out::println);

        List<Integer> numbers1 = Arrays.asList(10, 12, 15, 20, 35, 30, 40);

        List<Integer> numbers2 = Arrays.asList(50, 52, 51, 70, 85, 80, 90);

        List<Integer> numbers3 = Arrays.asList(100, 120, 150, 200, 75, 400);

        List<Integer> multipleOf10 = Stream.of(numbers1, numbers2, numbers3)
                .flatMap(Collection::stream)
                .filter(n-> n%10 == 0)
                .collect(Collectors.toList());

        System.out.println("\nMultiple of 10");
        multipleOf10.forEach(n->System.out.print(" "+n));

        System.out.println("\nflatMap Employees based on Department");

        Employee employee1 = new Employee("Vinay", 30, "M");
        Employee employee2 = new Employee("Ganesh", 31, "M");
        Employee employee3 = new Employee("Smita", 38, "F");
        Employee employee4 = new Employee("Shruti", 40, "F");

        Employee employee5 = new Employee("Sayli", 29, "F");
        Employee employee6 = new Employee("Mahesh", 33, "M");
        Employee employee7 = new Employee("Raj", 36, "M");
        Employee employee8 = new Employee("Deepa", 27, "F");

        Department dev = new Department("Development");
        Department qa = new Department("QA");
        Department mgmt = new Department("Management");
        Department hr = new Department("HR");

        dev.addEmployees(employee1);
        dev.addEmployees(employee8);

        qa.addEmployees(employee2);
        qa.addEmployees(employee7);

        mgmt.addEmployees(employee6);
        mgmt.addEmployees(employee3);

        hr.addEmployees(employee4);
        hr.addEmployees(employee5);

        List<Department> departments = List.of(dev, hr, qa, mgmt);

        departments.stream()
                .flatMap( department -> department.getEmployees().stream())
                .forEach(System.out::println);

        // separate male and  females from employees
        Map<String, List<Employee>> groupByGender = departments
                .stream()
                .flatMap( department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getGender));

        System.out.println("\nEmployees group by gender:\n");
        groupByGender.forEach((k, v) -> {
            System.out.println("Gender: "+k);
            v.forEach(System.out::println);
        });

        System.out.println("\nYoungest Employee from all departments:\n");
        departments.stream()
                .flatMap( department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);
    }

    public List<String> dishByCategory(List<Dish> dishes, Category category){
        return dishes.stream()
                .filter(menu -> menu.getCategory() == category)
                .sorted(Comparator.comparingDouble(Dish::getPrice))
                .map(menu -> menu.getName() + " " +menu.getPrice())
                .collect(Collectors.toList());
    }

    public List<DishCost> dishCostByCategory(List<Dish> dishes, Category category){
        return dishes.stream()
                .filter(menu -> menu.getCategory() == category)
                .map(menu ->
                        new DishCost(menu.getName(), menu.getPrice()))
                .sorted(Comparator.comparingDouble(DishCost::getCost))
                .collect(Collectors.toList());
    }

    public static List<Country> populateCountryList(){
        return List.of(new Country("India", "Asia", 434),
                new Country("China", "Asia", 642),
                new Country("Japan", "Asia", 92),
                new Country("Indonesia", "Asia", 83),
                new Country("Russia", "Europe", 116),
                new Country("Germany", "Europe", 72),
                new Country("Italy", "Europe", 49),
                new Country("France", "Europe", 44),
                new Country("UK", "Europe", 51),
                new Country("USA", "America", 181),
                new Country("Brazil", "America", 68)
                );
    }

    private static class DishCost{ //inner class ... Mapping.DishCost

        String name;
        double cost;

        public DishCost(String name, double cost) {
            this.name = name;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "DishCost{" +
                    "name='" + name + '\'' +
                    ", cost=" + cost +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

    }
}
