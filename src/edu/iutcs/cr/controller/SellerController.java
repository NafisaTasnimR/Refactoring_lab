package edu.iutcs.cr.controller;

import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.system.SystemDatabase;

/**
 * Handles all seller-related menu operations.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class SellerController {

    private final SystemDatabase database;

    public SellerController(SystemDatabase database) {
        this.database = database;
    }

    public void add() {
        System.out.println("\n\n\nAdd new seller");
        database.getSellers().add(new Seller());
        ConsoleHelper.promptToViewMainMenu();
    }

    public void showList() {
        System.out.println("\n\n\nSeller's list");
        database.showSellerList();
        ConsoleHelper.promptToViewMainMenu();
    }

    public Seller promptAndFind() {
        Seller seller = null;
        do {
            System.out.print("Enter seller id: ");
            String sellerId = InputReader.getInstance().nextLine();
            seller = database.findSellerById(sellerId);
            if (seller == null) {
                System.out.println("Seller not found. Try again!");
            }
        } while (seller == null);
        return seller;
    }
}
