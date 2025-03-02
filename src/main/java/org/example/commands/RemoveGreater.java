package org.example.commands;

import org.example.system.CollectionManager;

public class RemoveGreater extends Command {
    public RemoveGreater() {
        super("remove_greater");
    }

    @Override
    public void execute(String[] args) {
        CollectionManager.getCollection().forEach((h, dragon) -> {
            if (dragon.getWeight() > Integer.parseInt(args[0])) {
                CollectionManager.getCollection().remove(h);
            }
        });
    }

    @Override
    public String getDescription() {
        return "this command deletes all items from the collection that exceed the specified value.";
    }
}

