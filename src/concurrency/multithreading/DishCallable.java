package concurrency.multithreading;

import beans.Dish;
import beans.enums.Category;

import java.util.concurrent.Callable;

public class DishCallable implements Callable<Dish> {

    @Override
    public Dish call() throws Exception {
        System.out.println("\n DishCallable call "+" Thread id ="+Thread.currentThread().getId());
        return new Dish(607,
                "Prawns Khichadi",
                291,
                380.50d,
                Category.FISH,
                false);
    }
}
