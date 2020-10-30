//ID: 208461228
package specialscreens;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import makegame.Animation;
import makegame.SpriteCollection;

import java.awt.Color;

/**
 * A class of count down animation.
 *
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 *
 */
public class CountdownAnimation implements Animation {
    private double sec;
    private Integer count;
    private SpriteCollection screen;
    private Sleeper sleeper;
    private long miilisecPerNum;
    private boolean running;

    /**
     * A constructor.
     *
     * @param numOfSeconds double, seconds this animation will apear
     * @param countFrom int, numbers to count down
     * @param gameScreen SpriteCollection, to draw them meanwhile
     */
    public CountdownAnimation(double numOfSeconds,
                              int countFrom,
                              SpriteCollection gameScreen) {
        this.sec = numOfSeconds;
        this.count = countFrom;
        this.screen = gameScreen;
        this.sleeper = new Sleeper();
        //calculate how nuch secons for each number.
        this.miilisecPerNum = (1000 * (long) sec / count);
        this.running = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        //draw the sprites
        screen.drawAllOn(d);
        //draw the numbers of the countig down
        d.setColor(Color.WHITE);
        d.drawText(400, 350, count.toString(), 30);
        //sleep between each number.
        this.sleeper.sleepFor(miilisecPerNum);
        //if the count down is 0, means finish
        if (count == 0) {
            this.running = false;
        }
        count--;
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}