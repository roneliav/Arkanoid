// ID: 208461228
package geometryprimitives;

import java.util.ArrayList;
import java.util.List;

/**
 * A class of rectangle.
 *
 * there are some shapes of rectangle
 *
 */
public class Rectangle {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * A constructor.
     *
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft an upper-left point of the rectangle
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }


    /**
     * Return a (possibly empty) List of intersection points with the specified line.
     *
     * The function check for everyy 'limit' line if there is an intesection between this lines.
     *
     * @param line a line
     * @return a list of intersection points, meanwhile it's null because it is useless
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPoints = new ArrayList<Point>();
        Point rectEdge = this.getUpperLeft();
        //make 4 'limit' lines
        Line lineUp = new Line(rectEdge, new Point(rectEdge.getX() + this.width, rectEdge.getY()));
        Line lineDown = new Line(rectEdge.getX(), rectEdge.getY() + this.height,
                rectEdge.getX() + this.width, rectEdge.getY() + this.height);
        Line lineLeft = new Line(rectEdge, new Point(rectEdge.getX(), rectEdge.getY() + this.height));
        Line lineRight = new Line(rectEdge.getX() + this.width, rectEdge.getY(),
                rectEdge.getX() + this.width, rectEdge.getY() + this.height);
        //make an array from the 4 limits
        Line [] lines = {lineUp, lineDown, lineLeft, lineRight};
        //for each line check if there is an intersection.
        for (int i = 0; i < 4; i++) {
            //if so, put the collision point and the distance between the lines in there arrays
            if (line.isIntersecting(lines[i])) {
                 intersectionPoints.add(line.intersectionWith(lines[i]));
            }
        }
        return intersectionPoints;
    }

    /**
     *
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     *
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     *
     * @return the upper-left point of the rectangle
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}