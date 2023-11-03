package concurrency.multithreading;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("\nJava 7 my runnable thread"+
                "\nMy Runnable thread id ="+Thread.currentThread().getId());
    }
}
