package org.example.system.serializers;

import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.example.data.DragonType;

import java.lang.reflect.Type;

public class DragonTypeSerializer implements JsonSerializer<DragonType> {
    @Override
    public JsonPrimitive serialize(DragonType src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.name());
    }
}

