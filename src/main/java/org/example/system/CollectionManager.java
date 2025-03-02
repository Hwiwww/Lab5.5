package org.example.system;

import org.example.data.Dragon;

import java.time.LocalDate;
import java.util.Hashtable;

public class CollectionManager {
    public static Hashtable<Long, Dragon> hashTable;
    private static LocalDate date;


    public CollectionManager() {
        new IdGenerator();
        hashTable = new Hashtable<>();
    }

    public static Hashtable<Long, Dragon> getCollection() {
        return hashTable;
    }

    // Добавление нового дракона
    public static void add(Dragon dragon) {
        if (hashTable == null) {
            hashTable = new Hashtable<>();
        }
        hashTable.put(dragon.getID(), dragon);
    }

    public static LocalDate getInitializationDate() {
        return date;
    }
}

