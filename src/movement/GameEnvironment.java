// ID: 208461228
package movement;

import collisiondetection.CollisionInfo;
import geometryprimitives.Line;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * a list of the collidables in the game.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * A constructor.
     *
     * initialize collidables list
     *
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }


    /**
     * add the given collidable to the environment.
     *
     * @param c  a collidable
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * remove a collidable from the list.
     *
     * @param c a collidable
     */
    public void removeCllidable(Collidable c) {
        collidables.remove(c);
    }

    /**
     *
     * @return the collidable list.
     */
    public List<Collidable> getList() {
        return collidables;
    }

    /**
     * check the closest point of the collision between the line and a collidable.
     *
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory an object move on this line
     *
     * @return the information about the collision
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Collidable> col = new ArrayList<Collidable>(this.collidables);
        //pass on each collidable and send to a function that checks if the line is collide it
        for (Collidable c : col) {
            Rectangle r = c.getCollisionRectangle();
            Point collisionPoint = trajectory.closestIntersectionToStartOfLine(r);
            //if there is a collision, return the information
            if (collisionPoint != null) {
                return new CollisionInfo(collisionPoint, c);
            }
        }
        //if there is not a collision, return null
        return null;
    }
}
