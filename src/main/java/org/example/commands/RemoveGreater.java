package org.example.commands;

import org.example.system.CollectionManager;
import org.example.system.Environment;

public class RemoveGreater extends Command {
    public RemoveGreater() {
        super("remove_greater");
    }

    @Override
    public void execute(String[] args) {
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("Error: No argument provided. Please specify a weight value.");
            }
            CollectionManager manager = Environment.getInstance().getCollectionManager();
            manager.getCollection().forEach((h, dragon) -> {
                if (dragon.getWeight() > Integer.parseInt(args[0])) {
                    manager.getCollection().remove(h);
                }
            });
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid argument. Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "this command deletes all items from the collection that exceed the specified value.";
    }
}

