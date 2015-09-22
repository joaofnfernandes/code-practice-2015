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
    public static final double threshold = 0.000001;
    ArrayList<LineSegment> pointList = new ArrayList<>();
    
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
                        // I and W are collinear and not the same point
                        if(slopeIJ.equals(slopeIK) && slopeIJ.equals(slopeIW) && 
                                slopeIJ.compareTo(Double.NEGATIVE_INFINITY) != 0) {
                            pointList.add(new LineSegment(points[i], points[w]));
                        }
                        
                    }
                }
                
            }
        }
    }
    
    // the number of line segments
    public int numberOfSegments(){
        return pointList.size();
    }
    
    // the line segments
    public LineSegment[] segments(){
        LineSegment[] segments = new LineSegment[pointList.size()];
        return pointList.toArray(segments);
    }
 }
