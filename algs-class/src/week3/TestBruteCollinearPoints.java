package week3;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestBruteCollinearPoints {
    
    @Test
    public void TestSamePoint() {
        BruteCollinearPoints collinearPoints;
        
        Point[] samePoint = new Point[] {
                new Point(0,0),new Point(0,0),new Point(0,0),new Point(0,0),
                new Point(1,1), new Point(2,2)
        };
        collinearPoints = new BruteCollinearPoints(samePoint);
        assertEquals(0, collinearPoints.numberOfSegments());
    }
    
    @Test
    public void TestNoLineSegments(){
        BruteCollinearPoints collinearPoints;
        
        Point[] collinearPoints2 = new Point[] {
                new Point(1,1),
                new Point(-1,-1),
                new Point(-1, 1),
                new Point(1, -1)
        };
        collinearPoints = new BruteCollinearPoints(collinearPoints2);
        assertEquals(0, collinearPoints.numberOfSegments());
        
        Point[] collinearHorizontalPoints3 = new Point[] {
                new Point(-1,0),
                new Point(0,0),
                new Point(1,0),
                new Point(1,1)
        };
        collinearPoints = new BruteCollinearPoints(collinearHorizontalPoints3);
        assertEquals(0, collinearPoints.numberOfSegments());
        
        Point[] collinearVerticalPoints3 = new Point[] {
                new Point(0,1),
                new Point(0,0),
                new Point(0,-1),
                new Point(1,1)
        };
        collinearPoints = new BruteCollinearPoints(collinearVerticalPoints3);
        assertEquals(0, collinearPoints.numberOfSegments());
        
        Point[] collinearDiagPoints3 = new Point[] {
                new Point(-1,-1),
                new Point(0, 0),
                new Point(1, 1),
                new Point(-1,1)
        };
        collinearPoints = new BruteCollinearPoints(collinearDiagPoints3);
        assertEquals(0, collinearPoints.numberOfSegments());
    }
    
    @Test
    public void Test1LineSegment() {
        BruteCollinearPoints collinearPoints;
        LineSegment seg;

        
        Point[] collinearHorizontalPoints4 = new Point[] {
                new Point(-1,0),
                new Point(0,0),
                new Point(1,0),
                new Point(2, 0),
                new Point(1, 1)
        };
        seg = new LineSegment(collinearHorizontalPoints4[0], collinearHorizontalPoints4[3]);
        collinearPoints = new BruteCollinearPoints(collinearHorizontalPoints4);
        assertEquals(1, collinearPoints.numberOfSegments());
        assertTrue(isSameLineSegment(seg, collinearPoints.segments()[0]));
        
        Point[] collinearVerticalPoints4 = new Point[] {
                new Point(0,-1),
                new Point(0,0),
                new Point(0,1),
                new Point(0, 2),
                new Point(1, 1)
        };
        seg = new LineSegment(collinearVerticalPoints4[0], collinearVerticalPoints4[3]);
        collinearPoints = new BruteCollinearPoints(collinearVerticalPoints4);
        assertEquals(1, collinearPoints.numberOfSegments());
        assertTrue(isSameLineSegment(seg, collinearPoints.segments()[0]));
        
        Point[] collinearDiagPoints4 = new Point[] {
                new Point(-1,-1),
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2),
                new Point (-1, 1)
        };
        seg = new LineSegment(collinearDiagPoints4[0], collinearDiagPoints4[3]);
        collinearPoints = new BruteCollinearPoints(collinearDiagPoints4);
        assertEquals(1, collinearPoints.numberOfSegments());
        assertTrue(isSameLineSegment(seg, collinearPoints.segments()[0]));
    }
    
    @Test
    public void Test2ParalelLineSegments() {
        BruteCollinearPoints collinearPoints;
        LineSegment[] segments = null;

        Point[] collinearHorizontalPoints4 = new Point[] {
                new Point(-1,0),new Point(0,0),new Point(1,0),new Point(2, 0),
                new Point(-1,1),new Point(0,1),new Point(1,1),new Point(2, 1),
                new Point(2, 2)
        };
        segments = new LineSegment[] {
                new LineSegment(collinearHorizontalPoints4[0], collinearHorizontalPoints4[3]),
                new LineSegment(collinearHorizontalPoints4[4], collinearHorizontalPoints4[7])
        };
        collinearPoints = new BruteCollinearPoints(collinearHorizontalPoints4);
        assertEquals(2, collinearPoints.numberOfSegments());
        assertTrue(areSameSegments(segments, collinearPoints.segments()));
        
        
        Point[] collinearVerticalPoints4 = new Point[] {
                new Point(0,-1), new Point(0,0),new Point(0,1), new Point(0, 2),
                new Point(1,-1), new Point(1,0),new Point(1,1), new Point(1, 2),
                new Point(2, 2)
        };
        segments = new LineSegment[] {
                new LineSegment(collinearVerticalPoints4[0], collinearVerticalPoints4[3]),
                new LineSegment(collinearVerticalPoints4[4], collinearVerticalPoints4[7])
        };
        collinearPoints = new BruteCollinearPoints(collinearVerticalPoints4);
        assertEquals(2, collinearPoints.numberOfSegments());
        assertTrue(areSameSegments(segments, collinearPoints.segments()));
        
        
        Point[] collinearDiagPoints4 = new Point[] {
                new Point(-1,-1), new Point(0, 0), new Point(1, 1), new Point(2, 2),
                new Point(-1,-2), new Point(0, -1), new Point(1, 0), new Point(2, 1),
                new Point (1, - 1)
        };
        segments = new LineSegment[] {
                new LineSegment(collinearDiagPoints4[0], collinearDiagPoints4[3]),
                new LineSegment(collinearDiagPoints4[4], collinearDiagPoints4[7]),
        };
        collinearPoints = new BruteCollinearPoints(collinearDiagPoints4);
        assertEquals(2, collinearPoints.numberOfSegments());
        assertTrue(areSameSegments(segments, collinearPoints.segments()));
    }
    
    @Test
    public void Test2PerpendicularLineSegments() {
        BruteCollinearPoints collinearPoints;
        LineSegment[] segments = null;

        Point[] collinearHorizontalPoints4 = new Point[] {
                new Point(-1,0),new Point(0,0),new Point(1,0),new Point(2, 0),
                new Point(0,-1),new Point(0,1),new Point(0,2),
                new Point(2, 2)
        };
        segments = new LineSegment[] {
                new LineSegment(collinearHorizontalPoints4[0], collinearHorizontalPoints4[3]),
                new LineSegment(collinearHorizontalPoints4[4], collinearHorizontalPoints4[6])
        };
        collinearPoints = new BruteCollinearPoints(collinearHorizontalPoints4);
        assertEquals(2, collinearPoints.numberOfSegments());
        assertTrue(areSameSegments(segments, collinearPoints.segments()));
        
        Point[] collinearVerticalPoints4 = new Point[] {
                new Point(0,-1), new Point(0,0),new Point(0,1), new Point(0, 2),
                new Point(-1,1),new Point(1,-1), new Point(2, -2),
                new Point(2, 0)
        };
        segments = new LineSegment[] {
                new LineSegment(collinearVerticalPoints4[0], collinearVerticalPoints4[3]),
                new LineSegment(collinearVerticalPoints4[4], collinearVerticalPoints4[6])
        };
        collinearPoints = new BruteCollinearPoints(collinearVerticalPoints4);
        assertEquals(2, collinearPoints.numberOfSegments());
        assertTrue(areSameSegments(segments, collinearPoints.segments()));
    }
    

    private boolean areSameSegments(LineSegment[] arr1, LineSegment[] arr2) {
        if(arr1.length != arr2.length) {
            return false;
        } else {
            boolean sameSegment = false;
            for (int i = 0; i < arr1.length; i++) {
                sameSegment = false;
                for (int j = 0; j < arr2.length; j++) {
                    if(isSameLineSegment(arr1[i], arr2[j])) {
                        sameSegment = true;
                        break;
                     }
                }
                if(!sameSegment) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isSameLineSegment(LineSegment seg1, LineSegment seg2) {
        if((seg1.p.compareTo(seg2.p) == 0 && seg1.q.compareTo(seg2.q) == 0) ||
            (seg1.p.compareTo(seg2.q) == 0) && seg1.q.compareTo(seg2.p) == 0) {
            return true;
        }
        return false;
    }

}
