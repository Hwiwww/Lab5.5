package org.example.commands;

import org.example.system.CollectionManager;

public class SumOfAge extends Command {
    public static long sumOfAges;

    public SumOfAge() {
        super("sumOfAge");
    }

    @Override
    public void execute(String[] args) {
        System.out.println("sum of ages for all items in the collection: " + getSumOfAges());
    }

    public static long getSumOfAges() {
        CollectionManager.getCollection().forEach((s, dragon) -> {
            sumOfAges = sumOfAges + dragon.getAge();
        });
        return sumOfAges;
    }

    @Override
    public String getDescription() {
        return "outputs the sum of age field values for all items in the collection";
    }
}