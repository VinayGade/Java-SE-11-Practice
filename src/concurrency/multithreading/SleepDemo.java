package concurrency.multithreading;

public class SleepDemo {
    public static void main(String[] args) {

        System.out.println("\n--------------- sleeping thread ----------------");


        /*
        Thread sleepThread = new Thread(new SleepingThread());
        sleepThread.start();
        //sleepThread.interrupt();

        Thread sleepThread2 = new Thread(new SleepingThread());
        sleepThread2.start();
        */

       joiningThread();

    }

    public static void joiningThread(){

        System.out.println("\nThread 3 join thread 4");
        Thread thread3 = new Thread(new SleepingThread());
        Thread thread4 = new Thread(new SleepingThread());

        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread4.start();
    }
}
