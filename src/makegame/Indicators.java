//ID: 208461228
package makegame;

import biuoop.DrawSurface;
import differentsprites.Sprite;
import geometryprimitives.Rectangle;

import java.awt.Color;

/**
 * A score indicator class.
 *
 * this class can show the score on the screen.
 *
 */
public class Indicators implements Sprite {
    private Rectangle rectangle;
    private Counter score;
    private String levelName;

    /**
     * A constructor.
     *
     * @param rect a rectangle
     * @param counter a counter
     * @param lName a string
     */
    public Indicators(Rectangle rect, Counter counter, String lName) {
        this.rectangle = rect;
        this.score = counter;
        this.levelName = lName;
    }

    @Override
    public void drawOn(DrawSurface d) {
        //make a rectangle to this block
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                        (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        //start the strings 2 pixels over the down side of the sprite
        int startStringY = (int) (this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight() - 2);
        this.drawOnLives(d, startStringY);
        this.drawOnScore(d, startStringY);
        this.drawOnLevelName(d, startStringY, levelName);
    }

    /**
     * draw the lives.
     *
     * @param d draw surface
     * @param startStringY int, pixel to start the string
     */
    public void drawOnLives(DrawSurface d, int startStringY) {
        d.setColor(Color.BLACK);
        //there is one live whole the game
        d.drawText(100, startStringY, "Lives: 1", 20);
    }

    /**
     * draw the score.
     *
     * @param d draw surface
     * @param startStringY int, pixel to start the string
     */
    public void drawOnScore(DrawSurface d, int startStringY) {
        String text = "Score: " + this.score.getValue();
        d.setColor(Color.BLACK);
        d.drawText(300, startStringY, text, 20);
    }

    /**
     * draw the level name.
     *
     * @param d draw surface
     * @param startStringY int, pixel to start the string
     * @param name string. The level name.
     */
    public void drawOnLevelName(DrawSurface d, int startStringY, String name) {
        String text = "Level Name: " + name;
        d.setColor(Color.BLACK);
        d.drawText(500, startStringY, text, 20);
    }

    @Override
    public void timePassed() {

    }

    /**
     * add this to the game as a sprite.
     *
     * @param game a game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
