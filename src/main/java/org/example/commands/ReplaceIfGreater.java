package org.example.commands;

import org.example.data.Dragon;
import org.example.system.CollectionManager;
import org.example.system.DragonGenerator;

public class ReplaceIfGreater extends Command{
    public ReplaceIfGreater(){
        super("replace_if_greater");
    }

    @Override
    public void execute(String[] args) {
        String key = args[0];
        if (CollectionManager.getCollection().contains(key)) {
            DragonGenerator dragonGenerator = new DragonGenerator();
            Dragon dragon = new Dragon();
            dragon.setAge(dragonGenerator.readAge());
            if (CollectionManager.getCollection().get(key).compareTo(dragon) == 1) {
                dragon = dragonGenerator.createDragon();
                CollectionManager.getCollection().remove(key);
                CollectionManager.add(dragon);
            } else {
                System.out.println("New dragon's age is less. Try again!");
            }
        }
    }

    @Override
    public String getDescription() {
        return "updates element by key if new bigger than element in collection with the same key";
    }
}
