package concurrency.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleExecuteExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->System.out.println("1: "+Math.random()
                + ", Thread id: "+Thread.currentThread().getId()));

        executorService.execute(()->System.out.println("2: "+Math.random()
                + ", Thread id: "+Thread.currentThread().getId()));

        executorService.execute(()->System.out.println("3: "+Math.random()
                + ", Thread id: "+Thread.currentThread().getId()));

        executorService.execute(()->System.out.println("4: "+Math.random()
                + ", Thread id: "+Thread.currentThread().getId()));


        System.out.println("\n Callable ExecutorService");
        callableExecutorService(executorService);

        executorService.shutdown();
    }

    public static void callableExecutorService(ExecutorService executorService){

        List<Callable<Integer>> callables = new ArrayList<>();

        callables.add(() -> 10);
        callables.add(() -> 20);
        callables.add(() -> 50);
        callables.add(() -> 40);
        callables.add(() -> 30);

        try {
            Thread.sleep(200);
           // System.out.println(executorService.invokeAny(callables));  //(1)
            System.out.println(executorService.invokeAll(callables).get(3).isDone());    //(2)   // 0 .. 4
        } catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }
        //(2)
        /*
        catch(ExecutionException e) {
            throw new RuntimeException(e);
        }

         */
    }
}
