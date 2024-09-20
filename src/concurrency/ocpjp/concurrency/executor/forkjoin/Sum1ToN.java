package concurrency.ocpjp.concurrency.executor.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Sum1ToN extends RecursiveAction {

    public static long total = 0;
    private static final int THRESHOLD = 5;

    private List<Long> data;

    public Sum1ToN(List<Long> data){
        this.data = data;
    }
    @Override
    protected void compute() {
        //int n = data.size();
        if(data.size()<=THRESHOLD) {
            long sum = computeSum(data.size());
            System.out.println("Sum = "+sum);
        } else {
            int mid = data.size() / 2;
            Sum1ToN firstSubTask = new Sum1ToN(data.subList(0, mid));
            Sum1ToN secondSubTask = new Sum1ToN(data.subList(mid, data.size()));

            firstSubTask.fork();
            secondSubTask.compute();
            firstSubTask.join();
        }
    }

    private long computeSum(int n) {
        long sum = 0;
        for(long x: data){
            sum = sum + x;
        }
        total = total + sum;
        return sum;
    }

    public static void main(String[] args) {

        int end = 5000;

        List<Long> data = LongStream.rangeClosed(0, end)
                .boxed()
                .collect(Collectors.toList());

        ForkJoinPool pool = new ForkJoinPool();
        System.out.println("Pool Parallelism"+pool.getParallelism());

        Sum1ToN task = new Sum1ToN(data);
        pool.invoke(task);

        System.out.println("\nSum using Fork-Join = "+total);
        System.out.println("\nSum Calculated using stream = "+
                LongStream.rangeClosed(0, end).sum());
    }
}
