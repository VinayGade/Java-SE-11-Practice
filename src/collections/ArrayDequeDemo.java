package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayDequeDemo {

    public static void main(String[] args) {

        /*
        special kind of array that grows and allows users to add or remove an element from both sides of the queue
        * */

        /*
        important features of ArrayDeque are as follows:

1.  Array deques have no capacity restrictions and they grow as necessary to support usage.
2.  They are not thread-safe which means that in the absence of external synchronization,
ArrayDeque does not support concurrent access by multiple threads.
3.  Null elements are prohibited in the ArrayDeque.
4.  ArrayDeque class is likely to be faster than Stack when used as a stack.
5.  ArrayDeque class is likely to be faster than LinkedList when used as a queue.

        * */

        Deque<String> adq = new ArrayDeque<>();

        adq.add("the");
        adq.addFirst("to");
        adq.addLast("Java");
        adq.offer("SE 8");

        adq.offer("Collections-");
        adq.offerFirst("Welcome");
        adq.offerLast("ArrayDeque");

        // Creating a custom character array
        char[] ch = { 'G', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'G', 'e', 'e', 'k', 's' };

        // Converting character array into string
        // using joining() method of Collectors class
        String chString
                = Stream.of(ch)
                .map(arr -> new String(arr))
                .collect(Collectors.joining());

        // Printing concatenated string
        System.out.println(chString);

        System.out.println("Array Deque :"+adq);

        System.out.println("\niterating Array Deque :");

        for (Iterator itr = adq.iterator(); itr.hasNext();) {

            // Print the elements
            System.out.print(itr.next() + " ");
        }

        System.out.println("\nreverse iterating Array Deque :");

        for (Iterator itr = adq.descendingIterator();
             itr.hasNext();) {

            System.out.print(itr.next() + " ");
        }

        System.out.println("\nAccessing Array Deque Elements :");

        System.out.println("adq -> first : "+adq.getFirst());
        System.out.println("adq -> last : "+adq.getLast());
        System.out.println("adq -> peekFirst : "+adq.peekFirst());
        System.out.println("adq -> peekLast : "+adq.peekLast());
        System.out.println("adq -> peek : "+adq.peek());

        // remove operations

        /*
        remove()
removeFirst()
removeLast()
poll()
pollFirst()
pollLast()
pop()
        * */

        System.out.println("Removing Array Deque Elements :");

        System.out.println("adq -> remove : "+adq.remove());
        System.out.println("adq -> removeLast : "+adq.removeLast());
        System.out.println("adq -> removeFirst : "+adq.removeFirst());
        System.out.println("adq -> pollFirst : "+adq.pollFirst());
        System.out.println("adq -> pollLast : "+adq.pollLast());
        System.out.println("adq -> poll : "+adq.poll());
        System.out.println("adq -> pop : "+adq.pop());

        System.out.println("Array Deque after Removing:"+adq);
    }
}
