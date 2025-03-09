package org.example.commands;

import org.example.system.CollectionManager;
import org.example.system.Environment;

public class Clear extends Command {
    public Clear() {
        super("clear");
    }

    @Override
    public void execute(String[] args) {
        Environment.getInstance().getCollectionManager().getCollection().clear();
        System.out.println("Collection is cleared.");
    }

    @Override
    public String getDescription() {
        return "clears the collection";
    }
}
