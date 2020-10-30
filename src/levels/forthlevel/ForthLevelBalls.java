//ID: 208461228
package levels.forthlevel;

import differentsprites.Ball;
import movement.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A class of the forth level balls.
 */
public class ForthLevelBalls {
    private List<Ball> balls;
    private List<Velocity> velocities;

    /**
     * A constructor.
     *
     * initialize balls and velocities.
     *
     */
    public ForthLevelBalls() {
        this.balls = new ArrayList<Ball>();
        this.balls.add(new Ball(400, 570, 5, Color.WHITE));
        this.balls.add(new Ball(400, 570, 5, Color.WHITE));
        this.balls.add(new Ball(400, 570, 5, Color.WHITE));
        this.velocities = new ArrayList<Velocity>();
        this.velocities.add(Velocity.fromAngleAndSpeed(45, 9));
        this.velocities.add(Velocity.fromAngleAndSpeed(0, 9));
        this.velocities.add(Velocity.fromAngleAndSpeed(-45, 9));
    }

    /**
     *
     * @return a balls list
     */
    public List<Ball> getBallsList() {
        return this.balls;
    }

    /**
     *
     * @return a velocity list
     */
    public List<Velocity> getVelocities() {
        return this.velocities;
    }
}
