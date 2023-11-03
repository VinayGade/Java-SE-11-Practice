package beans;

import beans.enums.Category;

public class Dish {

    private int id;
    private String name;
    private int calories;
    private double price;
    private Category category;
    private boolean vegOnly;

    public Dish(int id, String name, int calories, double price, Category category, boolean vegOnly) {
        super();
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.category = category;
        this.vegOnly = vegOnly;
    }

    @Override
    public String toString() {
        return "Dish [id=" + id + ", name=" + name + ", calories=" + calories + ", price=" + price + ", category = "+ category +", vegOnly = "+vegOnly+"]";
    }

    public boolean isVegOnly() {
        return vegOnly;
    }

    public void setVegOnly(boolean vegOnly) {
        this.vegOnly = vegOnly;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
//pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon