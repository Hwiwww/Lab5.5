package org.example.commands;

import org.example.data.Dragon;
import org.example.system.CollectionManager;
import org.example.system.Console;
import org.example.system.DragonGenerator;

public class UpdateId extends Command {
    public UpdateId() {
        super("update_id");
    }

    @Override
    public void execute(String[] args) {
        long id = Long.parseLong(args[0]);
        boolean isInCollection = false;
        for (Long key : CollectionManager.getCollection().keySet()) {
            if (CollectionManager.getCollection().get(key).getID() == id) {
                isInCollection = true;
                System.out.println("Updating element with id:" + id);
                DragonGenerator dragonGenerator = new DragonGenerator();
                Dragon newDragon = dragonGenerator.createDragon(id);

                CollectionManager.getCollection().remove(key);
                CollectionManager.getCollection().put(key, newDragon);
                System.out.println("Element with id: " + id + "was updated.");
            }
        }
        if (!isInCollection) {
            System.out.println("Element with this id doesn't exist, try again!");
        }
    }

    @Override
    public String getDescription() {
        return "this command updates the value of a collection item using id.";
    }
}
