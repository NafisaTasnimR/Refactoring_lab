package edu.iutcs.cr.controller;

import edu.iutcs.cr.Invoice;
import edu.iutcs.cr.ShoppingCart;
import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.system.SystemDatabase;

/**
 * Handles all invoice-related menu operations.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class InvoiceController {

    private final SystemDatabase database;
    private final BuyerController buyerController;
    private final SellerController sellerController;

    public InvoiceController(SystemDatabase database, BuyerController buyerController,
            SellerController sellerController) {
        this.database = database;
        this.buyerController = buyerController;
        this.sellerController = sellerController;
    }

    public void showInvoices() {
        System.out.println("\n\n\nInvoice list");
        database.showInvoices();
        ConsoleHelper.promptToViewMainMenu();
    }

    public void createInvoice(ShoppingCart cart) {
        Buyer buyer = buyerController.promptAndFind();
        Seller seller = sellerController.promptAndFind();
        System.out.print("Is payment done (true/false): ");
        boolean isPaid = InputReader.getInstance().nextBoolean();
        Invoice invoice = new Invoice(buyer, seller, cart, isPaid);
        invoice.printInvoice();
        database.getInvoices().add(invoice);
    }
}
