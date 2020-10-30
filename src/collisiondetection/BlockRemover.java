//ID: 208461228
package collisiondetection;

import differentsprites.Ball;
import differentsprites.Block;
import makegame.Counter;
import makegame.GameLevel;

/**
 * A block remover class.
 *
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count,
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * A constructor.
     *
     * @param game a game
     * @param removedBlocks a counter
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * Remove the block which being hitted from the game.
     *
     * @param beingHit a block
     * @param hitter a ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        //remove the block from the game.
        beingHit.removeFromGame(game);
        //remove this listener from the block's listeners
        beingHit.removeHitListener(this);
        //decrease the block counters by 1.
        this.remainingBlocks.decrease(1);
    }
}
