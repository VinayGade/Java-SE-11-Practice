package enums;

import beans.enums.CoffeeSize;

public class Coffee {

    CoffeeSize coffeeSize;

    public static void main(String[] args) {

        Coffee coffeeDrink1 = new Coffee();

        coffeeDrink1.coffeeSize = CoffeeSize.HUGE;

        Coffee coffeeDrink2 = new Coffee();

        coffeeDrink2.coffeeSize = CoffeeSize.BIG;

        System.out.println("Coffee Drink1 cost ="+coffeeDrink1.coffeeSize.getOunces());
        System.out.println("Coffee Drink2 cost ="+coffeeDrink2.coffeeSize.getOunces());

        for(CoffeeSize size : CoffeeSize.values()){
            System.out.println("Coffee Size = "+ size.name()+", cost = "+size.getOunces() +" Ounces.");
        }
    }
}
