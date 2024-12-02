package abstraction;

public class Fish extends Animal {

    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {

        if (speed.equals("slow")) {
            System.out.println(getType() + " lazily swimming");
        } else {
            System.out.println(getType() + " darting frantically");
        }

    }

    @Override
    public void move(int speed) {
        System.out.println("Fish moves at speed"+ speed);
    }

    @Override
    public void move() {
        System.out.println("Fish isn't moving. its dead");
    }

    @Override
    public void makeNoise() {

        if (type == "Goldfish") {
            System.out.print("swish ");
        } else {
            System.out.print("splash ");
        }

    }
}
