package edu.iutcs.cr.controller;

import edu.iutcs.cr.ShoppingCart;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles the shopping cart menu loop.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class CartController {

    private final ShoppingCart cart;
    private final Map<Integer, Command> commands;
    private final InvoiceController invoiceController;

    public CartController(InvoiceController invoiceController) {
        this.cart = new ShoppingCart();
        this.invoiceController = invoiceController;
        this.commands = new HashMap<>();
        commands.put(1, cart::addItem);
        commands.put(2, cart::removeItem);
        commands.put(3, cart::viewCart);
    }

    public void run() {
        while (true) {
            showCartMenu();

            int selectedOperation = InputReader.getInstance().nextInt();

            while (selectedOperation < 1 || selectedOperation > 5) {
                System.out.print("Please select a valid operation: ");
                selectedOperation = InputReader.getInstance().nextInt();
            }

            if (selectedOperation == 4) {
                invoiceController.createInvoice(cart);
                return;
            }

            if (selectedOperation == 5) {
                return;
            }

            Command cmd = commands.get(selectedOperation);
            if (cmd != null) {
                cmd.execute();
            }
        }
    }

    private void showCartMenu() {
        System.out.println("Please enter the type of operation: [1-5]");
        System.out.println("1. Add new vehicle to cart");
        System.out.println("2. Remove vehicle from cart");
        System.out.println("3. View cart");
        System.out.println("4. Confirm purchase");
        System.out.println();
        System.out.println("5. Return to main menu");
    }

}
