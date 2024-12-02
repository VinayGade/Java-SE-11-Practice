package basics;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Var {

    public static void main(String[] args) {

        //Java10 - var : Type inference
        var userChannels = new HashMap<String, List<String>>();

        var list1 = new ArrayList<String>();

        list1.add("HBO");
        list1.add("HotStar");
        list1.add("Amazon Prime Video");
        list1.add("Netflix");
        list1.add("zee5");

        var user1 = "Vinay";
        var user2 = "Amit";

        var list2 = new ArrayList<String>();

        list2.add("Spotify");
        list2.add("Gaana");
        list2.add("Discover+");
        list2.add("Voot");
        list2.add("SonySix");

        userChannels.put(user1,list1);
        userChannels.put(user2, list2);

        for(Map.Entry<String,List<String>> entry : userChannels.entrySet()){
            var values = entry.getValue();
            System.out.println("For user "+entry.getKey()+ ", Channel Subscriptions :\n");
            values.forEach(System.out::println);
            System.out.println("\n");
        }

        var today = LocalDateTime.now();

        System.out.println("Today = "+today.getDayOfMonth()+"-"+today.getMonth()+"-"+today.getYear());

        int[] nums = {10, 30, 20, 40, 50, 90, 100};
        var numbers = new int[] {1, 2, 3, 4, 5};

        System.out.println(nums[5]);
        System.out.println(numbers[2]);

        List<String> technologies = List.of("Java","Scala", "Python", "TypeScript", "Golang", "Ruby");

        System.out.println("\n");
        technologies.forEach(t -> System.out.print(" "+t));

        var list3 = new ArrayList<>();
        list3.add(3.1416f);
        list3.add("Monday");
        list3.add("JavaScript");
        list3.add(100);

        System.out.println("\n");
        list3.forEach(x -> System.out.print(" "+x));

        var bookAuthors = new HashMap<String, List<String>>();

        bookAuthors.put("Head First Java", List.of("Kathy Sierra", "Bert Bates"));

        bookAuthors.put("Head First Design Patterns", List.of("Eric Freeman", "Elisabeth Robson"));

        bookAuthors.put("OCP Java SE 17 Study Guide", List.of("Scott Selikoff", "JEANNE BOYARSKY"));

        bookAuthors.put("Modern Java in Action", List.of("Raoul-Gabriel Urma", "Mario Fusco", "Alan Mycroft"));

        bookAuthors.put("Java The Complete Reference 12th Edition", List.of("Herbert Schildt"));

        bookAuthors.put("Data Structures and Algorithms in Java ", List.of("Roberto Tamassia", "Michael Goodirch", "Michael Goldwasser"));

        bookAuthors.forEach((k,v) ->{
            System.out.println("book : "+k);
            System.out.println("Author(s) :");
            v.forEach(System.out::println);
        });

        int multiply = 10 * 20;
        var divide = 15 / 2;
        var division = 55/5;
        var div = 99.0/10;
        var div2 = 99/ 1.10f;
        var div3 = 125.0d /3;

        System.out.println("\nCalculation results :");
        System.out.println("10 * 20 ="+multiply);
        System.out.println("15 / 2 ="+divide); //int
        System.out.println("55/5 ="+division);  //int
        System.out.println("99.0/10 ="+div);    //float
        System.out.println("99/ 1.10f="+div2); //float
        System.out.println("125.0d /3 ="+div3); //double
    }
}
