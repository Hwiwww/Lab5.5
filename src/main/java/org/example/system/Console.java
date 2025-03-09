package org.example.system;

import org.example.commands.Command;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Console {
    private Scanner scanner;



    public void start(InputStream input, String[] args) {
        scanner = new Scanner(input);
        CommandManager commandManager = Environment.getInstance().getCommandManager();

        try {
            System.out.println("Downloading data from file...");
            commandManager.getCommandList().get("read").execute(args);
            // data_path = args[0];
            // System.out.println(TextColor.ANSI_BLUE + "Everything is OK." + TextColor.ANSI_RESET);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Welcome to app!");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] commandArgs = line.split(" ");
            if (commandArgs.length >= 1) {
                String commandLine = commandArgs[0];
                String[] arguments = Arrays.copyOfRange(commandArgs, 1, commandArgs.length);
                if (commandManager.getCommandList().containsKey(commandLine)) { // либо через keySet().contains
                    Command command = commandManager.getCommandList().get(commandLine);
                    try {
                        command.execute(arguments);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Something wrong with command arguments");
                    }
                } else {
                    System.err.println("Unknown command: " + line);
                }
            }

        }
    }

}
