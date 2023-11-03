package beans;

import beans.inrerfaces.Alarm;
import beans.inrerfaces.Vehicle;

public class Car implements Vehicle, Alarm {

    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The car is speeding up.";
    }

    @Override
    public String slowDown() {
        return "The car is slowing down.";
    }

    // way 1: Override Vehicle : turnAlarmOn/Off()
    /*
    @Override
    public String turnAlarmOn() {
        return Vehicle.super.turnAlarmOn();
    }

    @Override
    public String turnAlarmOff() {
        return Vehicle.super.turnAlarmOff();
    }

     */

    // way 2: Override Alarm : turnAlarmOn/Off()
    /*
    @Override
    public String turnAlarmOn() {
        return Alarm.super.turnAlarmOn();
    }

    @Override
    public String turnAlarmOff() {
        return Alarm.super.turnAlarmOff();
    }
*/

    // way 3: Override Vehicle : turnAlarmOn/Off() & Alarm : turnAlarmOn/Off()
    @Override
    public String turnAlarmOn() {
        return Vehicle.super.turnAlarmOn() + " " + Alarm.super.turnAlarmOn();
    }

    @Override
    public String turnAlarmOff() {
        return Vehicle.super.turnAlarmOff() + " " + Alarm.super.turnAlarmOff();
    }


}

