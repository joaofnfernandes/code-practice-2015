package week3;

import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;

/*

    Corner cases. To avoid potential complications with integer overflow or
    floating-point precision, you may assume that the constructor arguments x and y are each between 0 and 32,767.
 */

public class Point implements Comparable<Point> {
    private static final int RADIUS = 1;
    private int x, y;
    
    // constructs the point (x, y)
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    // draws this point
    public void draw(){
        StdDraw.filledCircle(x, y, RADIUS);
    }

    // draws the line segment from this point to that point
    public   void drawTo(Point that){
        StdDraw.line(x, y, that.x, that.y);
    }
    
    // string representation
    public String toString() {
        return String.format("(%1$d,%2$d)", x, y);
    }

    // compare two points by y-coordinates, breaking ties by x-coordinates
    /* * The compareTo() method should compare points by their y-coordinates, breaking ties by their x-coordinates.
     * Formally, the invoking point (x0, y0) is less than the argument point (x1, y1) if and
     * only if either y0 < y1 or if y0 = y1 and x0 < x1.
     */
    public int compareTo(Point that){
        if(this.y < that.y) {
            return -1;
        } else if(this.y > that.y) {
            return 1;
        } else {
            if(this.x < that.x) {
                return -1;
            } else if(this.x > that.x) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    
    // the slope between this point and that point
    /*
     * The slopeTo() method should return the slope between the invoking point (x0, y0)
       and the argument point (x1, y1), which is given by the formula (y1 − y0) / (x1 − x0).
       Treat the slope of a horizontal line segment as positive zero;
       treat the slope of a vertical line segment as positive infinity;
       treat the slope of a degenerate line segment (between a point and itself) as negative infinity.
     */
    public double slopeTo(Point that){
        // same point
        if(this.compareTo(that) == 0) {
            return Double.NEGATIVE_INFINITY;
        }
        // horizontal line
        if(this.y == that.y) {
            return 0;
        }
        // vertical line
        if(this.x == that.x) {
            return Double.POSITIVE_INFINITY;
        }
        return (that.y - this.y) / (that.x - this.x);
    }
    
    // compare two points by slopes they make with this point
    /*
     *  The slopeOrder() method should return a comparator that compares its two argument points by the
        slopes they make with the invoking point (x0, y0).
        Formally, the point (x1, y1) is less than the point (x2, y2) if and only if the slope (y1 − y0) / (x1 − x0)
        is less than the slope (y2 − y0) / (x2 − x0).
        Treat horizontal, vertical, and degenerate line segments as in the slopeTo() method.
     */
    public Comparator<Point> slopeOrder(){ return new slopeComparator();}
    
    private class slopeComparator implements Comparator<Point> {

        @Override
        public int compare(Point p1, Point p2) {
            double slope01 = slopeTo(p1);
            double slope02 = slopeTo(p2);
            // same point
            if(compareTo(p1) == 0 && compareTo(p2) == 0) {
                return Integer.MIN_VALUE;
            }
            // Collinear horizontal points
            if(slope01 == 0 && slope02 == 0) {
                return 0;
            }
            // Collinear vertical points
            if(slope01 == Double.POSITIVE_INFINITY && slope02 == Double.POSITIVE_INFINITY) {
                return Integer.MAX_VALUE;
            }
            if(slope01 < slope02) {
                return -1;
            } else if(slope01 > slope02) {
                return 1;
            } else {
                return 0;
            }
        }
        
    }
 }
