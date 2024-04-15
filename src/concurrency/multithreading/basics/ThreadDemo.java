package concurrency.multithreading.basics;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread myThread = new Thread(() -> {
            System.out.println("U r now in thread :"+Thread.currentThread().getName());
            System.out.println("thread priority :"+Thread.currentThread().getPriority());
        });

        myThread.setName("New Working Thread");
        myThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("B4 starting thread u r in thread :"+Thread.currentThread().getName());
        myThread.start();
        System.out.println("after Thread completion u r now in thread :"+Thread.currentThread().getName());

    }
}
