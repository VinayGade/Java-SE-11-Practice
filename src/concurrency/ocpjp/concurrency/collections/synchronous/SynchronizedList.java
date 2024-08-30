package concurrency.ocpjp.concurrency.collections.synchronous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SynchronizedList {

    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>(
                Arrays.asList(5, 10, 50)
        ));
        synchronized (list){
            for(int data: list)
                System.out.print(data+" ");
        }
    }
}
