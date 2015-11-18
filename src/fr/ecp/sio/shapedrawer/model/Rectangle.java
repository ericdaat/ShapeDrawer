package fr.ecp.sio.shapedrawer.model;

import com.google.gson.JsonObject;
import fr.ecp.sio.shapedrawer.InvalidMetricsException;

import java.awt.*;

/**
 * Created by Eric on 18/11/15.
 */
public class Rectangle extends Shape{

    private int height, width;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    public Rectangle(JsonObject conf){
        super(conf);
        this.height = conf.get("height").getAsInt();
        this.width = conf.get("width").getAsInt();
    }

    @Override
    public double getArea() {
        return height *width;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object) && object instanceof  Rectangle){
            Rectangle rect = (Rectangle) object;
            return rect.width == width && rect.height == height;
        } else {
            return false;
        }
    }

    @Override
    protected void doDraw(Graphics g) {
        g.drawRect(
                getX(),
                getY(),
                width,
                height
        );
    }

}
