package edu.iutcs.cr.menu;

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
public class MenuFactory {

    public static Map<Integer, Command> buildCommands(SystemDatabase database) {
        SellerMenu sellerMenu = new SellerMenu(database);
        BuyerMenu buyerMenu = new BuyerMenu(database);
        VehicleMenu vehicleMenu = new VehicleMenu(database);
        InvoiceMenu invoiceMenu = new InvoiceMenu(database, buyerMenu, sellerMenu);

        Map<Integer, Command> commands = new HashMap<>();
        commands.put(1, sellerMenu::add);
        commands.put(2, buyerMenu::add);
        commands.put(3, vehicleMenu::add);
        commands.put(4, vehicleMenu::showInventory);
        commands.put(5, sellerMenu::showList);
        commands.put(6, buyerMenu::showList);
        commands.put(7, () -> new CartMenu(invoiceMenu).run());
        commands.put(8, invoiceMenu::showInvoices);
        return commands;
    }

    private MenuFactory() {
    }
}
