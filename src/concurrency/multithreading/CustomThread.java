package concurrency.multithreading;

public class CustomThread extends Thread{

    @Override
    public void run(){
        System.out.println("\nGenerate thread by extending thread class"
                +"\n Java 7 Custom thread i.e. user defined thread, "
                +" Thread id = " +Thread.currentThread().getId());
    }
}
