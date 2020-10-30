//ID: 208461228
package levels.forthlevel;

import biuoop.DrawSurface;
import differentsprites.Sprite;

import java.awt.Color;

/**
 * A class of the forth level background.
 */
public class ForthLevelBackground implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        //background
        d.setColor(Color.BLUE);
        d.fillRectangle(0, 0, 800, 600);
        //lines from clouds
        d.setColor(Color.WHITE);
        for (int i = 0; i < 9; i++) {
            d.drawLine(140 + i * 8, 350, 120 + i * 8, 600);
        }
        for (int i = 0; i < 9; i++) {
            d.drawLine(610 + i * 8, 490, 570 + i * 8, 600);
        }
        //left clouds
        d.setColor(Color.LIGHT_GRAY);
        d.fillCircle(140, 350, 20);
        d.fillCircle(155, 375, 25);
        d.setColor(Color.GRAY);
        d.fillCircle(170, 340, 25);
        d.setColor(Color.DARK_GRAY);
        d.fillCircle(185, 375, 15);
        d.fillCircle(195, 350, 25);
        //right clouds
        d.setColor(Color.LIGHT_GRAY);
        d.fillCircle(600, 480, 20);
        d.fillCircle(620, 515, 25);
        d.setColor(Color.GRAY);
        d.fillCircle(640, 490, 25);
        d.setColor(Color.DARK_GRAY);
        d.fillCircle(650, 515, 15);
        d.fillCircle(665, 500, 25);




    }

    @Override
    public void timePassed() {

    }
}
