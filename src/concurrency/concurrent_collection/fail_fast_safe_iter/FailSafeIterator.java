package concurrency.concurrent_collection.fail_fast_safe_iter;

import beans.Student;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeIterator {

    public static void main(String[] args) {

        /*

        Fail-safe iterators allow modifications of a collection while iterating over it.

        These iterators don’t throw any Exception if a collection is modified while iterating over it.

        They use copy of original collection to traverse over the elements of the collection.

        These iterators require extra memory for cloning of collection.

        Ex : ConcurrentHashMap, CopyOnWriteArrayList
        * */

        //Student info map

        List<String> branches = new LinkedList<>();
        branches.add("CM");
        branches.add("IT");
        branches.add("EXTC");
        branches.add("MECH");
        branches.add("CHEM");

        Map<String, List<Student>> studentMap = new HashMap<>();
        studentMap.put("CM",
                Arrays.asList(new Student(101, "Vinay Gade", 23),
                        new Student(121, "Ganesh More", 22),
                        new Student(101, "Vikas Wagh", 21)));

        studentMap.put("EXTC",
                Arrays.asList(new Student(327, "Divya Yadav", 22),
                        new Student(308, "Rahul Pawar", 19),
                        new Student(101, "Ketan Kamble", 18)));

        studentMap.put("MECH",
                Arrays.asList(new Student(542, "Shruti Bhor", 21),
                        new Student(519, "Smita Patil", 23),
                        new Student(505, "Vinod Chavan", 21)));

        studentMap.put("CHEM",
                Arrays.asList(new Student(218, "Swati Parab", 19),
                        new Student(237, "Gautam Sathe", 23),
                        new Student(207, "Riya Ghosh", 20)));

        Map<String, List<Student>> studentConcurrentMap = new ConcurrentHashMap<>(studentMap);

        Iterator<String> concurrentIterator = studentConcurrentMap
                .keySet().iterator();

        List<String> latestBranches = Arrays.asList("INSTRU", "BIOM");

        List<List<Student>> newAdmissions = new ArrayList<>();
        List<Student> instruStudents = List.of(
                new Student(411, "Vanita Mane", 23),
                new Student(427, "Nikhil Joshi", 21),
                new Student(435, "Sanket Samat", 19));

        List<Student> biomStudents = List.of(
                new Student(624, "Mandar Sawant", 22),
                new Student(631, "Pratik Ghag", 21),
                new Student(417, "Savita Rathi", 19));

        newAdmissions.add(instruStudents);
        newAdmissions.add(biomStudents);

        while(concurrentIterator.hasNext()){
            String branch = concurrentIterator.next();
            System.out.println("Branch" + branch);
            List<Student> students = studentConcurrentMap.get(branch);
            System.out.println("Students:");
            students.forEach(System.out::println);
            studentConcurrentMap.put(latestBranches.get(0), instruStudents);  // throws Exception
            studentConcurrentMap.put(latestBranches.get(1), biomStudents);
        }
    }
}
