package org.example.system;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.data.Coordinates;
import org.example.data.Dragon;
import org.example.data.DragonCave;
import org.example.data.DragonType;
import org.example.system.deserializers.*;
import org.example.system.serializers.*;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Hashtable;
import java.util.List;



public class FileManager {
    public static void readFile() {
        Environment.getInstance().getCollectionManager().getCollection().putAll(jsonReader());
    }

    private static Hashtable<Long, Dragon> jsonReader() {
        String fileName = Environment.getInstance().getPath();
        File file = new File(fileName);
        Path path = file.toPath();

        if (fileName == null) {
            System.out.println("Ошибка: Переменная окружения MY_FILE_PATH не задана!");
        } else if (Files.notExists(path)) {
            throw new RuntimeException("");
        } else if (!Files.isRegularFile(path)) {
            throw new RuntimeException("");
        } else if (!Files.isReadable(path)) {
            throw new RuntimeException("");
        }

        Hashtable<Long, Dragon> hashtable = new Hashtable<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {

            Gson gson = new GsonBuilder().registerTypeAdapter(Dragon.class, new DragonDeserializer())
                    .registerTypeAdapter(Coordinates.class, new CoordinatesDeserializer())
                    .registerTypeAdapter(DragonType.class, new DragonTypeDeserializer())
                    .registerTypeAdapter(DragonCave.class, new DragonCaveDeserializer())
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateDeserializer())
                    .create();


            Type listType = new TypeToken<List<Dragon>>() {
            }.getType();
            List<Dragon> dragons = gson.fromJson(reader, listType);

            for (Dragon dragon : dragons) {
                hashtable.put(dragon.getID(), dragon);
            }

        } catch (IOException e) {
            System.err.println("Something wrong with reading a file");
            throw new RuntimeException("Не удалось прочитать файл JSON", e);
        }
        return hashtable;
    }

    public static void saveToFile() {
        jsonWriter();
    }


    private static void jsonWriter() {
        // String fileName = "./dragons.json";
        String fileName = Environment.getInstance().getPath();

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


