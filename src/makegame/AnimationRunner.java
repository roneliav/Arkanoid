//ID: 208461228
package makegame;

import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * A class of animation runner.
 *
 * This class know to draw the animation on screen.
 *
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private biuoop.Sleeper sleeper;

    /**
     * A constructor.
     *
     * @param g a GUI
     */
    public AnimationRunner(GUI g) {
        this.gui = g;
        //initialize time for every frame
        this.framesPerSecond = 60;
        //initialize a sleeper
        this.sleeper = new biuoop.Sleeper();
    }

    /**
     * run the animation.
     *
     * @param animation an animation
     */
    public void run(Animation animation) {
        //calculate time for everyy frame.
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            //initialize for the animation loop
            //because the computer has many calculates, it's not negligible, so we check how
            //much time past and according that wait some more, so the animation will be seen nice
            long startTime = System.currentTimeMillis(); // timing
            //initialize draw surface and draw the animation.
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            //sleeper
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}