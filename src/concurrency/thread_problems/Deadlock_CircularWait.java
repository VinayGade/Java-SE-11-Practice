package concurrency.thread_problems;

public class Deadlock_CircularWait {

    public static void run(){

        final String resource1 = "Struck";
        final String resource2 = "Forever";

        Thread thread1 = new Thread(() -> {

            synchronized (resource1){
                System.out.println("\n Thread id "+Thread.currentThread().getId()+" is holding "+resource1);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource2){
                    System.out.println("\n Thread id "+Thread.currentThread().getId()+" is holding "+resource2);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            //synchronized (resource2){
            synchronized (resource1){    //(1)  solution to deadlock
                System.out.println("\n Thread id "+Thread.currentThread().getId()+" is holding "+resource2);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //synchronized (resource1){
                synchronized (resource2){    //(1) solution to deadlock
                    System.out.println("\n Thread id "+Thread.currentThread().getId()+" is holding "+resource1);
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        System.out.println("\nThread 1 and  Thread 2 are never ending threads");
        run();
    }
}