//ID: 208461228

package makegame;

import biuoop.KeyboardSensor;
import differentsprites.Block;
import differentsprites.Ball;
import differentsprites.Sprite;
import differentsprites.Paddle;
import differentsprites.LimitBlock;
import movement.BallRemover;
import movement.GameEnvironment;
import biuoop.GUI;
import collisiondetection.BlockRemover;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import movement.Velocity;

import java.util.List;

/**
 * A initializings class.
 *
 * this class know to initialize many things of the gmae.
 *
 */
public class Initializings {

    /**
     * initialize block and listeners.
     *
     * @param game a game
     * @param blockCounter a block counter
     * @param score a score counter
     * @param blocks a list pf blocks
     */
    public static void blocksAndListeners(GameLevel game, Counter blockCounter, Counter score, List<Block> blocks) {
        //initialize a block remover and a score listener
        BlockRemover blockRemover = new BlockRemover(game, blockCounter);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(score);
        //initialize blocks and their listeners
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).addToGame(game);
            blocks.get(i).addHitListener(blockRemover);
            blocks.get(i).addHitListener(scoreTrackingListener);
            blockCounter.increase(1);
        }

    }

    /**
     * initialize indicators: lives, scors and level name.
     *
     * @param game a game
     * @param score a score counter
     * @param levelName a string
     */
    public static void scoring(GameLevel game, Counter score, String levelName) {
        //make a new score indicator and add it to the game
        Rectangle scoreIndicate = new Rectangle(new Point(0, 0), 800, 20);
        Indicators indicators = new Indicators(scoreIndicate, score, levelName);
        indicators.addToGame(game);
    }

    /**
     * initialize a paddle.
     *
     * @param game a game
     * @param gui a GUI
     * @param environment a game environment
     * @param keyboard a keyboard sensor
     * @param paddleSpeed int
     * @param paddleWidth int
     */
    public static void paddle(GameLevel game, GUI gui, GameEnvironment environment, KeyboardSensor keyboard,
                              int paddleSpeed, int paddleWidth) {
        int startX = (int) ((800 - paddleWidth) / 2);
        //male a new paddle and add it to the game
        Paddle paddle = new Paddle(new Point(startX, 580), paddleWidth, 10, keyboard);
        paddle.setSpeed(paddleSpeed);
        paddle.addToGame(game);
        paddle.setEnvironment(environment);
    }

    /**
     * initialize a death block.
     *
     * the death block 'kill' the balls which hit him.
     *
     * @param game a game
     * @param ballCounter a counter
     */
    public static void deathBlock(GameLevel game, Counter ballCounter) {
        //make a block, add it to the game and add a ball remover which listen to this black
        Block deathRegion = new Block(new Point(0, 600), 5, 800);
        deathRegion.addToGame(game);
        BallRemover ballRemover = new BallRemover(game, ballCounter);
        deathRegion.addHitListener(ballRemover);
    }

    /**
     * initialize the limits of the game.
     *
     * @param g the game
     */
    public static void limits(GameLevel g) {
        //make blocks in the limits of the game and add the blocks to the game
        LimitBlock limitLeft = new LimitBlock(new Point(0, 0), 600, 10);
        limitLeft.addToGame(g);
        LimitBlock limitUp = new LimitBlock(new Point(0, 20), 10, 800);
        limitUp.addToGame(g);
        LimitBlock limitRight = new LimitBlock(new Point(790, 10), 590, 10);
        limitRight.addToGame(g);
    }

    /**
     * initialize balls according the arguments.
     *
     * @param game a game level
     * @param environment a game environment
     * @param ballCounter a counter
     * @param velocities a list of velocities
     * @param balls a list of balls
     */
    public static void balls(GameLevel game, GameEnvironment environment, Counter ballCounter,
                             List<Velocity> velocities, List<Ball> balls) {
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).setVelocity(velocities.get(i));
            balls.get(i).addToGame(game);
            balls.get(i).setGameEnviroment(environment);
            ballCounter.increase(1);
        }
    }

    /**
     * initialize a background as a sprite.
     *
     * @param s a sprite
     * @param game a game level
     */
    public static void background(Sprite s, GameLevel game) {
        game.addSprite(s);
    }

}
