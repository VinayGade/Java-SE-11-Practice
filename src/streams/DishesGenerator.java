package streams;

import beans.Dish;
import beans.enums.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DishesGenerator {

    public List<Dish> populateDishes(){
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish(101, "Roasted Mutton salad", 500 , 210.0, Category.MEAT, false));
        dishes.add(new Dish(574, "Stuffed Salmon with Soy Sauce", 310 , 240.0, Category.FISH, false));
        dishes.add(new Dish(271, "Boiled chicken Breast salad", 350 , 190.0, Category.CHICKEN, false));
        dishes.add(new Dish(908, "Mixed Vegetables salad with Mozerella Cheese", 250 , 170.0, Category.VEG, true));
        dishes.add(new Dish(315, "Fried Egg Sandwich with Almond Butter", 300 , 150.0, Category.EGG, false));

        dishes.add(new Dish(508, "Prawns Biryani", 250 , 240.0, Category.FISH, false));
        dishes.add(new Dish(378, "Spaghetti Bolognese", 240 , 250.0, Category.EGG, false));
        dishes.add(new Dish(375, "Egg Fried Rice", 250 , 200.0, Category.EGG, false));
        dishes.add(new Dish(901, "Season Fruit Salad", 140 , 120.0, Category.FRUIT, true));
        dishes.add(new Dish(593, "Stuffed Basa with Fried Egg", 360 , 280.0, Category.FISH, false));

        dishes.add(new Dish(917, "French Fries with Coke", 150 , 50.0, Category.STARTER, true));

        dishes.add(new Dish(518, "Roasted Shrimp Salad with Mixed Vegetables", 360 , 270.0, Category.FISH, false));

        dishes.add(new Dish(581, "Stuffed BombayDuck with Red Chilli Sauce and Peanut Butter", 350 , 340.0, Category.FISH, false));


        return dishes;
    }

    //pork, chicken, french fries, rice, season fruit, pizza, prawns, salmon

    public List<Dish> populateSpecialMenu(){
        return Arrays.asList(

                new Dish(501,"Chicken Lollipop Dry", 198, 180, Category.CHICKEN,false),

                new Dish(328,"Paneer Crispy", 80, 220, Category.STARTER,true),
                new Dish(329,"Veg Crispy", 72, 205, Category.STARTER,true),

                new Dish(507,"Tandoori Chicken", 201, 380, Category.CHICKEN,false),

                new Dish(101,"seasonal fruit salad", 70, 120.0, Category.FRUIT,true),

                new Dish(705,"Stuffed Prawns ", 180, 300, Category.FISH,false),

                new Dish(110,"Chikoo Milk Shake", 65, 95.0, Category.FRUIT,true),

                new Dish(702,"Prawns Biryani", 172, 340, Category.FISH,false),

                new Dish(709,"Prawns Khichadi", 195, 385, Category.FISH,false),

                new Dish(201,"Steam Rice", 45, 81, Category.VEG, true),
                new Dish(207,"Jeera Fried Rice", 45, 87, Category.VEG, true),

                new Dish(721,"Pomfret Rawa Fry", 175, 357, Category.FISH,false),
                new Dish(725,"Bombil Fry", 165, 245, Category.FISH,false),

                new Dish(107,"Watermelon Juice", 35, 70.0, Category.FRUIT,true),

                new Dish(605,"Fried Egg", 128, 90, Category.EGG,false),
                new Dish(531,"Chicken Biryani", 175, 410, Category.CHICKEN,false),
                new Dish(609,"Egg Fried Rice", 168, 180, Category.EGG,false),

                new Dish(211,"Dal Khichadi", 85, 125, Category.VEG, true),

                new Dish(255,"Paneer Tikka Masala", 98, 185, Category.VEG, true),

                new Dish(728,"Surmai Masala Fry", 175, 350, Category.FISH,false),
                new Dish(735,"Surmai Gaon Curry", 155, 400, Category.FISH,false),

                new Dish(245,"Veg Handi", 78, 165, Category.VEG, true),

                new Dish(523,"Chicken Tikka Masala", 195, 480, Category.CHICKEN,false),
                new Dish(517,"Chicken Salad", 155, 400, Category.CHICKEN,false),

                new Dish(243,"Veg Hyderabadi", 71, 195, Category.VEG, true),

                new Dish(826,"Mutton Fry", 240, 362, Category.MEAT,false),
                new Dish(821,"Mutton Masala", 190, 385, Category.MEAT,false),

                new Dish(604,"Egg Bhurji", 184, 165, Category.EGG,false),

                new Dish(738,"Fish Curry", 145, 350, Category.FISH,false),

                new Dish(318,"Masala Dosa", 60, 160, Category.STARTER,true),
                new Dish(323,"Veg Spring Roll", 75, 210, Category.STARTER,true),

                new Dish(731,"Fish Masala", 172, 365, Category.FISH,false),


                new Dish(521,"Butter Chicken", 195, 470, Category.CHICKEN,false),
                new Dish(529,"Chicken Kheema", 210, 450, Category.CHICKEN,false),

                new Dish(223,"Veg Biryani", 55, 145, Category.VEG, true),

                new Dish(301,"French Fries", 90, 530, Category.STARTER ,true),

                new Dish(805,"Mutton Paya Soup", 170, 280, Category.MEAT,false),
                new Dish(815,"Mutton Biryani", 210, 372, Category.MEAT,false),

                new Dish(108,"Mango Milk Shake", 55, 135.0, Category.FRUIT,true)
        );
    }

}
