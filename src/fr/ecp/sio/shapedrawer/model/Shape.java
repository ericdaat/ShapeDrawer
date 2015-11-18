package fr.ecp.sio.shapedrawer.model;

import com.google.gson.JsonObject;
import fr.ecp.sio.shapedrawer.InvalidMetricsException;

import java.awt.*;

/**
 * Created by Eric on 18/11/15.
 */
public abstract class Shape implements Drawable {

    private int x,y;
    private Color color;

    public Shape (int x,int y){
        this.x = x;
        this.y = y;
    }

    public Shape (JsonObject conf){
        this.x = conf.get("x").getAsInt();
        this.y = conf.get("y").getAsInt();
        if (conf.has("color")){
            this.color = Color.decode(conf.get("color").getAsString());
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /*
    Overriding the equals method because it would only tell if two instances
    are the same, meaning they have the same address in memory.
    Here, the method returns true if two shapes have same  x,y coordinates.
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Shape){
            Shape shape = (Shape) obj;

            return shape.x == x && shape.y == y;
        } else {
            return false;
        }
    }

    /*
    This method will have to be implemented by subclasses because
    different shapes have different ways to calculate their areas.
     */
    public abstract double getArea();

    @Override
    public final void draw(Graphics g) throws InvalidMetricsException {
        if (getArea() == 0){
            throw new InvalidMetricsException();
        } else {
            if (color != null){
                g.setColor(color);
            } else {
                g.setColor(Color.WHITE);
            }
            doDraw(g);
        }
    }

    protected abstract void doDraw(Graphics g);

}
