//ID: 208461228

package levels.secondlevel;

import differentsprites.Ball;
import movement.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A class of the second level balls.
 */
public class SecondLevelBalls {
    private List<Ball> balls;
    private List<Velocity> velocities;

    /**
     * A constructor.
     *
     * initiate the balls and velocities.
     *
     */
    public SecondLevelBalls() {
        this.balls = new ArrayList<Ball>();
        this.velocities = new ArrayList<Velocity>();
        //initiate negative angles.
        for (int i = 0; i < 5; i++) {
            this.balls.add(new Ball(400, 570, 3, Color.WHITE));
            this.velocities.add(Velocity.fromAngleAndSpeed(-45 + 9 * i, 10));
        }
        //initiate positive angles.
        for (int i = 0; i < 5; i++) {
            this.balls.add(new Ball(400, 570, 3, Color.WHITE));
            this.velocities.add(Velocity.fromAngleAndSpeed(45 - 9 * i, 10));
        }
    }

    /**
     *
     * @return a ball list.
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
