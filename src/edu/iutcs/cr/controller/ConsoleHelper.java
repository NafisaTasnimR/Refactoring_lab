package edu.iutcs.cr.controller;

/**
 * Shared UI utility for menu navigation.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class ConsoleHelper {

    public static void promptToViewMainMenu() {
        System.out.print("\n\nEnter 0 to view main menu: ");
        int val = -1;
        do {
            val = InputReader.getInstance().nextInt();
        } while (val != 0);
    }

    public static String readMandatoryLine(String fieldName) {
        String value = null;
        while (value == null || value.isBlank()) {
            System.out.print("Enter " + fieldName + ": ");
            value = InputReader.getInstance().nextLine();
            if (value == null || value.isBlank()) {
                System.out.println(fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1) + " is mandatory!");
            }
        }
        return value;
    }

    private ConsoleHelper() {
    }
}
