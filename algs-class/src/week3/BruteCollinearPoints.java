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
    private ArrayList<LineSegment> segments = new ArrayList<>();

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new NullPointerException("Can't pass an array of null points");
        }
        points = Arrays.copyOf(points, points.length);
        Arrays.sort(points); // sort by Y, X
        if(hasDuplicates(points)) {
            throw new IllegalArgumentException("Can't have duplicate points");
        }
        double slopeIJ, slopeIK, slopeIL;

        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                slopeIJ = points[i].slopeTo(points[j]);
                for (int k = j + 1; k < points.length - 1; k++) {
                    slopeIK = points[i].slopeTo(points[k]);
                    // if 3 points are not collinear, we don't need to explore this path
                    if (slopeIJ != slopeIK) { continue; }
                    for (int l = k + 1; l < points.length; l++) {
                        slopeIL = points[i].slopeTo(points[l]);
                        // points are collinear
                        if (slopeIJ == slopeIK && slopeIJ == slopeIL) {
                            segments.add(new LineSegment(points[i], points[l]));
                        }
                    }
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.size();
    }

    // the line segments
    public LineSegment[] segments() {
        LineSegment[] arr = new LineSegment[segments.size()];
        return segments.toArray(arr);
    }
    
    private boolean hasDuplicates(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if(points[i].compareTo(points[i + 1]) == 0) {
                return true;
            }
        }
        return false;
    }
}
