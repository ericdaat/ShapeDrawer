package fr.ecp.sio.shapedrawer.ui;

import fr.ecp.sio.shapedrawer.InvalidMetricsException;
import fr.ecp.sio.shapedrawer.model.Drawable;

import javax.swing.*;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Eric on 19/11/15.
 */
public class DrawablesPanel extends JPanel{

    private Iterable<Drawable> drawables;
    private static final Logger LOG = Logger.getLogger(DrawablesPanel.class.getSimpleName());

    public DrawablesPanel(Iterable<Drawable> drawables){
        this.drawables = drawables;
    }

    public void setDrawables(Iterable<Drawable> drawables){
        if (this.drawables == null && drawables != null){
            LOG.info("First non-null Drawable List added to our Panel");
            this.drawables = drawables;
            repaint();
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        if (this.drawables == null) return;

        for (Drawable drawable : this.drawables){
            try {
                drawable.draw(g);
            } catch (InvalidMetricsException e) {
                LOG.info("Shape with no area");
            } catch (Exception e){
                LOG.log(
                        Level.SEVERE,
                        "Failed to draw Shape",
                        e
                );
            }
        }
    }


}
