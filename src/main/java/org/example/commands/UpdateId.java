package org.example.commands;

import org.example.data.Dragon;
import org.example.system.CollectionManager;
import org.example.system.Console;
import org.example.system.DragonGenerator;
import org.example.system.Environment;

public class UpdateId extends Command {
    public UpdateId() {
        super("update_id");
    }

    @Override
    public void execute(String[] args) {
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("Error: No argument provided. Please specify a weight value.");
            }
            long id = Long.parseLong(args[0]);
            boolean isInCollection = false;
            CollectionManager manager = Environment.getInstance().getCollectionManager();
            for (Long key : manager.getCollection().keySet()) {
                if (manager.getCollection().get(key).getID() == id) {
                    isInCollection = true;
                    System.out.println("Updating element with id:" + id);
                    DragonGenerator dragonGenerator = Environment.getInstance().getDragonGenerator();
                    Dragon newDragon = dragonGenerator.createDragon(id);

                    manager.getCollection().remove(key);
                    manager.getCollection().put(key, newDragon);
                    System.out.println("Element with id: " + id + "was updated.");
                }
            }
            if (!isInCollection) {
                System.out.println("Element with this id doesn't exist, try again!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid argument. Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "this command updates the value of a collection item using id.";
    }
}
