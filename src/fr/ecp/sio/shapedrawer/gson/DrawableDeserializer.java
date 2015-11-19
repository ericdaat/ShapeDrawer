package fr.ecp.sio.shapedrawer.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import fr.ecp.sio.shapedrawer.model.Circle;
import fr.ecp.sio.shapedrawer.model.Drawable;
import fr.ecp.sio.shapedrawer.model.Polygon;
import fr.ecp.sio.shapedrawer.model.Rectangle;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eric on 19/11/15.
 */
public class DrawableDeserializer implements JsonDeserializer<Drawable> {


    private static final Map<String, Class<? extends Drawable>> SHAPE_CLASSES = new HashMap<>();
    static {
        SHAPE_CLASSES.put("circle", Circle.class);
        SHAPE_CLASSES.put("rectangle", Rectangle.class);
        SHAPE_CLASSES.put("polygon", Polygon.class);
    }

    @Override
    public Drawable deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {

        String key = jsonElement.getAsJsonObject().get("type").getAsString();

        Class <? extends Drawable> drawableType = SHAPE_CLASSES.get(key);

        if (drawableType != null){
            return context.deserialize(jsonElement,drawableType);
        } else {
            return null;
        }
    }
}
