package concurrency.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleSubmitExample {

    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static Future<Double> getRandom(int i){
        return executorService.submit(() -> {
            System.out.println(i);
            Thread.sleep(100);
            return Math.random();
        });
    }
    public static void main(String[] args) {

        Future<Double> doubleFuture = getRandom(10);
        getRandom(1);
        getRandom(4);
        getRandom(3);
        while(!doubleFuture.isDone()){
            if(doubleFuture.isCancelled()){
                System.out.println("Your future was cancelled. We apologise!!!");
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            System.out.println("Double future :"+doubleFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}
