//ID: 208461228

package levels.firstlevel;

import biuoop.DrawSurface;
import differentsprites.Sprite;

import java.awt.Color;

/**
 * A class of the first level background.
 */
public class FirstLevelBackground implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        //background
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, 800, 600);
        //circles amd lines
        d.setColor(Color.BLUE);
        d.drawCircle(400, 140, 50);
        d.drawCircle(400, 140, 90);
        d.drawCircle(400, 140, 120);
        d.drawLine(400, 0, 400, 280);
        d.drawLine(260, 140, 540, 140);
    }

    @Override
    public void timePassed() {
    }
}
