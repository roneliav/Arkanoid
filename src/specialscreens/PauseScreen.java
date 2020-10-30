//ID: 208461228
package specialscreens;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import makegame.Animation;

/**
 * A class of pause screen.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
