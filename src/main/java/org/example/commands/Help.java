package org.example.commands;

import static org.example.system.CommandManager.commandList;

// Выводит справку по доступным командам
public class Help extends Command {

    public Help() {
        super("help");
    }
    @Override
    public void execute(String[] args) {
        commandList.forEach((s, command) -> {
            System.out.println(s + ": " + command.getDescription());
        });
    }

    @Override
    public String getDescription() {
        return "show information about available commands";
    }
}

