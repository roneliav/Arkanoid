//ID: 208461228
package specialscreens;

import biuoop.DrawSurface;
import makegame.Animation;

import java.awt.Color;

/**
 * A class o game over screen. (for loosers).
 */
public class GameOverScreen implements Animation {
    private Integer score;

    /**
     * A constructor.
     *
     * @param sc integer. the score
     */
   public GameOverScreen(Integer sc) {
       this.score = sc;
   }

    @Override
    public void doOneFrame(DrawSurface d) {
       //write 'game over' and the score
        String firsLine = "Game Over!";
        String secondLine = "Your score is " + score.toString();
        String thirdLine = "Try another game!";
        String downLine = "Press space for closing";
        //draw 3 times the fire line
        d.setColor(Color.BLACK);
        d.drawText(300, 150, firsLine, 40);
        d.setColor(Color.BLUE);
        d.drawText(297, 150, firsLine, 40);
        d.setColor(Color.RED);
        d.drawText(294, 150, firsLine, 40);
        //draw the others line
        d.setColor(Color.BLACK);
        d.drawText(275, 300, secondLine, 40);
        d.setColor(Color.BLUE);
        d.drawText(280, 420, thirdLine, 27);
        d.setColor(Color.BLACK);
        d.drawText(300, 550, downLine, 20);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
