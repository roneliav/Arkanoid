//ID: 208461228
package makegame;

import biuoop.DrawSurface;

/**
 * An interface of animation.
 *
 * animation can be draw something in one frame, and can notice if they should stop.
 *
 */
public interface Animation {

    /**
     * draw somethis one time.
     *
     * @param d a draw surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * notify if the animation shouls stop.
     *
     * @return boolean. yes - uf should stop. no - otherwise.
     */
    boolean shouldStop();
}