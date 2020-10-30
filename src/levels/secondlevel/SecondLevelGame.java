//ID: 208461228
package levels.secondlevel;

import differentsprites.Ball;
import differentsprites.Block;
import differentsprites.Sprite;
import makegame.LevelInformation;
import movement.Velocity;

import java.util.List;

/**
 * A class of the second game level.
 */
public class SecondLevelGame implements LevelInformation {
    private SecondLevelBlocks blocks;
    private List<Velocity> ballsVelocity;
    private SecondLevelBalls balls;
    private final int speed = 1;
    private final int paddleWidth = 600;
    private final String levelName = "Rainbow Level";

    /**
     * A constructor.
     */
    public SecondLevelGame() {
        //initiate block
        this.blocks = new SecondLevelBlocks();
        //initiate balls
        this.balls = new SecondLevelBalls();
    }

    @Override
    public int numberOfBalls() {
        return this.ballsVelocity.size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return this.balls.getVelocities();
    }

    @Override
    public List<Ball> getBalls() {
        return this.balls.getBallsList();
    }

    @Override
    public int paddleSpeed() {
        return speed;
    }

    @Override
    public int paddleWidth() {
        return paddleWidth;
    }

    @Override
    public String levelName() {
        return levelName;
    }

    @Override
    public Sprite getBackground() {
        return new SecondLevelBackground();
    }

    @Override
    public List<Block> blocks() {
        return this.blocks.getBlocksList();
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks.getBlocksList().size();
    }
}
