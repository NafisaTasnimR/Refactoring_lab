package edu.iutcs.cr;

import edu.iutcs.cr.controller.Command;
import edu.iutcs.cr.controller.ControllerFactory;
import edu.iutcs.cr.system.SystemDatabase;

import java.util.Map;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class SystemFlowRunner {

    private final SystemDatabase database;
    private final MainMenu mainMenu;
    private final Map<Integer, Command> commands;

    private SystemFlowRunner() {
        this.database = SystemDatabase.getInstance();
        this.mainMenu = new MainMenu();
        this.commands = ControllerFactory.buildCommands(database);
    }

    public static void run() {
        new SystemFlowRunner().start();
    }

    private void start() {
        System.out.println("Welcome to Car Hut");
        System.out.println("Loading existing system");
        System.out.println("Existing system loaded");

        while (true) {
            System.out.println("\n\n\n");
            int selectedOperation = mainMenu.showAndSelectOperation();

            if (selectedOperation == 9) {
                database.saveSystem();
                return;
            }

            Command cmd = commands.get(selectedOperation);
            if (cmd != null) {
                cmd.execute();
            }
        }
    }
}
