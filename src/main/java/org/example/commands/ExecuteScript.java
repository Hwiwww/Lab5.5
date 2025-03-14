package org.example.commands;

import org.example.system.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

import static org.example.system.CommandManager.commandList;

public class ExecuteScript extends Command {
    private static Deque<String> scriptsStack = new ArrayDeque<>();

    public ExecuteScript() {
        super("execute_script");
    }

    @Override
    public void execute(String[] args) {
        File file = new File(args[0]);
        String filePath = file.getAbsolutePath();

        if (scriptsStack.contains(filePath)) {
            System.out.println("Recursion detected");
            return;
        }

        try {
            Scanner scanner = new Scanner(file);
            scriptsStack.add(filePath);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] commandArguments = line.split(" ");
                String lineCommand = commandArguments[0];
                String[] arguments = Arrays.copyOfRange(commandArguments, 1, commandArguments.length);

                if (Environment.getInstance().getCommandManager().getCommandList().containsKey(lineCommand)) { // либо через keySet().contains
                    Command command = Environment.getInstance().getCommandManager().getCommandList().get(lineCommand);
                    command.execute(arguments);
                } else {
                    System.err.println("Unknown command: " + lineCommand);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find the script file");
        } finally {
            scriptsStack.remove(filePath); // Убираем файл из стека после выполнения
        }
    }

    @Override
    public String getDescription() {
        return "executes script from file; file example: \"script.txt\"";
    }
}