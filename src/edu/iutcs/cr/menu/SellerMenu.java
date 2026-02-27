package edu.iutcs.cr.menu;

import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.system.SystemDatabase;

import java.util.Scanner;

/**
 * Handles all seller-related menu operations.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class SellerMenu {

    private final SystemDatabase database;

    public SellerMenu(SystemDatabase database) {
        this.database = database;
    }

    public void add() {
        System.out.println("\n\n\nAdd new seller");
        database.getSellers().add(new Seller());
        MenuHelper.promptToViewMainMenu();
    }

    public void showList() {
        System.out.println("\n\n\nSeller's list");
        database.showSellerList();
        MenuHelper.promptToViewMainMenu();
    }

    public Seller promptAndFind() {
        Scanner scanner = new Scanner(System.in);
        Seller seller = null;
        do {
            System.out.print("Enter seller id: ");
            String sellerId = scanner.nextLine();
            seller = database.findSellerById(sellerId);
            if (seller == null) {
                System.out.println("Seller not found. Try again!");
            }
        } while (seller == null);
        return seller;
    }
}
