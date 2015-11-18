package fr.ecp.sio.shapedrawer.model;

import fr.ecp.sio.shapedrawer.InvalidMetricsException;

import java.awt.*;

/**
 * Created by Eric on 18/11/15.
 */
public interface Drawable {

    void draw(Graphics g) throws InvalidMetricsException;
}
