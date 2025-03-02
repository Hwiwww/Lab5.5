package org.example.system.serializers;

import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.example.data.DragonCave;

import java.lang.reflect.Type;

public class DragonCaveSerializer implements JsonSerializer<DragonCave> {
    @Override
    public JsonObject serialize(DragonCave src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();

        result.addProperty("dragonCaveDepth", src.getDepth());
        result.addProperty("dragonCaveNumberOfTreasures", src.getNumberOfTreasures());

        return result;
    }
}