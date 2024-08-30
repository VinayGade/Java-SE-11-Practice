package concurrency.head_first.bank;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {

    //private int balance;

    private final AtomicInteger balance = new AtomicInteger(100);

    public int getBalance() {

        //return this.balance;

        return balance.get();
    }

    public void spend(String name, int amount){
        //balance = balance-amount;

        int initialBalance = balance.get();

        if(initialBalance > amount) {
            boolean success = balance.compareAndSet(
                    initialBalance, (initialBalance - amount)
            );


        /*
        if(balance < 0){
            System.out.println("Overdrawn!!");
        }*/

            if (!success)
                System.out.println("Sorry "+name+", you have not spent money.");
        }else
            System.out.println("Sorry, Not enough balance for "+name);
    }
}
