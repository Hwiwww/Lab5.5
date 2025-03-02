package org.example.system;

public class FileManager {
    public static void readFile() {
        CollectionManager.getCollection().putAll(JsonReader.read());
    }

    public static void saveToFile() {
        JsonWriter.write();
    }
}
