// ID: 208461228
package geometryprimitives;

import java.util.List;

/**
 * A class of line.
 *
 * A line has a start point and an end point.
 *
 * The class can return length, if intersect with another line, check if it is the same as another line segment etc.
 */
public class Line {
    //each line has start and end point
    private Point start;
    private Point end;
    private double[] equation;

    /**
     * A constructor of a line.
     *
     * @param start the start point of the line.
     * @param end   the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * A constructor of a point.
     *
     * @param x1 the 'x' place of the start point of the line.
     * @param y1 the 'y' place of the start point of the line.
     * @param x2 the 'x' place of the end point of the line.
     * @param y2 the 'y' place of the end point of the line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Return the length of the line.
     *
     * @return the length of the line
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * Return the moddle point of the line.
     *
     * @return the middle point of the line
     */
    public Point middle() {
        //the average between the start point and the end point
        double newX = ((this.start.getX() + this.end.getX()) / 2.0);
        double newY = ((this.start.getY() + this.end.getY()) / 2.0);
        return new Point(newX, newY);
    }

    /**
     * Return the start point of the line.
     *
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * Return the end point of the line.
     *
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * the function make the equaton 'ax+b' and put as a private integer.
     *
     *the first limb in the array is 'a', the second is 'b'.
     *
     * if the line is 'x=c(number)', (a vertical line), the equation stay 'null'.
     */
    private void makeEquation() {
        if (this.end.getX() - this.start.getX() == 0) {
            this.equation = null;
        } else {
            //a-the slope of the line. b-the 'free' number. the equation is: y=ax+b. and save it in array
            //a=(y2-y1)/(x2-x1)
            double aThis = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
            //the equation is: y-y1=a(x-x1), so b=y1-aThis*x1
            double bThis = this.start.getY() - (aThis * this.start.getX());
            double[] equationThis = {aThis, bThis};
            this.equation =  equationThis;
        }
    }

    /**
     * Return the equation of the line.
     *
     * @return the equation of the line.
     */
    public double[] getEquation() {
        return this.equation;
    }

    /**
     * check if the lines are equal.
     *
     * @param other point to compare with
     * @return true if the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        return (((this.start.equals(other.start)) && (this.end.equals(other.end)))
                || ((this.end.equals(other.start)) && (this.start.equals(other.end))));
    }

    /**
     * check if a point is in the line by the equation of the line.
     *
     * check if the equation is lower than a very small number,
     * because the computer doesn't accurate in double numbers
     *
     * @param point the point to check if it is in the line
     * @return true if the point is inside the segments of the lines
     */
    private boolean pointInSegment(Point point) {
        //because the 'double' equations, the comparison is until 3
        if (this.start.distance(point) + this.end.distance(point) - this.length() <= Math.pow(10, -12)) {

            return true;
        }
        return false;
    }


