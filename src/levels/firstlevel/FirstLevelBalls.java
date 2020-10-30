//ID: 208461228

package levels.firstlevel;

import differentsprites.Ball;
import movement.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A class of the first level balls.
 *
 * the class initiate the balls and velocities.
 *
 */
public class FirstLevelBalls {
    private List<Ball> balls;
    private List<Velocity> velocities;

    /**
     * A constructor.
     */
    public FirstLevelBalls() {
        //list of one ball and one velocity
        this.balls = new ArrayList<Ball>();
        this.balls.add(new Ball(400, 570, 3, Color.WHITE));
        this.velocities = new ArrayList<Velocity>();
        this.velocities.add(new Velocity(0, -5));
    }

    /**
     *
     * @return the ball list.
     */
    public List<Ball> getBallsList() {
        return this.balls;
    }

    /**
     *
     * @return the velocity list.
     */
    public List<Velocity> getVelocities() {
        return this.velocities;
    }
}
