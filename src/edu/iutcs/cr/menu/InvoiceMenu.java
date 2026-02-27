package edu.iutcs.cr.menu;

import edu.iutcs.cr.Invoice;
import edu.iutcs.cr.ShoppingCart;
import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.system.SystemDatabase;

import java.util.Scanner;

/**
 * Handles all invoice-related menu operations.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class InvoiceMenu {

    private final SystemDatabase database;
    private final BuyerMenu buyerMenu;
    private final SellerMenu sellerMenu;

    public InvoiceMenu(SystemDatabase database, BuyerMenu buyerMenu, SellerMenu sellerMenu) {
        this.database = database;
        this.buyerMenu = buyerMenu;
        this.sellerMenu = sellerMenu;
    }

    public void showInvoices() {
        System.out.println("\n\n\nInvoice list");
        database.showInvoices();
        MenuHelper.promptToViewMainMenu();
    }

    public void createInvoice(ShoppingCart cart) {
        Scanner scanner = new Scanner(System.in);
        Buyer buyer = buyerMenu.promptAndFind();
        Seller seller = sellerMenu.promptAndFind();
        System.out.print("Is payment done (true/false): ");
        boolean isPaid = scanner.nextBoolean();
        Invoice invoice = new Invoice(buyer, seller, cart, isPaid);
        invoice.printInvoice();
        database.getInvoices().add(invoice);
    }
}
