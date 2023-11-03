package collections.comparison;

import beans.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

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
    }
}
