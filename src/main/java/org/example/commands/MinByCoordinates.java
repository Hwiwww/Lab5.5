package org.example.commands;

import org.example.data.Dragon;
import org.example.system.CollectionManager;

import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;

public class MinByCoordinates extends Command {
    public MinByCoordinates() {
        super("min_by_coordinates");
    }

    @Override
    public void execute(String[] args) {
        System.out.println(minByCoordinates().toString());
    }

    public Dragon minByCoordinates() {
        if (CollectionManager.getCollection().isEmpty()) {
            return null;
        } else {
            Comparator<Dragon> dragonComparator = Comparator
                    .comparing((Dragon d) -> d.getCoordinates().getX())
                    .thenComparing(d -> d.getCoordinates().getY());
            Dragon min = Collections.min(CollectionManager.getCollection().values(), dragonComparator);
            return min;
        }
    }

    @Override
    public String getDescription() {
        return "outputs element from collection which coordinates is min";
    }
}
