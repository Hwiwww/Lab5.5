package org.example.commands;

import org.example.system.Environment;

import static org.example.system.CommandManager.commandList;

// Выводит справку по доступным командам
public class Help extends Command {

    public Help() {
        super("help");
    }
    @Override
    public void execute(String[] args) {
        Environment.getInstance().getCommandManager().getCommandList().forEach((s, command) -> {
            System.out.println(s + ": " + command.getDescription());
        });
    }

    @Override
    public String getDescription() {
        return "show information about available commands";
    }
}

