// ID: 208461228
package makegame;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import collisiondetection.HitListener;
import differentsprites.Ball;
import differentsprites.Block;
import differentsprites.Sprite;
import movement.Collidable;
import movement.GameEnvironment;
import specialscreens.CountdownAnimation;
import specialscreens.PauseScreen;

/**
 * save the data of the tools in the game in addition the game environment:
 * list of sprites and the game environment.
 */
public class GameLevel implements HitListener, Animation {
    private GUI gui;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInfo;
    private final double secBeforeStart = 2;
    private final int countBeforeStart = 3;
    private final String pressToPause = "p";
    private final String pressToReturnGame = "space";

    /**
     * A constructor.
     *
     * @param g a GUI
     * @param levelInformation a level information
     * @param ks a keyboard sensor
     * @param ar an animation runner
     * @param sc a counter to the score
     */
    public GameLevel(GUI g, LevelInformation levelInformation, KeyboardSensor ks, AnimationRunner ar, Counter sc) {
        this.gui = g;
        this.levelInfo = levelInformation;
        this.keyboard = ks;
        this.runner = ar;
        this.score = sc;
    }

    /**
     * add a collidable to the list of the game environment.
     * @param c a coolidable shape
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * add a sprite to this list.
     * @param s a sprite shape
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * remove a collidable from the list.
     *
     * @param c a collidable
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCllidable(c);
    }

    /**
     * remove a sprite from the list.
     *
     * @param s a sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {
        //make new lists
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        //initialize counters
        this.ballCounter = new Counter();
        this.blockCounter = new Counter();
        Initializings.background(this.levelInfo.getBackground(), this);
        //initialize limits, block and their listeners
        Initializings.limits(this);
        Initializings.blocksAndListeners(this, this.blockCounter, this.score, this.levelInfo.blocks());
        //initialize a score indicator as a sprite
        Initializings.scoring(this, this.score, this.levelInfo.levelName());
        //initialize a 'death region' block and a ball remover
        Initializings.deathBlock(this, this.ballCounter);
        //when should stop the 'running' will be 'false'
        this.running = true;
    }

    /**
     * Run the game.
     *
     * initialize a paddle, do the animation loops and move the steps in the game
     *
     */
    public void playOneTurn() {
        //initialize a paddle
        Initializings.paddle(this, this.gui, this.environment, keyboard,
                            this.levelInfo.paddleSpeed(), this.levelInfo.paddleWidth());
        //initialize ball and a ball counter
        Initializings.balls(this, this.environment, this.ballCounter,
                            this.levelInfo.initialBallVelocities(), this.levelInfo.getBalls());
        //run count down animation before start level and run this level
        this.runner.run(new CountdownAnimation(secBeforeStart, countBeforeStart, this.sprites));
        this.runner.run(this);
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        removeCollidable(beingHit);
        removeSprite(beingHit);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        //move one step all
        this.sprites.notifyAllTimePassed();
        if (this.blockCounter.getValue() == 0) {
            this.score.increase(100);
            this.running = false;
        }
        //if the balls are over, should stop.
        if (this.ballCounter.getValue() == 0) {
            this.running = false;
        }
        //if the pause-key was pressed, run the pause screen
        if (this.keyboard.isPressed(pressToPause)) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, pressToReturnGame, new PauseScreen()));
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     *
     * @return the number of balls now
     */
    public int getNumOfBalls() {
        return this.ballCounter.getValue();
    }
}

