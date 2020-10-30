//ID: 208461228
package movement;

import collisiondetection.HitListener;
import differentsprites.Ball;
import differentsprites.Block;
import makegame.Counter;
import makegame.GameLevel;

/**
 * A class of ball remover.
 *
 * the class know to remove a ball from the game
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter count;

    /**
     * A constructor.
     *
     * @param game a game
     * @param counter a counter
     */
    public BallRemover(GameLevel game, Counter counter) {
        this.game = game;
        this.count = counter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.count.decrease(1);
    }
}
