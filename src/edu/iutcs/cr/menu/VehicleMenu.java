package edu.iutcs.cr.menu;

import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.vehicles.Vehicle;
import edu.iutcs.cr.vehicles.VehicleFactory;

import java.util.Scanner;

/**
 * Handles all vehicle-related menu operations.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class VehicleMenu {

    private final SystemDatabase database;

    public VehicleMenu(SystemDatabase database) {
        this.database = database;
    }

    public void add() {
        System.out.println("\n\n\nAdd new vehicle");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the type of vehicle [1-5]: ");
        System.out.println("1. Bus");
        System.out.println("2. Car");
        System.out.println("3. Hatchback");
        System.out.println("4. Sedan");
        System.out.println("5. SUV");

        int vehicleType = -1;
        while (vehicleType < 1 || vehicleType > 5) {
            System.out.print("Enter your choice: ");
            vehicleType = scanner.nextInt();
            if (vehicleType < 1 || vehicleType > 5) {
                System.out.println("Enter a valid vehicle type!");
            }
        }

        Vehicle newItem = VehicleFactory.create(vehicleType);
        database.getVehicles().add(newItem);
        MenuHelper.promptToViewMainMenu();
    }

    public void showInventory() {
        System.out.println("\n\n\nInventory list");
        database.showInventory();
        MenuHelper.promptToViewMainMenu();
    }
}
