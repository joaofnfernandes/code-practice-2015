package week3;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private ArrayList<LineSegment> segments = new ArrayList<>();

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null) {
            throw new NullPointerException("Can't pass an array of null points");
        }
        // Make a copy so we don't mutate input
        points = Arrays.copyOf(points, points.length);
        if(hasDuplicates(points)) {
            throw new IllegalArgumentException("Duplicate points not allowed");
        }
        // Segment needs at least 4 points
        for (int i = 0; i < points.length - 3; i++) {
            // Sort points by their natural order
            Arrays.sort(points);
            // sort by slope with i
            Arrays.sort(points, points[i].slopeOrder());
            findSegments(points);
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

    // Finds line segments starting on point i
    private void findSegments(Point[] points) {
        int p = 0, start = 1, end = 2;

        while (end < points.length) {
            // Find all line segments > 3 points
            while (end < points.length) {
                // Move to most distant point in the segment
                while (end < points.length
                        && Double.compare(points[p].slopeTo(points[start]),
                                points[p].slopeTo(points[end])) == 0) {
                    end++;
                }
                // If segment has 3 points, and we didn't saw it yet
                if (end - start >= 3 && points[p].compareTo(points[start]) < 0) {
                    segments.add(new LineSegment(points[p], points[end - 1]));
                }
                // Continue searching next segment
                start = end;
                end++;
            }
        }
    }
    
    private boolean hasDuplicates(Point[] points) {
        Arrays.sort(points);
        for (int i = 0; i < points.length - 1; i++) {
            if(points[i].compareTo(points[i + 1]) == 0) {
                return true;
            }
        }
        return false;
    }
}
