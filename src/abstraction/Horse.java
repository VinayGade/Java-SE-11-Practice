package abstraction;

public class Horse extends Mammal {

    public Horse(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(int speed) {
        System.out.println("Horse is running so fast at speed"+speed);
    }

    @Override
    public void move() {
        System.out.println("Horse is standing");
    }

    @Override
    public void shedHair() {

        System.out.println(getType() + " sheds in the spring");
    }

    @Override
    public void makeNoise() {

    }
}
