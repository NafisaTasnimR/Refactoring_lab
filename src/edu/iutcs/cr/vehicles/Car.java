package edu.iutcs.cr.vehicles;

import edu.iutcs.cr.controller.InputReader;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Car extends Vehicle {

    private int seatingCapacity;

    public Car() {
        super();
        setSeatingCapacity();
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity() {
        System.out.print("Enter new seating capacity: ");
        this.seatingCapacity = InputReader.getInstance().nextInt();
    }

    @Override
    public String toString() {
        return "Car{" + super.toString() + ", " +
                "seatingCapacity=" + getSeatingCapacity() +
                "}";
    }
}
