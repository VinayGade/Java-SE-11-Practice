package concurrency.ocpjp.concurrency.executor;

import java.util.concurrent.*;

public class BlockingDeq {

    public static void main(String[] args) {
        try{
            BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
            blockingDeque.offer(90);
            blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
            blockingDeque.offerLast(45, 200, TimeUnit.MINUTES);
            blockingDeque.offer(3, 4, TimeUnit.SECONDS);

            System.out.println(blockingDeque.poll());

            System.out.println(blockingDeque.poll(900, TimeUnit.MILLISECONDS));
            System.out.println(blockingDeque.pollFirst(200, TimeUnit.MICROSECONDS));
            System.out.println(blockingDeque.pollLast(2, TimeUnit.SECONDS));
            System.out.println();
        }catch(InterruptedException e){

        }
    }
}
