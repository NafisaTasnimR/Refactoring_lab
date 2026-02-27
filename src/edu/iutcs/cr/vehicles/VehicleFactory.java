package edu.iutcs.cr.vehicles;

/**
 * Factory for creating Vehicle instances based on a type code.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class VehicleFactory {

    public static Vehicle create(int type) {
        switch (type) {
            case 1:
                System.out.println("\n\nCreate new bus");
                return new Bus();
            case 2:
                System.out.println("\n\nCreate new car");
                return new Car();
            case 3:
                System.out.println("\n\nCreate new hatchback");
                return new Hatchback();
            case 4:
                System.out.println("\n\nCreate new sedan");
                return new Sedan();
            case 5:
                System.out.println("\n\nCreate new SUV");
                return new SUV();
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}
