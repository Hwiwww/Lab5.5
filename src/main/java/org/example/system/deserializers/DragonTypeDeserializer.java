package org.example.system.deserializers;

import com.google.gson.*;
import org.example.data.DragonType;

import java.lang.reflect.Type;

public class DragonTypeDeserializer implements JsonDeserializer<DragonType> {
    @Override
    public DragonType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        String dragonTypeString = json.getAsString();
        return DragonType.valueOf(dragonTypeString);

    }
}
