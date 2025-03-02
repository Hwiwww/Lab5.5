package org.example.commands;

import org.example.system.CollectionManager;

public class RemoveLower extends Command {
    public RemoveLower() {
        super("remove_lower");
    }

    @Override
    public void execute(String[] args) {
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("Error: No argument provided. Please specify a weight value.");
            }
            CollectionManager.getCollection().forEach((w, dragon) -> {
                if (dragon.getWeight() < Integer.parseInt(args[0])) {
                    CollectionManager.getCollection().remove(w);
                }
            });
        }catch (NumberFormatException e) {
            System.out.println("Error: Invalid argument. Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "this command removes all items smaller than the specified one from the collection.";
    }
}