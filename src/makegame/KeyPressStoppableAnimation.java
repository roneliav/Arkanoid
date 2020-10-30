//ID: 208461228
package makegame;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * A class for animation that stops by a key-pressing.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private String keyToPress;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPassed;

    /**
     * A constructor.
     *
     * @param sensor keyboard sensor.
     * @param key String of the pressed key for stopping the animation
     * @param animation anumation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.keyToPress = key;
        this.animation = animation;
        //if the animation shuld stop, 'stop'=true
        this.stop = false;
        this.isAlreadyPassed = true; //because the key was been pressed before the animation began run
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        //do one frame, until the key is pressed.
        this.animation.doOneFrame(d);
        if ((this.keyboard.isPressed(this.keyToPress)) && (!this.isAlreadyPassed)) {
                this.stop = true;
            }
            //if the key was pressed, but it's pressed before the animation began,
            //don't stop the animation but oposite 'usAlreadyPassed'
        if (!this.keyboard.isPressed(keyToPress)) {
            this.isAlreadyPassed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
