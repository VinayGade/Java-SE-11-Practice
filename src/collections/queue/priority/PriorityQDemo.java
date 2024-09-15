package collections.queue.priority;

import java.util.*;

public class PriorityQDemo {

    public static void main(String[] args) {

        //min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(6);
        pq.add(1);
        pq.add(2);
        pq.add(4);

        System.out.println(pq.peek());
        System.out.println(pq.poll());

        System.out.println("\npq data:");
        pq.forEach(System.out::println);

        //max Heap
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.add(10);
        pq2.add(50);
        pq2.add(70);
        pq2.add(80);

        System.out.println(pq2.peek());
        System.out.println(pq2.poll());

        System.out.println("\npq2 data:");
        pq2.forEach(System.out::println);

        List<Integer> list = Arrays.asList(100, 80, 20, 50, 30, 90, 80);
        int k = 3;

        Queue<Integer> kLargest = findKHighest(list, k);
        System.out.println("\n"+k+" largest elements:");

        kLargest.forEach(System.out::println);

        Integer kthSmallest = findKthSmallest(list, k);
        System.out.println("\n"+k+"th smallest element:");

        System.out.println(kthSmallest);
    }

    static Queue<Integer> findKHighest(List<Integer> list, int k) {
        Queue<Integer> kthHighest = new PriorityQueue<>();

        for (Integer each : list) {
            kthHighest.add(each);
            if (kthHighest.size() > k) {
                kthHighest.poll();
            }
        }
        return kthHighest;
    }

    static Integer findKthSmallest(List<Integer> list, int k) {
        Queue<Integer> kthSmallest = new PriorityQueue<>(Comparator.reverseOrder());

        for (Integer each : list) {
            kthSmallest.add(each);
            if (kthSmallest.size() > k) {
                kthSmallest.poll();
            }
        }
        return kthSmallest.peek();
    }
}
