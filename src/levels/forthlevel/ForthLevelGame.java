//ID: 208461228
package levels.forthlevel;

import differentsprites.Ball;
import differentsprites.Block;
import differentsprites.Sprite;
import makegame.LevelInformation;
import movement.Velocity;

import java.util.List;

/**
 * A class of the forth game level.
 */
public class ForthLevelGame implements LevelInformation {
    private ForthLevelBlocks blocks;
    private List<Velocity> ballsVelocity;
    private ForthLevelBalls balls;
    private final int speed = 8;
    private final int  paddleWidth = 80;
    private final String levelName = "Crazy level";

    /**
     * A constructor.
     */
    public ForthLevelGame() {
        //initiate block
        this.blocks = new ForthLevelBlocks();
        //initiate balls
        this.balls = new ForthLevelBalls();
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
        return new levels.forthlevel.ForthLevelBackground();
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
