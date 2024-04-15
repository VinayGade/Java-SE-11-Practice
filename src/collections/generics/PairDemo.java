package collections.generics;

import beans.Student;

public class PairDemo {

    public static void main(String[] args) {

        Pair<String, String> hello = new Pair<>("Hello", "World");
        Pair<Integer, Integer> sqrt = new Pair<>(100, 10);
        Pair<String, Integer> personAge = new Pair<>("Vinay", 30);
        Pair<Student, Student> studentPair = new Pair<>(
                new Student(10, "Vinay Gade", 18),
                new Student(15, "Naveen DSouza", 17)
        );

        // Pair<Integer> squarePair = new Pair<>(10, 100);
        // CF: wrong Type : required 2 provided 1

        System.out.println("Welcome to Java Generics");

        System.out.println(hello.getFirst()+" "+hello.getSecond());
        System.out.println("number = "+sqrt.getFirst()+", sqrt = "+sqrt.getSecond());
        System.out.println("person = "+personAge.getFirst()+", age = "+personAge.getSecond());

        System.out.println("Student Pair : ");
        System.out.println("Student 1 = "+studentPair.getFirst().toString());
        System.out.println("Student 1 = "+studentPair.getSecond().toString());
    }
}
