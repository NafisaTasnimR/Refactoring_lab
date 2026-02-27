package edu.iutcs.cr.vehicles;

import java.util.Scanner;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class SUV extends Vehicle {

    private boolean isOffRoad;

    public SUV() {
        super();
        setOffRoad();
    }

    public boolean isOffRoad() {
        return isOffRoad;
    }

    public void setOffRoad() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Is the SUV for off-road use? (true/false): ");
        this.isOffRoad = scanner.nextBoolean();
    }

    @Override
    public String toString() {
        return "SUV{" + super.toString() + ", " +
                "isOffRoad=" + isOffRoad() +
                "}";
    }
}
