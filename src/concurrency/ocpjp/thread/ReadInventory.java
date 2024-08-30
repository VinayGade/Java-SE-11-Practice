package concurrency.ocpjp.thread;

public class ReadInventory extends Thread{
    public void run(){
        System.out.println("Printing Zoo inventory...");
    }

    public static void main(String[] args) {
        System.out.println("Begin");
        new ReadInventory().start();
        new Thread(new PrintData()).start();
        new ReadInventory().start();
        System.out.println("End");
    }
}
