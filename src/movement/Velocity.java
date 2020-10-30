// ID: 208461228
package movement;

import geometryprimitives.Point;

/**
 * A class of velocity.
 *
 *Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {

    private double dx;
    private double dy;

    /**
     * A constructor of a velocity.
     *
     * @param dx number of 'x' to move in pne step
     * @param dy number of 'y' to move in pne step
     */
   public Velocity(double dx, double dy) {
       this.dx = dx;
       this.dy = dy;
   }

   /**
    * the function returns the 'dx' of the velocity.
    *
    * @return the 'dx' of the velocity
    */
   public double getDX() {
       return this.dx;
   }

   /**
    * the function returns the 'dy' of the velocity.
    *
    * @return the 'dy' of the velocity
    */
   public double getDY() {
       return this.dy;
   }

   /**
    * A constructor of a velocity from angel and a speed.
    *
    * the function convert the angke from degrees to radians and calculate the 'dx' and 'dy' by cos and sin.
    *
    * @param angle the angle of the ball's movement
    * @param speed the speed of the ball's movement
    * @return a velocity
    */
   public static Velocity fromAngleAndSpeed(double angle, double speed) {
       double dx;
       double dy;
       double rad = Math.toRadians(angle - 90);
       dx = speed * Math.cos(rad);
       dy = speed * Math.sin(rad);
       return new Velocity(dx, dy);
    }

    /**
     * get the speed of the velocity.
     *
     * the velocity is accoedng the 'Pitagoras sectnece'
     *
     * @return the speed of the velocity
     */
    public double getSpeed() {
       return Math.sqrt((this.dx * this.dx) + (this.dy * this.dy));
    }


   /**
    *Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
    *
    * @param p a point- to move from this point
    * @return a new point
    */
   public Point applyToPoint(Point p) {
       return new Point(p.getX() + this.dx, p.getY() + this.dy);
   }
}
