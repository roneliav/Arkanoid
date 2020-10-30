// ID: 208461228

import levels.ThirdLevel.ThirdLevelGame;
import biuoop.GUI;
import levels.firstlevel.FirstLevelGame;
import levels.forthlevel.ForthLevelGame;
import makegame.AnimationRunner;
import makegame.GameFlow;
import makegame.LevelInformation;
import levels.secondlevel.SecondLevelGame;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;


/**
 * the class that make the game run, uses the game class.
 */
public class Ass6Game {

    /**
     * make the game run, uses the game class.
     *
     * @param args arguments from the command line
     */
    public static void main(String[] args) {
        List<LevelInformation> levelsList = new ArrayList<LevelInformation>();
        //initialize the gui and the keyboard for the paddle
        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui);
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        GameFlow gameFlow = new GameFlow(runner, keyboard, gui);
        //flaf if there are arguments without level numbers.
        boolean isLevel = false;
        //if there are arguments, for each number add its level to a list.
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                String levelString = args[i];
                if (levelString.length() == 1) {
                    if ((levelString.charAt(0) >= '1') && (levelString.charAt(0) <= '4')) {
                        int level = parseInt(levelString);
                        if (level == 1) {
                            levelsList.add(new FirstLevelGame());
                            isLevel = true;
                        } else if (level == 2) {
                            levelsList.add(new SecondLevelGame());
                            isLevel = true;
                        } else if (level == 3) {
                            levelsList.add(new ThirdLevelGame());
                            isLevel = true;
                        } else if (level == 4) {
                            levelsList.add(new ForthLevelGame());
                            isLevel = true;
                        }
                    }
                }
            }
        }
        //if there are not arguments or wasn't a level number in thr argumnets, run level 1 to 4.
        if ((args.length == 0) || (!isLevel)) {
            levelsList.add(new FirstLevelGame());
            levelsList.add(new SecondLevelGame());
            levelsList.add(new ThirdLevelGame());
            levelsList.add(new ForthLevelGame());
        }
        //run the game
        gameFlow.runLevels(levelsList);
        gui.close();
    }
}
