package abstraction;

import abstraction.interfaces.FlightEnabled;
import abstraction.interfaces.FlightStages;
import abstraction.interfaces.OrbitEarth;
import abstraction.interfaces.Trackable;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

//        Animal animal = new Animal("animal", "big", 100);

        Dog dog = new Dog("Wolf", "big", 100 );
        dog.makeNoise();
        doAnimalStuff(dog);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "big", 150));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Fish("Barracuda", "big", 75));
        animals.add(new Dog("Pug", "small", 20));

        animals.add(new Horse("Clydesdale", "large", 1000));

        for (Animal animal : animals) {
            doAnimalStuff(animal);
            if (animal instanceof Mammal) {
                Mammal currentMammal = (Mammal)animal;
                currentMammal.shedHair();
            }
            /* Java 17
            if (animal instanceof Mammal currentMammal) {
                currentMammal.shedHair();
            }
            * */
        }

        Bird bird = new Bird("flier", "5 inch", 750.6);
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        animal.move();
//        flier.move();
//        tracked.move();

        flier.takeOff();
        flier.fly();
        tracked.track();
        flier.land();

        inFlight(new Jet());

//        OrbitEarth.log("Testing " + new Satellite());

        orbit(new Satellite());

    }

    private static void doAnimalStuff(Animal animal) {

        animal.makeNoise();
        animal.move("slow");
    }

    private static void inFlight(FlightEnabled flier) {

        flier.takeOff();
        flier.transition(FlightStages.LAUNCH);
        flier.fly();
        if (flier instanceof Trackable) {
            Trackable tracked = (Trackable) flier;
            tracked.track();
        }
        flier.land();
    }

    private static void orbit(OrbitEarth flier) {

        flier.takeOff();
        flier.fly();
        flier.land();
    }

}