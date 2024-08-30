package concurrency.ocpjp.thread;

public class PrintData implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            System.out.println("Printing Record :"+i);
        }
    }

    public static void main(String[] args) {
        new Thread(new PrintData()).start();
    }
}
