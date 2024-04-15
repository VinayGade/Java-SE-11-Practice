package collections;

import beans.Student;

import java.util.*;

public class NthLargestPriorityq {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 10, 2, 9, 3, 7, 4, 6, 5, 7, 7, 7);

        findNHighest(list, 3);
        findNHighest(list, 1);
        findNHighest(list, 4);

        int n = 3;

        System.out.println("Nth oldest student : ");

        List<Student> students = populateStudents();

        System.out.println("\n Display students b4 sort: ");
        students.forEach(System.out::println);

        Student nthOldest = nthOldestStudent(students, n);

        System.out.println("\n Display "+n+"th oldest Student:");
        System.out.println(nthOldest.toString());

        Student nthStudent = nthStudent(students,n);
        System.out.println("\n Display "+n+"th Student w.r.t. Roll Number:");
        System.out.println(nthStudent.toString());
    }

    private static void findNHighest(List<Integer> list, int n) {
        Queue<Integer> nthHighest = new PriorityQueue<>();

        for (Integer each : list) {
            nthHighest.add(each);
            if (nthHighest.size() > n) {
                nthHighest.poll();
            }
        }
        System.out.println(nthHighest);
    }

    private static Student nthOldestStudent(List<Student> students, int n){

        // Custom ordered queue
        Comparator<Student> studentComparator = Comparator.comparingInt(Student::getAge).reversed();
        PriorityQueue<Student> studentsQ = new PriorityQueue<>(studentComparator);
        studentsQ.addAll(students);

        System.out.println("\n Display Students priority Q");

        studentsQ.forEach(System.out::println);
        int i = 1;

        while(i<n){
            System.out.println("\n Display "+i+"th oldest Student:"+studentsQ.peek().toString());
            studentsQ.poll();    // remove (n-1) oldest students
            i++;
        }
        return studentsQ.poll();
    }

    private static Student nthStudent(List<Student> students, int n){
        //nth student asc order of roll number
        Comparator<Student> studentComparator = Comparator.comparingInt(Student::getRollno);
        students.sort(studentComparator);
        return students.get(n-1);
    }

    public static List<Student> populateStudents(){
        return List.of(
                new Student(101,"Vinay", 19),
                new Student(107,"Rahul", 18),
                new Student(111,"Vivek", 20),
                new Student(117,"Reddy", 24),
                new Student(131,"Dinesh", 21),
                new Student(153,"Kunal", 22),
                new Student(167,"Ganesh", 20),
                new Student(175,"Vilas", 23),
                new Student(159,"Siddhesh", 17));
    }
}
