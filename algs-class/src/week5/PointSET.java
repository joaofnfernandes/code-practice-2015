package week5;

import java.util.Comparator;
import java.util.TreeSet;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;


/*
 * Corner cases.  Throw a java.lang.NullPointerException if any argument is null.
 * 
 * Performance requirements.  Your implementation should support insert() and contains()
 * in time proportional to the logarithm of the number of points in the set in the worst case;
 * it should support nearest() and range() in time proportional to the number of points in the set.
 */
public class PointSET {
    private TreeSet<Point2D> points;
    
    // construct an empty set of points
    public PointSET(){
        points = new TreeSet<Point2D>();
    }

    // is the set empty?
    public boolean isEmpty(){
        return points.isEmpty();
    } 
    
    // number of points in the set 
    public int size(){
        return points.size();
    }
    
    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p){
        // Should we make a defensive copy?
        points.add(p);
    }
    
    // does the set contain point p?
    public boolean contains(Point2D p){
        if(p == null) {
            throw new NullPointerException("Can't compare with null");
        }
        return points.contains(p);
    }
    
    // draw all points to standard draw
    public void draw(){
        for (Point2D point : points) {
            point.draw();
        }
    }
    
    // all points that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect){
        if(rect == null) {
            throw new NullPointerException("Can't compare with null");
        }
        if(rect.xmin() > rect.xmax() || rect.ymin() > rect.ymax()) {
            throw new IllegalArgumentException("Invalid rectangle");
        }
        Queue<Point2D> pointsInRectangle = new Queue<Point2D>();
        for (Point2D point : points) {
            if(rect.distanceTo(point) == 0) {
                pointsInRectangle.enqueue(point);
            }
        }
        return pointsInRectangle;
    }
    
    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p){
        if(p == null) {
            throw new NullPointerException("Can't compare with null");
        }
        if(points.isEmpty()) {
            return null;
        } else {
            // todo: don't use distanceTo order
            TreeSet<Point2D> pointsByDistance = new TreeSet<Point2D>(new DistanceToOrder(p));
            for (Point2D point : points) {
                pointsByDistance.add(point);
            }
            Point2D nearestPoint = null;
            if(!pointsByDistance.isEmpty()) {
                nearestPoint = pointsByDistance.first();
            }
            return nearestPoint;
        }
    }
    
    private static class DistanceToOrder implements Comparator<Point2D> {

        private Point2D point;
        
        private DistanceToOrder(Point2D point) {
            this.point = point;
        }
        
        @Override
        public int compare(Point2D p, Point2D q) {
            double distanceToP = point.distanceSquaredTo(p);
            double distanceToQ = point.distanceSquaredTo(q);
            if(distanceToP < distanceToQ) {
                return -1;
            } else if(distanceToP > distanceToQ) {
                return 1;
            } else {
                return 0;
            }
        }
        
    }

}
