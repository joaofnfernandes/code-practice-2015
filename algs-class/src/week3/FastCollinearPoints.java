package week3;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    ArrayList<LineSegment> segments = new ArrayList<>();
    
    
    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points){
        if(points == null) {
            throw new NullPointerException("Can't pass an array of null points");
        }
        for (int i = 0; i < points.length; i++) {
            // Sort points by their natural order
            Arrays.sort(points, i, points.length);
            // sort by slope with i
            Arrays.sort(points, i + 1, points.length, points[i].slopeOrder());
            findSegments(points, i);
        }
    }
    
    // the number of line segments
    public int numberOfSegments(){
        return segments.size();
    }
    
    // the line segments
    public LineSegment[] segments(){
        LineSegment[] arr = new LineSegment[segments.size()];
        return segments.toArray(arr);
    }
    
    // Finds line segments starting on a position
    private void findSegments(Point[] points, int i) {
        if(points.length - i < 4) {
            return;
        }
        int start = i + 1, end = i + 2;
        while(end < points.length){
            while(end < points.length && Double.compare(points[i].slopeTo(points[start]),
                    points[i].slopeTo(points[end])) == 0) {
                end++;
            }
            if((end - start) >= 3 ) {
                addSegmentIfUnique(getLongerLineSegment(points, i, start, end));
            }
            start = end;
            end++;
        }
    }
    
    private LineSegment getLongerLineSegment(Point[] points, int i, int start, int end) {
        int max = start;
        for (int j = start; j < end ; j++) {
            if(Double.compare(euclideanDistance(points[i], points[j]),
                              euclideanDistance(points[i], points[max])) > 0) {
                max = j;
            }
        }
        return new LineSegment(points[i], points[max]);
    }
    
    private void addSegmentIfUnique(LineSegment s) {
        // if is same point, don't add it
        if(Double.compare(getLineSlope(s), Double.NEGATIVE_INFINITY) == 0) {
            return;
        }
        // if segment has same slope and ends in same point, it's a subsegment?
        for (int i = 0; i < segments.size(); i++) {
            if(Double.compare(getLineSlope(segments.get(i)), getLineSlope(s)) == 0 &&
                    (segments.get(i).p.compareTo(s.q) == 0 || 
                    segments.get(i).q.compareTo(s.q) == 0)) {
                return;
            }
        }
        segments.add(s);
    }
    
    private double euclideanDistance(Point p, Point q) {
        return Math.sqrt(Math.pow((q.x - p.x), 2) + Math.pow((q.y - p.y), 2));
    }
    
    private int lineLengthComparator(LineSegment s1, LineSegment s2) {
        double lengthS1 = euclideanDistance(s1.p, s1.q);
        double lengthS2 = euclideanDistance(s2.p, s2.q);
        return Double.compare(lengthS1, lengthS2);
    }
    
    private double getLineSlope(LineSegment s) {
        return s.p.slopeTo(s.q);
    }
 }
