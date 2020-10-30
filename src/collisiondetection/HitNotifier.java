//ID: 208461228

package collisiondetection;

/**
 * A class of hit notifier.
 *
 * The classes have a list of hit listeners
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     *
     * @param hl a hit listener
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl a hit listener
     */
    void removeHitListener(HitListener hl);

}
