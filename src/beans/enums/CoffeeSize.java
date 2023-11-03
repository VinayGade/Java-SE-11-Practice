package beans.enums;

public enum CoffeeSize {

    BIG(8), HUGE(10), OVERWHELMING(16);

    private int ounces;

    CoffeeSize(int ounces) {
        this.ounces=ounces;
    }

    public int getOunces() {
        return ounces;
    }

}