package edu.iutcs.cr.vehicles;

import edu.iutcs.cr.controller.InputReader;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class Sedan extends Vehicle {

    private boolean hasSunroof;

    public Sedan() {
        super();
        setHasSunroof();
    }

    public boolean hasSunroof() {
        return hasSunroof;
    }

    public void setHasSunroof() {
        System.out.print("Does the sedan have a sunroof? (true/false): ");
        this.hasSunroof = InputReader.getInstance().nextBoolean();
    }

    @Override
    public String toString() {
        return "Sedan{" + super.toString() + ", " +
                "hasSunroof=" + hasSunroof() +
                "}";
    }
}
