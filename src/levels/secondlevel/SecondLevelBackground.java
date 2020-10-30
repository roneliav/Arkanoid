//ID: 208461228

package levels.secondlevel;

import biuoop.DrawSurface;
import differentsprites.Sprite;

import java.awt.Color;

/**
 * A class of the second level background.
 */
public class SecondLevelBackground implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        //background
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 600);
        //sun and sun rays
        d.setColor(Color.YELLOW);
        d.fillCircle(140, 140, 50);
        for (int i = 1; i < 6; i++) {
            d.drawCircle(140, 140, 50 + 2 * i);
        }
        for (int i = 0; i < 100; i++) {
           d.drawLine(140, 140, i * 8, 250);
        }
    }

    @Override
    public void timePassed() {

    }
}
