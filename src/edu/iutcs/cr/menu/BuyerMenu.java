package edu.iutcs.cr.menu;

import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.system.SystemDatabase;

import java.util.Scanner;

/**
 * Handles all buyer-related menu operations.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class BuyerMenu {

    private final SystemDatabase database;

    public BuyerMenu(SystemDatabase database) {
        this.database = database;
    }

    public void add() {
        System.out.println("\n\n\nAdd new customer");
        database.getBuyers().add(new Buyer());
        MenuHelper.promptToViewMainMenu();
    }

    public void showList() {
        System.out.println("\n\n\nCustomer's list");
        database.showBuyerList();
        MenuHelper.promptToViewMainMenu();
    }

    public Buyer promptAndFind() {
        Scanner scanner = new Scanner(System.in);
        Buyer buyer = null;
        do {
            System.out.print("Enter buyer id: ");
            String buyerId = scanner.nextLine();
            buyer = database.findBuyerById(buyerId);
            if (buyer == null) {
                System.out.println("Buyer not found. Try again!");
            }
        } while (buyer == null);
        return buyer;
    }
}
