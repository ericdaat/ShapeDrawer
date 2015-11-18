package fr.ecp.sio.shapedrawer.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric on 18/11/15.
 */
public class Polygon extends Shape {

    private List<Point> points;

    public Polygon(int x, int y, List<Point> points) {
        super(x, y);
        this.points = points;
    }

    public Polygon(JsonObject conf) {
        super(conf);
        points = new ArrayList<>();
        for (JsonElement pointConf : conf.get("points").getAsJsonArray()){
            Point point;
            if (pointConf.isJsonArray()){
                point = new Point(pointConf.getAsJsonArray());
            } else {
                throw new IllegalStateException("Invalid point configuration");
            }
            points.add(point);
        }
    }

    @Override
    public double getArea() {
        int x_min = Integer.MAX_VALUE;
        int y_min = Integer.MAX_VALUE;
        int x_max = Integer.MIN_VALUE;
        int y_max = Integer.MIN_VALUE;

        for (Point p : points){
            x_max = Math.max(x_max,p.x);
            y_max = Math.max(y_max,p.x);
            x_min = Math.min(x_min,p.y);
            y_min = Math.min(y_min,p.y);
        }
        return (x_max - x_min)*(y_max-y_min);
    }

    @Override
    protected void doDraw(Graphics g) {
        Point start = points.get(points.size() - 1);
        for (Point end : points){
            g.drawLine(
                    start.x + getX(),
                    start.y + getY(),
                    end.x + getX(),
                    end.y +getY()
            );
            start = end;
        }
    }

    public static class Point {

        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(JsonObject conf) {
            this.x = conf.get("x").getAsInt();
            this.y = conf.get("y").getAsInt();
        }

        public Point(JsonArray conf) {
            this.x = conf.get(0).getAsInt();
            this.y = conf.get(1).getAsInt();
        }

    }
}


