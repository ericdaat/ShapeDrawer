package fr.ecp.sio.shapedrawer.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import fr.ecp.sio.shapedrawer.model.Polygon;

import java.lang.reflect.Type;

/**
 * Created by Eric on 19/11/15.
 */
public class PointDeserializer implements JsonDeserializer<Polygon.Point> {

    @Override
    public Polygon.Point deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        if (jsonElement.isJsonObject()){
            int x = jsonElement.getAsJsonObject().get("x").getAsInt();
            int y = jsonElement.getAsJsonObject().get("y").getAsInt();
            return new Polygon.Point(x,y);

        } else if (jsonElement.isJsonArray()){
            int x = jsonElement.getAsJsonArray().get(0).getAsInt();
            int y = jsonElement.getAsJsonArray().get(1).getAsInt();
            return new Polygon.Point(x,y);
        } else {
            return null;
        }
    }
}