    /**
     * check the if there is an intersection point between two lines.
     *
     * the function checks the return value of the 'intersectionWith function'
     *
     * @param other another point
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        return (this.intersectionWith(other) != null);
    }

    /**
     * check the intersection point between two lines.
     *
     * the function calculates the equations of the lines, and checks if the the intersection point
     * is inside the segment of the lines.
     *
     * @param other another point
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {

        //if the lines are equals equals-the start point is an intersection point
        if (this.equals(other)) {
            return this.start;
        }

        //if one the start/end point of this line is same to the start/end point of the other lines-return it.
        if ((this.start.equals(other.start())) || (this.start.equals(other.end()))) {
            return this.start;
        } else {
            if ((this.end.equals(other.start())) || (this.end.equals(other.end()))) {
                return this.end;
            }
        }

        //if length=0, there is no intersection point (because we already checked the start and end)
        if ((this.length() == 0) || (other.length() == 0)) {
            return null;
        }

        //if the middle points are equal - return it
        if (this.middle().equals(other.middle())) {
            return middle();
        }

        //make equations to the lines and compare between the equation.
        this.makeEquation();
        other.makeEquation();
        double[] equationThis = this.equation;
        double[] equationOther = other.getEquation();
        //if both of the equations are null, so they both vertical
        if ((equationThis == null) && (equationOther == null)) {
            //check if they both on the same 'x', and if they in the same segment
            if (this.end.getX() == other.end.getX()) {
                Point highA = this.start.higher(this.end);
                Point lowA = this.start.lower(this.end);
                Point highB = other.start().higher(other.end());
                Point lowB = other.start().lower(other.end());
                //if the 2 highest points are from the same line, there is no intersection point
                if (lowB.equals(lowB.higher(highA)) || (lowA.equals(lowA.higher(highB)))) {
                    return null;
                    //if not, return the second highest point
                } else {
                    return highA.lower(highB);
                }
            }
            //if not, there isn't an intersection point
            return null;
        }

        //if one line is vertical (the second isn't), so put its 'x' in the equation of the second line,
        //and check if this point appears in the second line. if no, return null
        if (equationThis == null) {
            Point interPoint = new Point(this.start.getX(),
                                        equationOther[0] * this.start.getX() + equationOther[1]);
            if (other.pointInSegment(interPoint) && (this.pointInSegment(interPoint))) {
                return interPoint;
            } else {
                return null;
            }
        } else if (equationOther == null) {
            Point interPoint = new Point(other.start().getX(),
                                equationThis[0] * other.start().getX() + equationThis[1]);
            if (this.pointInSegment(interPoint) && (other.pointInSegment(interPoint))) {
                return interPoint;
            } else {
                return null;
            }
        }

        //if 'a' are identical but the 'b' are not, the lines don't intersection
        if ((equationThis[0] == equationOther[0])) {
            if (equationThis[1] != equationOther[1]) {
                return null;
                //but if 'a' are identical and also 'b', check if the lines merges, means start/enf of one line
                //is in the second line.
            } else {
                if ((this.pointInSegment(other.start()))) {
                    return other.start();
                } else if (this.pointInSegment(other.end())) {
                    return other.end();
                    //so the lines don't merges and there is not an intersection point
                } else {
                    return null;
                }
            }
        }
        //so, there are 2 equations
        //check the intersection point: compare the two equations: y=a1x+b1, y=a2x+b2, find x and y and make a point
        double helpInter = equationOther[0] - equationThis[0];
        double xInter = (equationThis[1] - equationOther[1]) / helpInter;
        double yInter = (equationThis[0] * xInter) + equationThis[1];
        Point interPoint = new Point(xInter, yInter);

        //check if the intersection point is in the segments. if so, return this point.
        if (this.pointInSegment(interPoint) && other.pointInSegment(interPoint)) {
            return interPoint;
        }
        //else, there isn't an intersection point
        return null;
    }

    /**
     * check the minimum number in the array.
     *
     * @param num an array of numbers
     * @param max the numbers of limbs in the num array
     * @return the number of the place of the minimum non-negative number in the array
     */
    private int minPositiveNumber(double [] num, int max) {
        int smallest = 0, i;
        //check the minimum number
        for (i = 1; i < max; i++) {
            if (num[smallest] > num[i]) {
                smallest = i;
            }
        }
        //return the number of the place of the minimum number in the array
        return smallest;
    }

    /**
     * check if this line collide this rectangle.
     *
     * if so, return the closest point. if not, return null
     *
     * @param rect a rectangle to check the collision
     * @return the closest collision point, if there is not one-return null
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //send to a function that returns a list of intersection points
        List<Point> intersectionPoints = rect.intersectionPoints(this);
        //if the list is empty, there is not an intersection point, so return null
        if (intersectionPoints.isEmpty()) {
            return null;
        }
        // limbs for each collision points and distances
        double [] distances = new double [intersectionPoints.size()];
        Point [] points = new Point [intersectionPoints.size()];
        //for each intersection point save this poiint and the distance from the start of the line
        int i = 0;
        for (Point p : intersectionPoints) {
            distances[i] = this.start.distance(p);
            points[i] = p;
            i++;
        }
        //return the point that is closest to the line
        return points[minPositiveNumber(distances, i)];
    }
}
