package concurrency.ocpjp.concurrency.executor;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class AmbiguousLambda {

    static void useCallable(Callable<Integer> expression){

    }

    static void useSupplier(Supplier<Integer> expression){}

    static void use(Supplier<Integer> expression){}

    static void use(Callable<Integer> expression){}

    public static void main(String[] args) {
        useCallable(()->{throw new IOException();});

        /*Supplier doesn't support Checked Exception*/
        //useSupplier(()->{throw new IOException();});

        /*
        ambiguous lambda Expression
        compiler is confused which method to call? Callable/Supplier
        * */
        //use(()->{throw new IOException();});

        use((Callable<Integer>)()->{throw new IOException();});
    }
}
