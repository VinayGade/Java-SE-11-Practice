package concurrency.ocpjp.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZooInfo {

    public static void main(String[] args) {
        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();
            System.out.println("Begin");
            service.execute(()->System.out.println("Printing Zoo Inventory"));
            service.execute(()->{
                for(int i=0; i<5; i++)
                    System.out.println("Printing Record:"+i);
            });
            service.execute(()->System.out.println("Printing Zoo Inventory"));
            System.out.println("End");
        }finally {
            if(service!=null)
                service.shutdown(); // terminate the application
        }
    }
}
