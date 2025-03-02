package org.example.commands;

import org.example.system.CollectionManager;

public class Remove extends Command{
    public Remove() {
        super("remove");
    }

    @Override
    public void execute(String[] args) {
        CollectionManager.getCollection().remove(args[0]);
        System.out.println("you have removed an item from the collection.");
    }

    @Override
    public String getDescription() {
        return "this command removes an item from a collection by its key.";
    }
}