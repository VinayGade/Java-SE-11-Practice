package concurrency.multithreading.synchronization;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    public static int count = 0;

    public static Object lock = new Object();

    public static Lock LOCK = new ReentrantLock();

    public static void incrementCounter(){  //(1)
        var current = count;
        //System.out.println("\nBefore "+count+" Current Thread :"+Thread.currentThread().getId());
        count = current + 1;
        System.out.println("\nAfter "+count+" Current Thread :"+Thread.currentThread().getId());
    }

    public static synchronized void synchronizedIncrement(){  // (2)
        var current = count;
        System.out.println("\nBefore "+count+" Current Thread :"+Thread.currentThread().getId());
        count = current + 1;
        System.out.println("\nAfter "+count+" Current Thread :"+Thread.currentThread().getId());
    }

    public void synchronizedBlockIncrement(){  // (3)  Synchronized block
        synchronized(this) {
            var current = count;
            System.out.println("\nBefore " + count + " Current Thread :" + Thread.currentThread().getId());
            count = current + 1;
            System.out.println("\nAfter " + count + " Current Thread :" + Thread.currentThread().getId());
        }
    }

    public static void incrementLockCounter(){ //(4)
        synchronized (lock){
            var current = count;
            System.out.println("\nBefore " + count + " Current Thread :" + Thread.currentThread().getId());
            count = current + 1;
            System.out.println("After " + count + " Current Thread :" + Thread.currentThread().getId());
        }
    }

    public static void incrementCounterReentrantLock(){  //(5)
        try {
            LOCK.lock();
            var current = count;
            System.out.println("\nBefore " + count + " Current Thread :" + Thread.currentThread().getId());
            count = current + 1;
            System.out.println("After " + count + " Current Thread :" + Thread.currentThread().getId());
        }finally {
            LOCK.unlock();
        }
    }

    public static void incrementCounterTryLock() throws InterruptedException {  //(7)
        //if(LOCK.tryLock()){   //(6)
        if(LOCK.tryLock(10, TimeUnit.MILLISECONDS)){
            try {
                LOCK.lock();
                var current = count;
                System.out.println("\nBefore " + count + " Current Thread :" + Thread.currentThread().getId());
                count = current + 1;
                System.out.println("After " + count + " Current Thread :" + Thread.currentThread().getId());
            }finally {
                LOCK.unlock();
            }
        }else
            System.out.println("Thread didn't get the lock and looking for another task...");

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            //Thread t = new Thread(Counter::incrementCounter);  //(1)
            //Thread t = new Thread(Counter::synchronizedIncrement);  //(2)
            /*
            Thread t = new Thread(()->{  //(3)
                Counter counter = new Counter();
                counter.synchronizedBlockIncrement();
            });

             */
            //Thread t = new Thread(Counter::incrementLockCounter);  //(4)

            //Thread t = new Thread(Counter::incrementCounterReentrantLock);  //(5)

            //Thread t = new Thread(Counter::incrementCounterTryLock);  //(6)

            //(7)
            Thread t = new Thread(()->{
                try {
                    incrementCounterTryLock();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
        }
    }
}
