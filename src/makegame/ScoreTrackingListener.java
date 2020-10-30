//ID: 208461228
package makegame;

import collisiondetection.HitListener;
import differentsprites.Ball;
import differentsprites.Block;

/**
 * A score tracking listener class.
 *
 * knows to increase the score every hit
 *
 */
public class ScoreTrackingListener implements HitListener {
    static final int HIT_SCORE = 5;
    private Counter currentScore;

    /**
     * A constructor.
     *
     * @param scoreCounter a counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * increase the counter every hit.
     *
     * @param beingHit a block being hit
     * @param hitter a ball which hit
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(HIT_SCORE);
    }
}
