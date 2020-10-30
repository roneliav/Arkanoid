//ID: 208461228
package makegame;

import differentsprites.Ball;
import differentsprites.Block;
import differentsprites.Sprite;
import movement.Velocity;

import java.util.List;

/**
 * An interface for level information.
 */
public interface LevelInformation {

    /**
     *
     * @return return the number of ball in the level
     */
    int numberOfBalls();

    /**
     *
     * @return The initial velocity of each ball.
     */
    List<Velocity> initialBallVelocities();

    /**
     *
     * @return list of the balls in the level
     */
    List<Ball> getBalls();

    /**
     *
     * @return the speed (by pixels) of the paddle.
     */
    int paddleSpeed();

    /**
     *
     * @return the width of the paddele.
     */
    int paddleWidth();

    /**
     *
     * @return the level name as a String.
     */
    String levelName();

    /**
     *
     * @return a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * return a list of the blocks in this level.
     *
     * Each block contains its size, color, and location.
     *
     * @return a list of blocks.
     */
    List<Block> blocks();

    /**
     *
     * @return Number of blocks that should be removed.
     */
    int numberOfBlocksToRemove();
}
