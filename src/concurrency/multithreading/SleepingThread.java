package concurrency.multithreading;

public class SleepingThread implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("Thread id = " +Thread.currentThread().getId()+", i= "+i);
            try {
                Thread.sleep(500);
                if(i == 9)
                    System.out.println("Thread "+Thread.currentThread().getId()+" completed execution");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
                //Thread.currentThread().interrupt();  //... unreachable code
                //break;
            }
        }
    }
}
