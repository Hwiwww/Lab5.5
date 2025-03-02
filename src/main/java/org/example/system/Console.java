package org.example.system;

import org.example.commands.Command;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import static org.example.system.CommandManager.commandList;

public class Console {
    private static Console console;
    Scanner scanner;

    public static Console getInstance() {
        if(console == null){
            console = new Console();
        }
        return console;
    }


    public Scanner getScanner() {
        return scanner;
    }


    // private final Scanner scanner;

//    public Console(Scanner scanner) {
//        this.scanner = scanner;
//    }

    public void start(InputStream input, String[] args) {
        scanner = new Scanner(input);
        CommandManager commandManager = new CommandManager();
        CollectionManager collectionManager = new CollectionManager();
        FileManager fileManager = new FileManager();
        // DataReader reader = new DataReader();
        String path = args[0];

        try {
            System.out.println("Downloading data from file...");
            commandManager.getCommandList().get("read").execute(args);
            // data_path = args[0];
            // System.out.println(TextColor.ANSI_BLUE + "Everything is OK." + TextColor.ANSI_RESET);
        } catch (Exception e) {
            System.out.println("");
        }

        System.out.println("Welcome to app!");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] commandArgs = line.split(" ");
            if (commandArgs.length >= 1) {
                String commandLine = commandArgs[0];
                String[] arguments = Arrays.copyOfRange(commandArgs, 1, commandArgs.length);
                if (commandList.containsKey(commandLine)) { // либо через keySet().contains
                    Command command = commandList.get(commandLine);
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
