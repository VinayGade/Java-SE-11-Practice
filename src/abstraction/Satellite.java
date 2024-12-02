package abstraction;

import abstraction.interfaces.FlightStages;
import abstraction.interfaces.OrbitEarth;

public class Satellite implements OrbitEarth {

    FlightStages stage = FlightStages.GROUNDED;

    public void achieveOrbit() {
        transition("Orbit achieved!");
    }

    @Override
    public void takeOff() {

        transition("Taking Off");
    }

    @Override
    public void land() {

        transition("Landing");
    }

    @Override
    public void fly() {

        achieveOrbit();
        transition("Data Collection while Orbiting");
    }

    //This method doesn't override default method of OrbitEarth
    //Overloading
    public void transition(String description) {

        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}
