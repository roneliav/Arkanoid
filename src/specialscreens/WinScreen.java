//ID: 208461228
package specialscreens;

import biuoop.DrawSurface;
import makegame.Animation;

import java.awt.Color;

/**
 * A class of win screen.
 */
public class WinScreen implements Animation {
    private Integer score;

    /**
     * A constructor.
     *
     * @param sc the score.
     */
    public WinScreen(Integer sc) {
        this.score = sc;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        //draw twice the first line
        String firsLine = "Congratulation!";
        d.setColor(Color.BLUE);
        d.drawText(260, 120, firsLine, 40);
        d.setColor(Color.YELLOW);
        d.drawText(264, 120, firsLine, 40);

        //draw twice the win line
        String winLine = "Yow Win!";
        d.setColor(Color.BLUE);
        d.drawText(300, 205, winLine, 45);
        d.setColor(Color.YELLOW);
        d.drawText(303, 205, winLine, 45);

        //draw the others line
        String secondLine = "Your score is " + score.toString();
        d.setColor(Color.BLACK);
        d.drawText(250, 300, secondLine, 40);

        String thirdLine = "Try another game!";
        d.setColor(Color.BLUE);
        d.drawText(280, 420, thirdLine, 27);

        String downLine = "Press space for closing";
        d.setColor(Color.BLACK);
        d.drawText(285, 550, downLine, 20);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
