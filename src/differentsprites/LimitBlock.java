//ID: 208461228

package differentsprites;

import biuoop.DrawSurface;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;

import java.awt.Color;

/**
 * A class for the limits of the game.
 *
 * Extends from the block class, but drawn in a different way.
 *
 */
public class LimitBlock extends Block {

    /**
     * A constructor.
     *
     * call to the super constructor
     *
     * @param upperLeft a point
     * @param height int of the height
     * @param width int of the width
     */
    public LimitBlock(Point upperLeft, int height, int width) {
        super(upperLeft, height, width);
    }

    /**
     * A constructor.
     *
     * call to the super constructor
     *
     * @param rect a rectangle
     */
    public LimitBlock(Rectangle rect) {
        super(rect);
    }

    /**
     * A constructor.
     *
     * call to the super constructor
     *
     * @param rect a rectangle
     * @param color thr color of this limit block
     */
    public LimitBlock(Rectangle rect, java.awt.Color color) {
        super(rect, color);
    }

    @Override
    public void drawOn(DrawSurface surface) {
        //set the color of the ball and draw the ball
        if (super.getColor() == null) {
            super.setColor(Color.GRAY);
        }
        //take the color from super and draw this limit-block as a rectangle
        surface.setColor(super.getColor());
        surface.fillRectangle((int) super.getUpperLeft().getX(), (int) super.getUpperLeft().getY(),
                                (int) super.getWidth(), (int) super.getHeight());
    }
}
