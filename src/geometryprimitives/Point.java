// ID: 208461228
package geometryprimitives;

/**
 * A class of point.
 *
 * A point has an x and a y value, and can measure the distance to other points,
 * and if it is equal to another point.
 */
public class Point {
    //x,y - the 'place' of the point
    private double x;
    private double y;

    /**
     * A constructor of a point.
     *
     * @param x the place of the point in 'x'.
     * @param y the place of the point in 'y'.
     */
    public Point(double x, double y) {
        //put the input in the 'point'.
        this.x = x;
        this.y = y;
    }

    /**
     * the function calculates the distance between this point and the other.
     *
     * @param other another point.
     * @return the distance between the points
     */
    public double distance(Point other) {
        if (this.equals(other)) {
            return 0.0;
        }
        return Math.sqrt((Math.abs((this.x - other.getX()) * (this.x - other.getX())))
                + (Math.abs((this.y - other.getY()) * (this.y - other.getY()))));
    }

    /**
     * the function check if the points are equal.
     *
     * the function compaer between the 'x' values and the 'y' values of the points.
     *
     * @param other another point.
     * @return 'true' is the points are equal, 'false' otherwise.
     */
    public boolean equals(Point other) {
        return ((this.x == other.getX()) && (this.y == other.getY()));
    }

    /**
     * the function returns the 'x' of the point.
     *
     * @return the 'x' of the point
     */
    public double getX() {
        return this.x;
    }

    /**
     * the function returns the 'y' of the point.
     *
     * @return the 'y' of the point
     */
    public double getY() {
        return this.y;
    }

    /**
     * the functiion get points and return the point with higher 'y'.
     *
     * @param other another point
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point higher(Point other) {
        if (this.getY() > other.getY()) {
            return this;
        }
        return other;
    }

    /**
     * the functiion get points and return the point with lower 'y'.
     *
     * @param other another point
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point lower(Point other) {
        if (this.getY() < other.getY()) {
            return this;
        }
        return other;
    }

}
