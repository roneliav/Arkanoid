// ID: 208461228
package differentsprites;

import biuoop.DrawSurface;

/**
 * An interface of sprites.
 *
 * shapes that can be drawn on the screen and make step
 *
 */
public interface Sprite {

    /**
     * draw the sprite to the screen.
     *
     * @param d a draw surface
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}

