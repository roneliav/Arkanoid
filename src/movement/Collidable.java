// ID: 208461228
package movement;

import differentsprites.Ball;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;

/**
 * interface for collidables like block and paddle, that the ball can't move through them.
 */
public interface Collidable {

    /**
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param hitter a ball
     * @param collisionPoint a point
     * @param currentVelocity a velocity
     * @return a new velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

}