package org.example.commands;

import org.example.system.FileManager;

public class Save extends Command {
    public Save() {
        super("save");
    }

    @Override
    public void execute(String[] args) {
        FileManager.saveToFile();
    }

    @Override
    public String getDescription() {
        return "";
    }
}
