package concurrency.multithreading;

public class RiddleThread extends Thread{

    @Override
    public void run() {
        //super.run();

        System.out.println("I'm the task of custom thread");
        System.out.println("thread id in the task: "+Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        RiddleThread riddle = new RiddleThread();
        riddle.start();
        //riddle.run();
        System.out.println("thread id in main: "+Thread.currentThread().getId());
    }
}
