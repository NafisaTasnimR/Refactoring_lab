package edu.iutcs.cr.vehicles;

import edu.iutcs.cr.controller.InputReader;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Bus extends Vehicle {

    private int passengerCapacity;

    public Bus() {
        super();
        setPassengerCapacity();
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity() {
        System.out.print("Enter new passenger capacity: ");
        this.passengerCapacity = InputReader.getInstance().nextInt();
    }

    @Override
    public String toString() {
        return "Bus{" + super.toString() + ", " +
                "passengerCapacity=" + getPassengerCapacity() +
                "}";
    }
}
