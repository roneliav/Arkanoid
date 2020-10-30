//ID: 208461228
package levels.ThirdLevel;

import differentsprites.Ball;
import differentsprites.Block;
import differentsprites.Sprite;
import makegame.LevelInformation;
import movement.Velocity;

import java.util.List;

/**
 * A class of third level game.
 */
public class ThirdLevelGame implements LevelInformation {
    private ThirdLevelBlocks blocks;
    private List<Velocity> ballsVelocity;
    private ThirdLevelBalls balls;
    private final int speed = 10;
    private final int  paddleWidth = 80;
    private final String levelName = "Pyramid level";

    /**
     * A constructor.
     */
    public ThirdLevelGame() {
        //initiate block
        this.blocks = new ThirdLevelBlocks();
        //initiate balls
        this.balls = new ThirdLevelBalls();
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
        return new ThirdLevelBackground();
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
