//ID: 208461228
package levels.ThirdLevel;

import biuoop.DrawSurface;
import differentsprites.Sprite;

import java.awt.Color;

/**
 * A class of the third level background.
 */
public class ThirdLevelBackground implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        //background
        d.setColor(Color.GREEN);
        d.fillRectangle(0, 0, 800, 600);
        //a tower
        d.setColor(Color.BLACK);
        d.fillRectangle(80, 450, 100, 150);
        //windows of the tower
        d.setColor(Color.WHITE);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(85 + i * 19, 455 + j * 32, 14, 25);
            }
        }
        //the mast of the tower
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(115, 400, 30, 50);
        d.setColor(Color.GRAY);
        d.fillRectangle(125, 150, 10, 250);
        //light on the tower
        d.setColor(Color.ORANGE);
        d.fillCircle(130, 150, 10);
        d.setColor(Color.RED);
        d.fillCircle(130, 150, 7);
        d.setColor(Color.WHITE);
        d.fillCircle(130, 150, 3);
    }

    @Override
    public void timePassed() {

    }

}
