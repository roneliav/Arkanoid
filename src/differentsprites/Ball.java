// ID: 208461228
package differentsprites;

import biuoop.DrawSurface;
import collisiondetection.CollisionInfo;
import geometryprimitives.Line;
import geometryprimitives.Point;
import makegame.GameLevel;
import movement.Collidable;
import movement.GameEnvironment;
import movement.Velocity;

import java.awt.Color;

/**
 * A class of a ball.
 *
 * A point has center point, size, color ans velocity. it can drow itself and move one step
 */
public class Ball implements Sprite {

    private Point center;
    private int size; //radius
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * A constructor of a ball.
     *
     * initiate the velocity to 0
     *
     * @param center the center point of the ball
     * @param r the radius of the ball
     * @param color the color of the ball
     */
   public Ball(Point center, int r, java.awt.Color color) {
       this.center = center;
       this.size = r;
       this.color = color;
       this.velocity = new Velocity(0, 0);
   }

   /**
    * A constructor of a ball.
    *
    * initiate the velocity to 0
    *
    * @param x the 'x' of the center point of the Ball
    * @param y the 'y' of the center point of the ball
    * @param r the radius of the ball
    * @param color the color of the ball
    */
   public Ball(int x, int y, int r, java.awt.Color color) {
       //make a point and put it as the ball center
       this.center = new Point(x, y);
       this.size = r;
       this.color = color;
       this.velocity = new Velocity(0, 0);
   }

   /**
    * the function returns the 'x' of the center point.
    *
    * @return the 'x' of the center point
    */
   public int getX() {
       return (int) this.center.getX();
   }

   /**
    * the function returns the 'y' of the center point.
    *
    * @return the 'y' of the center point
    */
   public int getY() {
       return (int) this.center.getY();
   }

   /**
    * the function returns the size (radius) of the ball.
    *
    * @return the size pf the ball
    */
   public int getSize() {
       return this.size;
   }

   /**
    * the function returns the color of the ball.
    *
    * @return the color of the ball
    */
   public java.awt.Color getColor() {
       return this.color;
   }

   /**
    * the function draws the ball in the surface.
    *
    * @param surface the surface to draw the ball on
    */
   public void drawOn(DrawSurface surface) {
       //set the color of the ball and draw the ball
       if (this.color == null) {
           this.color = Color.BLACK;
       }
       surface.setColor(this.color);
       surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.size);
       surface.setColor(Color.BLACK);
       surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.size);
   }

    /**
     * move the ball one step.
     */
    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
    * the function set a velocity to the ball.
    *
    * @param v the velocity to set to the ball
    */
   public void setVelocity(Velocity v) {
       this.velocity = new Velocity((int) v.getDX(), (int) v.getDY());
   }

   /**
    * the function set a velocity to the ball.
    *
    * the function get dx, dy and make a new velocity and set it to the ball
    *
    * @param dx the 'dx' of the velocity to set to the ball
    * @param dy the 'dy velocity to set to the ball
    */
   public void setVelocity(double dx, double dy) {
       this.velocity = new Velocity((int) dx, (int) dy);
   }

   /**
    * the function returns the velocity of the ball.
    *
    * @return the velocity of the ball
    */
   public Velocity getVelocity() {
       //if the velocity isn't null, return it.
       if (velocity == null) {
           return null;
       }
       return this.velocity;
   }

   /**
    * the function move the ball one step according its velocity and its center.
    *
    * the function checks if the ball collide something and chang accordance its velocity.
    */
   public void moveOneStep() {
       //the point the ball should be after this step
       Point endLine = this.velocity.applyToPoint(this.center);
       //check if the movement to the 'destination' point make a collision
       CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(new Line(this.center, endLine));
       //if there isn't a collision, do the step
       if (collisionInfo == null) {
           this.center = this.velocity.applyToPoint(this.center);
           //if there is a collision
       } else {
           Point collisionPoint = collisionInfo.collisionPoint();
           Collidable collisionObject = collisionInfo.collisionObject();
           //a function that return the new velocity accordance the hitting point
           Velocity newV = collisionObject.hit(this, collisionPoint, this.velocity);
           Velocity oldV = this.velocity;
           Line move = new Line(this.center, newV.applyToPoint(this.center));
           this.velocity = newV;
           if (this.gameEnvironment.getClosestCollision(move) == null) {
               this.velocity = newV;
               //if the change cause to another intersection,
               // so it's a corner of 2 blocks and change the whole velocity
           } else {
               //in order to notify the listeners in the block this hit,
               //the velocity change according the first collision, so the arguments and the return parameter
               //are irrelevant
               this.gameEnvironment.getClosestCollision(move).collisionObject().hit(this,
                                                                                   new Point(0, 0), newV);
               this.velocity = new Velocity(0 - oldV.getDX(), 0 - oldV.getDY());
           }
           //put the new velocity in the ball, and make this step
           this.center = this.velocity.applyToPoint(this.center);
       }
   }


    /**
     * set the game environment of this ball.
     *
     * @param environment this game environment
     */
    public void setGameEnviroment(GameEnvironment environment) {
        this.gameEnvironment = environment;
    }

    /**
     *
     * @return this game environment
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * add this ball to it's game.
     *
     * add this ball to the sprites list
     *
     * @param g this game
     */
    public void addToGame(GameLevel g) {
       g.addSprite(this);
    }

    /**
     * remove this ball from the game.
     *
     * remove this ball from the sprite list
     *
     * @param game this game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}
