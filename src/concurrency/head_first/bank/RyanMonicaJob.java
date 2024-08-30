package concurrency.head_first.bank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RyanMonicaJob implements Runnable{

    private final BankAccount account;

    private final String name;

    private final int amountSpent;

    public RyanMonicaJob(String name, BankAccount account, int amountSpent) {
        this.account = account;
        this.name = name;
        this.amountSpent = amountSpent;
    }

    @Override
    public void run() {
        goShopping(amountSpent);
    }

    private void goShopping(int amount){
        synchronized (account) {
            if (account.getBalance() >= amount) {
                System.out.println(name + " is about to spend.");
                account.spend(name, amount);
                System.out.println(name + " finishes spending.");
            } else {
                System.out.println("Sorry, not enough for " + name);
            }
        }
    }

    public static void main(String[] args) {

        /*
        There is only 1 shared instance of Bank Account

        Both threads of Ryan and Monica will access this account
        * */

        BankAccount account = new BankAccount();
        RyanMonicaJob ryan = new RyanMonicaJob("Ryan", account, 150);
        RyanMonicaJob monica = new RyanMonicaJob("Monica", account, 100);

        /*
         * Thread pool contains 2 threads for 2 jobs of Ryan and Monica
         * */

        ExecutorService executor = Executors.newFixedThreadPool(2);

        //start both jobs running
        executor.execute(ryan);
        executor.execute(monica);
        executor.shutdown();

    }
}
