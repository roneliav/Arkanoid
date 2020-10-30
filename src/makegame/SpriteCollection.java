// ID: 208461228
package makegame;

import biuoop.DrawSurface;
import differentsprites.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * make a list of sprites.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * A constructor.
     *
     * initialize a lost of sprites
     *
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * add a sprite to the list.
     *
     * @param s a prite
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * remove a sprite from the list.
     *
     * @param s a sprite
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sp = new ArrayList<Sprite>(this.sprites);
        for (Sprite s : sp) {
            s.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d a surface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
}
