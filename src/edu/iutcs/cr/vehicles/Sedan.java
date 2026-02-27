package edu.iutcs.cr.vehicles;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Does the sedan have a sunroof? (true/false): ");
        this.hasSunroof = scanner.nextBoolean();
    }

    @Override
    public String toString() {
        return "Sedan{" + super.toString() + ", " +
                "hasSunroof=" + hasSunroof() +
                "}";
    }
}
