package week3;

import java.util.Arrays;
import java.util.ArrayList;

/*
 * Corner cases. Throw a java.lang.NullPointerException either the argument to the constructor is null
 * or if any point in the array is null. Throw a java.lang.IllegalArgumentException if the argument
 * to the constructor contains a repeated point.

    Performance requirement. The order of growth of the running time of your program should be N4
    in the worst case and it should use space proportional to N plus the number of line segments returned.
 */
public class BruteCollinearPoints {
    ArrayList<LineSegment> segments = new ArrayList<>();
    
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points){
        if(points == null) {
            throw new NullPointerException("Can't pass an array of null points");
        }
        Arrays.sort(points); // sort by Y, X
        Double slopeIJ, slopeIK, slopeIW;
        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                slopeIJ = points[i].slopeTo(points[j]);
                for (int k = j + 1; k < points.length - 1; k++) {
                    slopeIK = points[i].slopeTo(points[k]);
                    // if 3 points are not collinear, we don't need to check 4th point
                    if(!slopeIJ.equals(slopeIK)){
                        continue;
                    }
                    for (int w = k + 1; w < points.length; w++) {
                        slopeIW = points[i].slopeTo(points[w]);
                        // points are collinear but not the same point
                        if(slopeIJ.equals(slopeIK) && slopeIJ.equals(slopeIW) && 
                                slopeIJ.compareTo(Double.NEGATIVE_INFINITY) != 0) {
                            addSegmentIfUnique(new LineSegment(points[i], points[w]));
                        }
                        
                    }
                }
                
            }
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
    
    private void addSegmentIfUnique(LineSegment s) {
        // if is same point, don't add it
        if(Double.compare(getLineSlope(s), Double.NEGATIVE_INFINITY) == 0) {
            return;
        }
        int i = 0;
        double segment1Slope = 0, segment2Slope = 0;
        for (i = 0; i < segments.size(); i++) {
            segment1Slope = getLineSlope(segments.get(i));
            segment2Slope = getLineSlope(s);
            
            // if segment has same slope and starts at same point, update with longer segment
            if(Double.compare(segment1Slope, segment2Slope) == 0 &&
                    (segments.get(i).p.compareTo(s.q) == 0 || 
                    segments.get(i).q.compareTo(s.q) == 0)) {
                segments.set(i, s);
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
