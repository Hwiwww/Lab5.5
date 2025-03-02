package org.example.commands;

import org.example.data.Dragon;
import org.example.system.CollectionManager;
import org.example.system.DragonGenerator;

public class Insert extends Command {
    public Insert(){
        super("insert");
    }

    @Override
    public void execute(String[] args) {
        DragonGenerator dragonGenerator = new DragonGenerator();
        Object dragon = dragonGenerator.createDragon();
        CollectionManager.add((Dragon) dragon);
        System.out.println("Element was added to collection");
    }

    @Override
    public String getDescription() {
        return "this command adds a new element with the given key.";
    }
}

