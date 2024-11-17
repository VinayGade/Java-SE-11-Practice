package collections.comparison;

import beans.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentComparison {

    public static void main(String[] args) {

        ArrayList<Student> students=new ArrayList<Student>();
        students.add(new Student(101,"Vinay",23));
        students.add(new Student(106,"Ajay",27));
        students.add(new Student(105,"Ketan",21));
        students.add(new Student(111,"Shruti",31));
        students.add(new Student(137,"Anita",25));

        System.out.println("students in ascending order of age");
        Collections.sort(students);
        students.forEach(student -> System.out.println(student.toString()));

        System.out.println("students in descending order of age");
        Collections.sort(students, new AgeComparator());
        students.forEach(student -> System.out.println(student.toString()));

        Iterator<Student> studentIterator = students.listIterator();

        while (studentIterator.hasNext()){
            System.out.println(studentIterator.next().toString());
        }

        List<String> names = mapNames(students);

        String sorted = isSorted(names) ? "YES": "NO";

        System.out.println("Student names sorted w.r.t. names :"+sorted);

        students.sort(Comparator.comparing(Student::getName));

        names = mapNames(students);

        sorted = isSorted(names) ? "YES": "NO";

        System.out.println("Student names sorted w.r.t. names :"+sorted);
    }

    public static boolean isSorted(List<String> listOfStrings) {
        return isSorted(listOfStrings, listOfStrings.size());
    }

    public static boolean isSorted(List<String> listOfStrings, int index) {
        if (index < 2) {
            return true;
        } else if (listOfStrings.get(index - 2).compareTo(listOfStrings.get(index - 1)) > 0) {
            return false;
        } else {
            return isSorted(listOfStrings, index - 1);
        }
    }

    static List<String> mapNames(List<Student> students){
        return students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
    }
}
