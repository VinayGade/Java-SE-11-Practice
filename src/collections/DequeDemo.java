package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    /*
    It can either be used as a queue(first-in-first-out/FIFO) or as a stack(last-in-first-out/LIFO)
    * */
        public static void main(String[] args)
        {
            Deque<String> deque
                    = new LinkedList<>();

            // We can add elements to the queue
            // in various ways

            // Add at the last
            deque.add("Element 1 (Tail)");

            // Add at the first
            deque.addFirst("Element 2 (Head)");

            // Add at the last
            deque.addLast("Element 3 (Tail)");

            // Add at the first
            deque.push("Element 4 (Head)");

            // Add at the last
            deque.offer("Element 5 (Tail)");

            // Add at the first
            deque.offerFirst("Element 6 (Head)");

            System.out.println(deque + "\n");

            // We can remove the first element
            // or the last element.
            deque.removeFirst();
            deque.removeLast();
            System.out.println("Deque after removing "
                    + "first and last: "
                    + deque);

            Deque<String> dq
                    = new ArrayDeque<String>();

            // add() method to insert
            dq.add("For");
            dq.addFirst("Geeks");
            dq.addLast("Geeks");

            System.out.println(dq);

            System.out.println(dq.pop());

            System.out.println(dq.poll());

            System.out.println(dq.pollFirst());

            System.out.println(dq.pollLast());
        }


}
