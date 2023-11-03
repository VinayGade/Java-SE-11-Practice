package concurrency.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPoolExample {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static Future<Double> getRandom(int i){
        return executorService.submit(() -> {
            System.out.println(i+", thread id="+Thread.currentThread().getId());
            Thread.sleep((int) (Math.random()*2000));
            return Math.random();
        });
    }
    public static void main(String[] args) {

        for(int i=0; i < 100; i++){
            getRandom(i);
        }
        executorService.shutdown();
    }
}
