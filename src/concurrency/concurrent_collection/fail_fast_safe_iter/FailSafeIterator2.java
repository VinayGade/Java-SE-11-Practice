package concurrency.concurrent_collection.fail_fast_safe_iter;

import beans.Student;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeIterator2 {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student(371, "Shreya Solanki", 21));
        students.add(new Student(357, "Prashant", 20));

        CopyOnWriteArrayList<Student> copyStudents = new CopyOnWriteArrayList<Student>(students);

        int c=0;
        ListIterator<Student> iterator = copyStudents.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            ++c;
            if(c==2)
                copyStudents.add(new Student(421, "Gaurav More", 22));
        }

        CopyOnWriteArrayList<Integer> list
                = new CopyOnWriteArrayList<Integer>(new Integer[] { 1, 3, 5, 8 });
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Integer no = (Integer)itr.next();
            System.out.println(no);
            if (no == 8)

                // This will not print,
                // hence it has created separate copy
                list.add(14);
        }
    }
}
