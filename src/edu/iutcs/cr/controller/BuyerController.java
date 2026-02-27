package edu.iutcs.cr.controller;

import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.system.SystemDatabase;

/**
 * Handles all buyer-related menu operations.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class BuyerController {

    private final SystemDatabase database;

    public BuyerController(SystemDatabase database) {
        this.database = database;
    }

    public void add() {
        System.out.println("\n\n\nAdd new customer");
        database.getBuyers().add(new Buyer());
        ConsoleHelper.promptToViewMainMenu();
    }

    public void showList() {
        System.out.println("\n\n\nCustomer's list");
        database.showBuyerList();
        ConsoleHelper.promptToViewMainMenu();
    }

    public Buyer promptAndFind() {
        Buyer buyer = null;
        do {
            System.out.print("Enter buyer id: ");
            String buyerId = InputReader.getInstance().nextLine();
            buyer = database.findBuyerById(buyerId);
            if (buyer == null) {
                System.out.println("Buyer not found. Try again!");
            }
        } while (buyer == null);
        return buyer;
    }
}
