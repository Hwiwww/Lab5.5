package org.example.commands;

import org.example.system.CollectionManager;
import org.example.system.Environment;

public class SumOfAge extends Command {
    private long sumOfAges;

    public SumOfAge() {
        super("sumOfAge");
    }

    @Override
    public void execute(String[] args) {
        System.out.println("sum of ages for all items in the collection: " + getSumOfAges());
    }

    private long getSumOfAges() {
        Environment.getInstance().getCollectionManager().getCollection().forEach((s, dragon) -> {
            sumOfAges = sumOfAges + dragon.getAge();
        });
        return sumOfAges;
    }

    @Override
    public String getDescription() {
        return "outputs the sum of age field values for all items in the collection";
    }
}