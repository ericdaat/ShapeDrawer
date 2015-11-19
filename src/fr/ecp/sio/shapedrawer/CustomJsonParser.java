package fr.ecp.sio.shapedrawer;

import com.google.gson.JsonObject;

import java.lang.reflect.Constructor;

/**
 * Created by Eric on 19/11/15.
 */
public class CustomJsonParser {

    public static <T> T parse(JsonObject config, Class<T> objectClass) throws ReflectiveOperationException{
        Constructor<T> constructor = objectClass.getConstructor(JsonObject.class);
        return constructor.newInstance(config);
    }

}
