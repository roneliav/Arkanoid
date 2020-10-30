// ID: 208461228
package differentsprites;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import makegame.GameLevel;
import movement.Collidable;
import movement.GameEnvironment;
import movement.Velocity;

import java.awt.Color;
import java.util.List;

/**
 * A class of paddle.
 *
 * the paddle can move with the right anf left arrays in the keyboard, but can't move throw collidables
 */
public class Paddle implements Sprite, Collidable {
    private int speed;
    private Point upperLeft;
    private int width;
    private int height;
    private biuoop.KeyboardSensor keyboard;
    private java.awt.Color color;
    private GameEnvironment environment;

    /**
     * A constructor.
     *
     * @param upperLeft the upper-left point of the paddle
     * @param width the width of the paddle
     * @param height the height of the paddle
     * @param keyboard the keyboard that move the paddle
     */
    public Paddle(Point upperLeft, int width, int height, biuoop.KeyboardSensor keyboard) {
        this.upperLeft = upperLeft;
        this.width =  width;
        this.height =  height;
        this.keyboard = keyboard;
        this.speed = 0;
    }

    /**
     * set the speed of the paddle.
     *
     * @param s int
     */
    public void setSpeed(int s) {
        this.speed = s;
    }

    /**
     * set the color of the paddle.
     *
     * @param col the color to set
     */
    public void setColor(java.awt.Color col) {
        this.color = col;
    }

    /**
     * set GameEnvironment.
     *
     * @param envir the gameEnvironment to set
     */
    public void setEnvironment(GameEnvironment envir) {
        this.environment = envir;
    }

    /**
     * move the paddle left.
     *
     * check if the paddle doesn't collid with a collidable
     */
    public void moveLeft() {
        double oldX = this.upperLeft.getX();
        double y = this.upperLeft.getY();
        //go over all the collidables
        List<Collidable> collidables = environment.getList();
        for (Collidable c : collidables) {
            Rectangle r = c.getCollisionRectangle();
            //if the the paddle collide a collidable, the paddle will stay in the collision point
            //we add 0.5 in order not to collide the paddle  himself
            if (((r.getUpperLeft().getX() + r.getWidth()) < oldX + 0.5
                    && r.getUpperLeft().getX() + r.getWidth() > oldX - this.speed)
                && ((y >= r.getUpperLeft().getY() && y <= r.getUpperLeft().getY() + r.getHeight())
                        || ((y + this.height >= r.getUpperLeft().getY()
                        && y + this.height <= r.getUpperLeft().getY() + r.getHeight())))) {
                    //if there is a collision, move to the collision point
                    this.upperLeft = new Point(r.getUpperLeft().getX() + r.getWidth(), y);
                    return;
            }
        }
        //if there is not a collision, move
        upperLeft = new Point(oldX - this.speed, y);
    }

    /**
     * move the paddle right.
     *
     * check if the paddle doesn't collid with a collidable
     */
    public void moveRight() {
        double oldX = this.upperLeft.getX();
        double y = this.upperLeft.getY();
        //go over all the collidables
        List<Collidable> collidables = environment.getList();
        for (Collidable c : collidables) {
            Rectangle r = c.getCollisionRectangle();
            //if the the paddle collide a collidable, the paddle will stay in the collision point
            //we add 0.5 in order not to collide the paddle  himself
            if (((r.getUpperLeft().getX() > oldX + this.width - 0.5
                    && r.getUpperLeft().getX() < oldX + this.width + this.speed)
                    && ((y >= r.getUpperLeft().getY() && y <= r.getUpperLeft().getY() + r.getHeight())
                    || ((y + this.height >= r.getUpperLeft().getY()
                    && y + this.height <= r.getUpperLeft().getY() + r.getHeight()))))) {
                //if there is a collision, move to the collision point
                this.upperLeft = new Point(r.getUpperLeft().getX() - this.width, y);
                return;
            }
        }
        //if there is not a collision, move
        upperLeft = new Point(oldX + this.speed, y);
    }

    /**
     * a sprite method.
     *
     * check which key was pressed and sent to the suitable method
     *
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * a sprite method.
     *
     * draw the paddle
     *
     * @param d a draw surface
     */
    @Override
    public void drawOn(DrawSurface d) {
        //if the color hadn't swt, set yellow
        if (this.color == null) {
            this.color = Color.YELLOW;
        }
        d.setColor(this.color);
        d.fillRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(), this.width, this.height);
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(), this.width, this.height);
    }

    /**
     * @return the rectangle of the paddle.
     */
    public Rectangle getCollisionRectangle() {
        return new Rectangle(this.upperLeft, this.width, this.height);
    }

    /**
     * checks the part of the point out of 5 parts of the pedal.
     *
     * if the point is more left than the paddle, return 0
     * if the point is more right than the paddle, return 6
     *
     * @param p the point to check
     *
     * @return the region of the paddle
     */
    private int regionInPaddle(Point p) {
        double startX = this.upperLeft.getX();
        double endX = startX + this.width;
        double pointX = p.getX();
        return ((int) ((pointX - startX) / ((endX - startX) / 5))) + 1;
    }

    /**
     * check the region of the collision point at the paddle and in accordance change the velocity.
     *
     * @param hitter a ball
     * @param collisionPoint the collision point
     * @param currentVelocity the cuurent velocity
     * @return a new velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //save the data of the current velocity
        double dx = currentVelocity.getDX();
        double dy = currentVelocity.getDY();
        double ballSpeed = currentVelocity.getSpeed();
        //check the region of the paddle the colliosion
        int region = regionInPaddle(collisionPoint);
        //change the velocity according the region
        //the regions are 0-6, when 0 means more left than the paddle ang 6 means more right.
        //it can be more left or more right only in a small distance, because of the 'double' type calculators.
        if (region == 1 || region == 0) {
            return Velocity.fromAngleAndSpeed(300, ballSpeed);
        }
        if (region == 2) {
            return Velocity.fromAngleAndSpeed(330, ballSpeed);
        }
        if (region == 3) {
            return new Velocity(dx, 0 - dy);
        }
        if (region == 4) {
            return Velocity.fromAngleAndSpeed(30, ballSpeed);

        }
        if (region == 5 || region == 6) {
            return Velocity.fromAngleAndSpeed(60, ballSpeed);
        }
        //if here, there is a problem!
        return Velocity.fromAngleAndSpeed(60, 0);
    }

    /**
     * add this paddle to the game.
     *
     * add this ball to collidables and sprites lists
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}