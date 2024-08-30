package concurrency.head_first.bank.race;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LostUpdate {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(6);

        Balance balance = new Balance();

        for(int i=0; i<1000; i++){
            pool.execute(balance::increment);
        }
        pool.shutdown();

        // Make sure pool has finished running all updates before printing final balance.
        if(pool.awaitTermination(1, TimeUnit.MINUTES)){
            System.out.println("Balance = "+balance.balance);
        }
    }
}

class Balance{
    //int balance = 0;

    AtomicInteger balance = new AtomicInteger(0);

    //balance can be used by multiple threads
    //Atomic Variables - CAS (Compare and swap)
    public void increment(){
        //balance++;
        balance.incrementAndGet();  // increaments balance and provide updated value.
    }
}