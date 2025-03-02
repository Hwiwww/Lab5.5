package org.example.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

import static org.example.system.CommandManager.commandList;

public class ExecuteScript extends Command {
    private static Deque<File> scriptsStack = new ArrayDeque<>();

    public ExecuteScript() {
        super("execute_script");
    }

    @Override
    public void execute(String[] args) {
        File file = new File(args[0]);

        if (scriptsStack.contains(file)) {
            System.out.println("Recursion detected");
        }

        try {
            Scanner scanner = new Scanner(file);
            scriptsStack.add(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] commandArguments = line.split(" ");
                String lineCommand = commandArguments[0];
                String[] arguments = Arrays.copyOfRange(commandArguments, 1, commandArguments.length);

                if (commandList.containsKey(lineCommand)) { // либо через keySet().contains
                    Command command = commandList.get(lineCommand);
                    command.execute(arguments);
                } else {
                    System.err.println("Unknown command: " + lineCommand);
                }
            }
            scriptsStack.removeLast();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find the script file");
        }
    }

    @Override
    public String getDescription() {
        return "executes script from file; file example: \"script.txt\"";
    }
}