package collections;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NthLargestPriorityq {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 10, 2, 9, 3, 7, 4, 6, 5, 7, 7, 7);

        findNHighest(list, 3);
        findNHighest(list, 1);
        findNHighest(list, 4);

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
}
