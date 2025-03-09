package org.example.commands;

import org.example.data.Dragon;
import org.example.system.Environment;

import java.util.Hashtable;



public class Show extends Command {
    public Show() {
        super("show");
    }

    @Override
    public void execute(String[] args) {
        Hashtable<Long, Dragon> dragons = Environment.getInstance().getCollectionManager().getCollection();
        dragons.forEach((k, v) -> System.out.println(v.toString()));
    }

    @Override
    public String getDescription() {
        return "shows the elements of a collection.";
    }
}
