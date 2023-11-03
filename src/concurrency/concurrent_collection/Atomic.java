package concurrency.concurrent_collection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {

    private static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (var i = 0; i < 10;i++) {
            System.out.println("\ni= "+i+", Thread id ="+Thread.currentThread().getId());
            executorService.submit(() ->
                System.out.println("atomicCount ="+atomicCount.incrementAndGet())
            );
        }

        executorService.shutdown();
    }
}
