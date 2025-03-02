package org.example.commands;

import org.example.data.Dragon;

import java.util.Hashtable;

import static org.example.system.CollectionManager.hashTable;

public class Show extends Command {
    public Show() {
        super("show");
    }

    @Override
    public void execute(String[] args) {
        Hashtable<Long, Dragon> dragons = hashTable;
        hashTable.forEach((k, v) -> System.out.println(v.toString()));
    }

    @Override
    public String getDescription() {
        return "shows the elements of a collection.";
    }
}
