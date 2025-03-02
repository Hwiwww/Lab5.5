package org.example.commands;

import org.example.system.FileManager;

public class Read extends Command {
    public Read() {
        super("read");
    }

    @Override
    public void execute(String[] args) {
        FileManager.readFile();
        System.out.println("Collection was successfully read from file");
    }

    @Override
    public String getDescription() {
        return "";
    }
}

