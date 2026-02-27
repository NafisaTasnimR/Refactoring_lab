package edu.iutcs.cr.menu;

import java.util.Scanner;

/**
 * Shared UI utility for menu navigation.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class MenuHelper {

    public static void promptToViewMainMenu() {
        System.out.print("\n\nEnter 0 to view main menu: ");
        Scanner scanner = new Scanner(System.in);
        int val = -1;
        do {
            val = scanner.nextInt();
        } while (val != 0);
    }

    public static String readMandatoryLine(Scanner scanner, String fieldName) {
        String value = null;
        while (value == null || value.isBlank()) {
            System.out.print("Enter " + fieldName + ": ");
            value = scanner.nextLine();
            if (value == null || value.isBlank()) {
                System.out.println(fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1) + " is mandatory!");
            }
        }
        return value;
    }

    private MenuHelper() {
    }
}
