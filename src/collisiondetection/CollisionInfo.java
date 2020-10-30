// ID: 208461228
package collisiondetection;

import movement.Collidable;
import geometryprimitives.Point;


/**
 * A class that save the collision information, if there ball collide a collidable.
 */
public class CollisionInfo {
    private Point point;
    private Collidable object;

    /**
     * A constructor.
     *
     * @param point a point where the collision was
     * @param object a collidable object thich the ball collided at
     */
    public CollisionInfo(Point point, Collidable object) {
        this.point = point;
        this.object = object;
    }

    /**
     * @return the collision point
     */
    public Point collisionPoint() {
        return this.point;
    }

    /**
     * @return the object the ball collided at him
     */
    public Collidable collisionObject() {
        return this.object;
    }
}
