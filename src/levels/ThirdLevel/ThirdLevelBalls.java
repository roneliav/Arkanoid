//ID: 208461228
package levels.ThirdLevel;

import differentsprites.Ball;
import movement.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A class of the third level balls.
 */
public class ThirdLevelBalls {
    private List<Ball> balls;
    private List<Velocity> velocities;

    /**
     * A constructor.
     */
    public ThirdLevelBalls() {
        //initiate balls list and a velocity list.
        this.balls = new ArrayList<Ball>();
        this.balls.add(new Ball(400, 570, 5, Color.WHITE));
        this.balls.add(new Ball(400, 570, 5, Color.WHITE));
        this.velocities = new ArrayList<Velocity>();
        this.velocities.add(Velocity.fromAngleAndSpeed(30, 7));
        this.velocities.add(Velocity.fromAngleAndSpeed(-30, 7));
    }

    /**
     *
     * @return a balls list.
     */
    public List<Ball> getBallsList() {
        return this.balls;
    }

    /**
     *
     * @return a velocity list.
     */
    public List<Velocity> getVelocities() {
        return this.velocities;
    }
}
