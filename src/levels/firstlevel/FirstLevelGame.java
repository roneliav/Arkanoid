//ID: 208461228

package levels.firstlevel;

import differentsprites.Ball;
import differentsprites.Block;
import differentsprites.Sprite;
import makegame.LevelInformation;
import movement.Velocity;

import java.util.List;

/**
 * A class of the first level.
 */
public class FirstLevelGame implements LevelInformation {
    private FirstLevelBlocks blocks;
    private List<Velocity> ballsVelocity;
    private FirstLevelBalls balls;
    private final int speed = 5;
    private final int  paddleWidth = 60;
    private final String levelName = "Can't fail";

    /**
     * A constructor.
     */
    public FirstLevelGame() {
        //initiate block
        this.blocks = new FirstLevelBlocks();
        //initiate balls
        this.balls = new FirstLevelBalls();
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
        return new levels.firstlevel.FirstLevelBackground();
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
