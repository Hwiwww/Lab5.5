package org.example.commands;

import org.example.system.Environment;
import org.example.system.FileManager;

public class Read extends Command {
    public Read() {
        super("read");
    }

    @Override
    public void execute(String[] args) {
        Environment.getInstance().getFileManager().readFile();
        System.out.println("Collection was successfully read from file");
    }

    @Override
    public String getDescription() {
        return "reads data about collection from file";
    }
}

