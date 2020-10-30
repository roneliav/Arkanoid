//ID: 208461228
package makegame;

import biuoop.GUI;
import biuoop.KeyboardSensor;
import specialscreens.GameOverScreen;
import specialscreens.WinScreen;

import java.util.List;

/**
 * A class of game flow.
 */
public class GameFlow {
    private GUI gui;
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter score;

    /**
     * A constructor.
     *
     * @param ar animation runner.
     * @param ks keyboard sensor.
     * @param g a GUI
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI g) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.gui = g;
        this.score = new Counter();

    }

    /**
     * run the levels.
     *
     * @param levels list of levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        // run level after level
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(this.gui, levelInfo, this.keyboardSensor,
                                            this.animationRunner, this.score);
            level.initialize();
            while (!level.shouldStop()) {
                level.playOneTurn();
            }
            //if the balls are over, run game over screen and exit the game
            if (level.getNumOfBalls() == 0) {
                this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, "space",
                                                                        new GameOverScreen(this.score.getValue())));
                return;
            }
        }
        //means 'win'
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, "space",
                                                                new WinScreen(this.score.getValue())));
    }
}
