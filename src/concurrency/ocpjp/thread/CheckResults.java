package concurrency.ocpjp.thread;

public class CheckResults {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for(int i=0; i<500; i++)
                CheckResults.counter+=10;
        }).start();

        while(CheckResults.counter<100){
            System.out.println("Not reached yet");
            Thread.sleep(1000);
        }
        System.out.println("Reached");
    }
}
