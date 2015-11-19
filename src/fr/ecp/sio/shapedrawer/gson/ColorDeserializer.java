package fr.ecp.sio.shapedrawer.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.awt.*;
import java.lang.reflect.Type;

/**
 * Created by Eric on 19/11/15.
 */
public class ColorDeserializer implements JsonDeserializer<Color> {
    @Override
    public Color deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        return Color.decode(jsonElement.getAsString());
    }
}
