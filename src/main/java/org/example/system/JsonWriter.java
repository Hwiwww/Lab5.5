package org.example.system;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.data.Coordinates;
import org.example.data.Dragon;
import org.example.data.DragonCave;
import org.example.data.DragonType;
import org.example.system.serializers.*;



import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class JsonWriter {
    public static void write() {
          // String fileName = "./dragons.json";
        String fileName = System.getenv("MY_FILE_PATH");

        if (fileName == null) {
            System.out.println("Ошибка: Переменная окружения MY_FILE_PATH не задана!");
        }

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Dragon.class, new DragonSerializer())
                .registerTypeAdapter(Coordinates.class, new CoordinatesSerializer())
                .registerTypeAdapter(DragonCave.class, new DragonCaveSerializer())
                .registerTypeAdapter(DragonType.class, new DragonTypeSerializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateTimeSerializer())
                .create();

        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(Environment.getInstance().getCollectionManager().getCollection().values(), writer);
        } catch (IOException e) {
            System.err.println("Something went wrong while writing collection to file.");
        }
    }
}

