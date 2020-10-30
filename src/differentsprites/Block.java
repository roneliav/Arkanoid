// ID: 208461228
package differentsprites;

import biuoop.DrawSurface;
import collisiondetection.HitListener;
import collisiondetection.HitNotifier;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import makegame.GameLevel;
import movement.Collidable;
import movement.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A class of a block. block is a collidable
 */
public class Block implements Collidable, Sprite, HitNotifier {

    private static final double  MIN = Math.pow(10, -13);
    private Point upperLeft;
    private int width;
    private int height;
    private java.awt.Color color;
    private ArrayList<HitListener> hitListeners;

    /**
     * A constructor of the block.
     *
     * @param upperLeft the upper-left point of the block
     * @param height the height oof the block
     * @param width the width of the block
     */
    public Block(Point upperLeft, int height, int width) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * A contructor from rectangle.
     *
     * @param rect a rectangle
     */
    public Block(Rectangle rect) {
        this.upperLeft = rect.getUpperLeft();
        this.width = (int) rect.getWidth();
        this.height = (int) rect.getHeight();
    }

    /**
     * A contructor from rectangle.
     *
     * @param rect a rectangle
     * @param color  a color
     */
    public Block(Rectangle rect, java.awt.Color color) {
        this.upperLeft = rect.getUpperLeft();
        this.width = (int) rect.getWidth();
        this.height = (int) rect.getHeight();
        this.color = color;
    }

    /**
     * set the color of the block.
     * @param col a color
     */
    public void setColor(java.awt.Color col) {
        this.color = col;
    }

    /**
     *
     * @return the rectangle (the shape) of the block
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return new Rectangle(this.upperLeft, this.width, this.height);
    }

    /**
     * change the velocity according the collision point.
     * and notify listeners about the collision
     *
     * @param hitter a ball
     * @param collisionPoint the collision point
     * @param currentVelocity the current velocity
     * @return new velocity
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //notify the his listener list about the hitting
        this.notifyHit(hitter);
        //save the data of the current velocity
        double dx = currentVelocity.getDX();
        double dy = currentVelocity.getDY();
        //check where the collision point relate the place of the block, and change accordingly the velocity
        //check if the distance between the collision point and the up/down limits is negligible
        if (Math.abs(collisionPoint.getY() - this.upperLeft.getY()) <= Math.pow(10, -12)) {
            //the ball go down, the dy need to change
            if (dy > 0) {
                dy = 0 - dy;
            }
        }
        if ((Math.abs(collisionPoint.getY() - (this.upperLeft.getY() + this.height))) <= Math.pow(10, -12)) {
            //the ball go up, the dy need to change
            if (dy < 0) {
                dy = 0 - dy;
            }
        }
        //check if the distance between the collision point and the left/right limits is negligible
        if (Math.abs(collisionPoint.getX() - this.upperLeft.getX()) <= Math.pow(10, -12)) {
            //the ball go right, the dx need to change
            if (dx > 0) {
                dx = 0 - dx;
            }
        }
        if (Math.abs(collisionPoint.getX() - (this.upperLeft.getX() + this.width)) <= Math.pow(10, -12)) {
            //the ball go left, the dx need to change
            if (dx < 0) {
                dx = 0 - dx;
            }
        }
        //return the new velocity
        return new Velocity(dx, dy);
    }

    /**
     * draw this block as a rectangle in the surface.
     *
     * @param surface the surface
     */
    @Override
    public void drawOn(DrawSurface surface) {
        //set the color of the ball and draw the ball
        if (this.color == null) {
            this.color = Color.GRAY;
        }
        surface.setColor(this.color);
        surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) this.width, (int) this.height);
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) this.width, (int) this.height);
    }

    /**
     * what to do every 'step'. For now, nothing
     */
    @Override
    public void timePassed() {
    }

    /**
     * add this block to the game.
     *
     * add the block to the sprites and collidables lists
     *
     * @param g a game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * remove this black from a game.
     *
     * remove the block the sprites and collidables lists
     *
     * @param game a game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    /**
     * notify the hit listener about the hitting.
     *
     * @param hitter a ball
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * @return the color of the block.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * @return the width of the block.
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * @return the height of the block.
     */
    public  int getHeight() {
        return this.height;
    }

    /**
     * @return the upper-left point of the block.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}


