package edu.iutcs.cr.controller;

import edu.iutcs.cr.system.SystemDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory responsible for constructing all domain menus and registering
 * their commands against numeric operation codes.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class ControllerFactory {

    public static Map<Integer, Command> buildCommands(SystemDatabase database) {
        SellerController sellerController = new SellerController(database);
        BuyerController buyerController = new BuyerController(database);
        VehicleController vehicleController = new VehicleController(database);
        InvoiceController invoiceController = new InvoiceController(database, buyerController, sellerController);

        Map<Integer, Command> commands = new HashMap<>();
        commands.put(1, sellerController::add);
        commands.put(2, buyerController::add);
        commands.put(3, vehicleController::add);
        commands.put(4, vehicleController::showInventory);
        commands.put(5, sellerController::showList);
        commands.put(6, buyerController::showList);
        commands.put(7, () -> new CartController(invoiceController).run());
        commands.put(8, invoiceController::showInvoices);
        return commands;
    }

    private ControllerFactory() {
    }
}
