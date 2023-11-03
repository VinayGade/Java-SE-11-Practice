package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ArrayDequeCWH {

     /*
     Constructors :

     ArrayDeque()
        Constructs an empty array deque with an initial capacity sufficient to hold 16 elements.


     *
     *
     * */

    public static void main(String[] args) {
        Deque<Integer> arrayDq = new ArrayDeque<>();

        arrayDq.push(10);
        arrayDq.addLast(20);
        arrayDq.offerLast(30);
        arrayDq.add(40);
        arrayDq.add(50);
        arrayDq.offerLast(30);

        System.out.println("\nIterating over arrayDeque :");

        Iterator<Integer> dqIterator = arrayDq.iterator();
        while(dqIterator.hasNext()){
            System.out.println(" "+dqIterator.next());
        }

        // insert from front and rear

        arrayDq.addFirst(5);
        arrayDq.addLast(60);

        System.out.println("\nfirst(arrayDq) = "+arrayDq.getFirst());
        System.out.println("\nlast(arrayDq) = "+arrayDq.getLast());

        System.out.println("\nelement(arrayDq) = "+arrayDq.element());  // front(arrayDq)
        System.out.println("\npeek(arrayDq) = "+arrayDq.peek());  // front(arrayDq)
        System.out.println("\npeek first(arrayDq) = "+arrayDq.peekFirst());
        System.out.println("\npeek last(arrayDq) = "+arrayDq.peekLast());

        arrayDq.offerFirst(1);
        arrayDq.offerLast(80);
        arrayDq.offerLast(80);
        arrayDq.push(100);

        arrayDq.offerLast(500);

        System.out.println("\nfirst(arrayDq) = "+arrayDq.getFirst());
        System.out.println("\nlast(arrayDq) = "+arrayDq.getLast());

        System.out.println("\nReverse Iterating over arrayDeque after insertions from both ends :");
        Iterator<Integer> reverseIterator = arrayDq.descendingIterator();
        while(reverseIterator.hasNext()){
            System.out.println(" "+reverseIterator.next());
        }

        System.out.println("\n Removing elements :");

        Integer poll = arrayDq.poll();
        System.out.println("\n Poll :"+poll);

        Integer pollFirst =arrayDq.pollFirst();
        System.out.println("\n Poll First :"+pollFirst);

        Integer pollLast =arrayDq.pollLast();
        System.out.println("\n Poll Last :"+pollLast);

        System.out.println("\n pop :"+arrayDq.pop());
        System.out.println("\n remove :"+arrayDq.remove());
        System.out.println("\n remove first :"+arrayDq.removeFirst());
        System.out.println("\n remove Last :"+arrayDq.removeLast());

        System.out.println("\nIterating over arrayDeque after Deletions:");

        for(int i:arrayDq)
            System.out.print(" "+i);

        arrayDq.offer(85);
        arrayDq.offerLast(90);
        arrayDq.add(95);
        arrayDq.addLast(100);

        arrayDq.push(30);
        arrayDq.offerLast(85);

        arrayDq.add(500);

        System.out.println("\nIterating over arrayDeque b4 Deletions:");

        for(int i:arrayDq)
            System.out.print(" "+i);

        System.out.println("\nDeletions duplicates and specific elements:");

        System.out.println("remove 95 :"+arrayDq.remove(95));

        System.out.println("remove First 30 :"+arrayDq.removeFirstOccurrence(30));

        System.out.println("peek arrayDq :"+arrayDq.peek());

        System.out.println("remove last 85 :"+arrayDq.removeLastOccurrence(85));

        System.out.println("remove last 30 :"+arrayDq.removeLastOccurrence(30));

        System.out.println("peek last arrayDq : "+arrayDq.peekLast());
        arrayDq.remove(500);

        System.out.println("\nIterating over arrayDeque after Deletions:");

        for(int i:arrayDq)
            System.out.print(" "+i);

        System.out.println("\nFollowing methods throws Exception :");
        System.out.println("to get :"+"getFirst(), getLast()");
        System.out.println("For insert :"+"addFirst(), addLast()");
        System.out.println("For removal :"+"removeFirst(), removeLast()");

        System.out.println("\n Queue<E>  <-  Deque<E>  <-  LinkedList ");
        System.out.println("\n hence, All operations of deque can be performed by using LinkedList .");
    }

}
