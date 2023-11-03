package concurrency.executor;

import java.util.concurrent.*;

public class ScheduledThreadPoolExample {

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(50);

    public static void main(String[] args) {
        int i = 0;

        //(5)
        executorService.scheduleAtFixedRate(() -> {
                    System.out.println("i=" + i + ", Thread id = " + Thread.currentThread().getId());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                },
                2000,200, TimeUnit.MILLISECONDS);


        //(4)
        /*
        executorService.scheduleWithFixedDelay(() ->
            System.out.println("i="+i+", Thread id = "+Thread.currentThread().getId()),
                2000,1000, TimeUnit.MILLISECONDS);
        */
        try {
            executorService.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // (0)
         /*
            Future<Double> doubleFuture = executorService.schedule(() -> {
            System.out.println("1 thread id="+Thread.currentThread().getId());
            Thread.sleep((int) (Math.random()*2000));
            return Math.random();
        }, 1000, TimeUnit.MILLISECONDS);
        */
        //(4)
        /*
        try {
            //System.out.println(doubleFuture.get());  //(1)
            System.out.println(doubleFuture.get(300, TimeUnit.MILLISECONDS));  //(2),(3)

        } catch (InterruptedException | ExecutionException ex){  //(2)
            ex.printStackTrace();
        } catch (TimeoutException e) {  // (3)
            e.printStackTrace();
            doubleFuture.cancel(true);
        }

        if(doubleFuture.isCancelled())
            System.out.println("Sorry!! Future was cancelled...");

        if(doubleFuture.isDone())
            System.out.println("I'm done ... (not successfully since future is cancelled...)");
        */
        executorService.shutdown();
    }
}
