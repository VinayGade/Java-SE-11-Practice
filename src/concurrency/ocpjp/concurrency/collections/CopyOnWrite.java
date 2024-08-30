package concurrency.ocpjp.concurrency.collections;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWrite {

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(
                10, 50, 100, 200, 500
        ));

        int i = 800;
        for(Integer item: list){
            System.out.println(item);
            list.add(i+200);
            i+=200;
        }
        System.out.println();
        System.out.println(list.size());
        list.forEach(x -> System.out.print(" "+x));
    }
}
