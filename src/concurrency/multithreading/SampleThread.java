package concurrency.multithreading;

public class SampleThread {

    public static void main(String[] args) {

        Thread t = new Thread();
        t.start();  // Thread t starts runs and terminates immediately since there isn't any task to execute.

        //Thread(Runnable r) : constructor that takes runnable as argument

        Thread runnableThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("\nJava 7 Runnable thread"+" threadId = "+Thread.currentThread().getId());
            }
        });

        Thread ct = new CustomThread() ;

        Thread lambdaThread = new Thread(() -> {
            System.out.println("\nJava 8 Runnable thread -> Lambda"
                    +"\nlambda threadId = "+Thread.currentThread().getId());
        });

        Thread myRunnable = new Thread(new MyRunnable());

        runnableThread.start();
        ct.start();
        myRunnable.start();
        lambdaThread.start();

        System.out.println("\nThis is main thread" +" threadId = "+Thread.currentThread().getId());

    }
}
