package concurrency.executor.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinArraySum {
    // Threshold for splitting tasks
    private static final int THRESHOLD = 10;

    public static void main(String[] args) {
        // Example array
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Create the initial task
        SumTask task = new SumTask(array, 0, array.length);

        // Execute the task
        Integer result = pool.invoke(task);

        // Print the result
        System.out.println("Sum: " + result);
    }

    // RecursiveTask to compute the sum of an array
    static class SumTask extends RecursiveTask<Integer> {
        private int[] array;
        private int start;
        private int end;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            // If the task is small enough, compute directly
            if (end - start <= THRESHOLD) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                // Split the task into two sub-tasks
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);

                // Fork the sub-tasks
                leftTask.fork();
                rightTask.fork();

                // Join the results of the sub-tasks
                int leftResult = leftTask.join();
                int rightResult = rightTask.join();

                // Combine the results
                return leftResult + rightResult;
            }
        }
    }
}
