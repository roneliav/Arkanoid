//ID: 208461228
package collisiondetection;

import differentsprites.Ball;
import differentsprites.Block;

/**
 * An interface of hit listeners.
 *
 * The hit listeners will be known when a hit is occured.
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit a block being hit
     * @param hitter a ball which hit
     */
    void hitEvent(Block beingHit, Ball hitter);
}