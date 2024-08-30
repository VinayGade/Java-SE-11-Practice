package concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MultiThreadHandle {

    public synchronized void test1(){
        System.out.println("Inside Test1");
        while(true){
            try{
                Thread.sleep(Long.MAX_VALUE);
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }

    public static synchronized void test2(){
        System.out.println("Inside Test2");
        while(true){
            try{
                Thread.sleep(Long.MAX_VALUE);
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}

public class ThreadTest{

    public static void main(String[] args) {
        MultiThreadHandle object = new MultiThreadHandle();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Runnable runnableTask1 = () -> {object.test1();};
        Runnable runnableTask2 = () -> {object.test2();};
        executor.execute(runnableTask1);
        executor.execute(runnableTask2);
    }
}