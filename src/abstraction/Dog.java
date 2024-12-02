package abstraction;

public class Dog extends Mammal {

    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {

        if (speed.equals("slow")) {
            System.out.println(getType() + " walking");
        } else {
            System.out.println(getType()  + " running");
        }

    }

    @Override
    public void move(int speed) {
        System.out.println("Dog is running at speed"+speed);
    }

    @Override
    public void move() {
        System.out.println("Dog is sleeping");
    }

    @Override
    public void shedHair() {
        System.out.println(getType()+" They shed hair all the time...");
    }

    @Override
    public void makeNoise() {

        if (type == "Wolf") {
            System.out.print("Howling! ");
        } else {
            System.out.print("Woof! ");
        }

    }
}
