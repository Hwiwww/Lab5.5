package org.example.commands;

import org.example.system.CollectionManager;

public class Clear extends Commands {
    public Clear() {
        super("clear");
    }

    @Override
    public void execute(String[] args) {
        CollectionManager.getCollection().clear();
        System.out.println("Collection is cleared.");
    }

    @Override
    public String getDescription() {
        return "clears the collection";
    }
}
