package week3;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestFastCollinearPoints {
    
    @Test
    public void TestSamePoint() {
        FastCollinearPoints collinearPoints;
        
        Point[] samePoint = new Point[] {
                new Point(0,0),new Point(0,0),new Point(0,0),new Point(0,0),
                new Point(1,1), new Point(2,2)
        };
        collinearPoints = new FastCollinearPoints(samePoint);
        assertEquals(0, collinearPoints.numberOfSegments());
    }
    
    @Test
    public void TestNoLineSegments(){
        FastCollinearPoints collinearPoints;
        
        Point[] collinearPoints2 = new Point[] {
                new Point(1,1),
                new Point(-1,-1),
                new Point(-1, 1),
                new Point(1, -1)
        };
        collinearPoints = new FastCollinearPoints(collinearPoints2);
        assertEquals(0, collinearPoints.numberOfSegments());
        
        Point[] collinearHorizontalPoints3 = new Point[] {
                new Point(-1,0),
                new Point(0,0),
                new Point(1,0),
                new Point(1,1)
        };
        collinearPoints = new FastCollinearPoints(collinearHorizontalPoints3);
        assertEquals(0, collinearPoints.numberOfSegments());
        
        Point[] collinearVerticalPoints3 = new Point[] {
                new Point(0,1),
                new Point(0,0),
                new Point(0,-1),
                new Point(1,1)
        };
        collinearPoints = new FastCollinearPoints(collinearVerticalPoints3);
        assertEquals(0, collinearPoints.numberOfSegments());
        
        Point[] collinearDiagPoints3 = new Point[] {
                new Point(-1,-1),
                new Point(0, 0),
                new Point(1, 1),
                new Point(-1,1)
        };
        collinearPoints = new FastCollinearPoints(collinearDiagPoints3);
        assertEquals(0, collinearPoints.numberOfSegments());
    }
    
    @Test
    public void Test1LineSegment() {
        FastCollinearPoints collinearPoints;
        LineSegment seg;

        
        Point[] collinearHorizontalPoints4 = new Point[] {
                new Point(-1,0), new Point(0,0), new Point(1,0), new Point(2, 0), new Point(3,0),
                new Point(1, 1)
        };
        seg = new LineSegment(collinearHorizontalPoints4[0], collinearHorizontalPoints4[4]);
        collinearPoints = new FastCollinearPoints(collinearHorizontalPoints4);
        assertEquals(1, collinearPoints.numberOfSegments());
        assertTrue(isSameLineSegment(seg, collinearPoints.segments()[0]));
        
        Point[] collinearVerticalPoints4 = new Point[] {
                new Point(0,-1), new Point(0,0), new Point(0,1), new Point(0, 2), new Point(0,3),
                new Point(1, 1)
        };
        seg = new LineSegment(collinearVerticalPoints4[0], collinearVerticalPoints4[4]);
        collinearPoints = new FastCollinearPoints(collinearVerticalPoints4);
        assertEquals(1, collinearPoints.numberOfSegments());
        assertTrue(isSameLineSegment(seg, collinearPoints.segments()[0]));
        
        Point[] collinearDiagPoints4 = new Point[] {
                new Point(-1,-1), new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(3,3),
                new Point (-1, 1)
        };
        seg = new LineSegment(collinearDiagPoints4[0], collinearDiagPoints4[4]);
        collinearPoints = new FastCollinearPoints(collinearDiagPoints4);
        assertEquals(1, collinearPoints.numberOfSegments());
        assertTrue(isSameLineSegment(seg, collinearPoints.segments()[0]));
    }
    
    @Test
    public void Test2ParalelLineSegments() {
        FastCollinearPoints collinearPoints;
        LineSegment[] segments = null;

        Point[] collinearHorizontalPoints4 = new Point[] {
                new Point(-1,0),new Point(0,0),new Point(1,0),new Point(2, 0), new Point(3,0),
                new Point(-1,1),new Point(0,1),new Point(1,1),new Point(2, 1),
                new Point(2, 2)
        };
        segments = new LineSegment[] {
                new LineSegment(collinearHorizontalPoints4[0], collinearHorizontalPoints4[4]),
                new LineSegment(collinearHorizontalPoints4[5], collinearHorizontalPoints4[8])
        };
        collinearPoints = new FastCollinearPoints(collinearHorizontalPoints4);
        assertEquals(2, collinearPoints.numberOfSegments());
        assertTrue(areSameSegments(segments, collinearPoints.segments()));
        
        
        Point[] collinearVerticalPoints4 = new Point[] {
                new Point(0,-1), new Point(0,0),new Point(0,1), new Point(0, 2), new Point(0,3),
                new Point(1,-1), new Point(1,0),new Point(1,1), new Point(1, 2),
                new Point(2, 2)
        };
        segments = new LineSegment[] {
                new LineSegment(collinearVerticalPoints4[0], collinearVerticalPoints4[4]),
                new LineSegment(collinearVerticalPoints4[5], collinearVerticalPoints4[8])
        };
        collinearPoints = new FastCollinearPoints(collinearVerticalPoints4);
        assertEquals(2, collinearPoints.numberOfSegments());
        assertTrue(areSameSegments(segments, collinearPoints.segments()));
        
        
        Point[] collinearDiagPoints4 = new Point[] {
                new Point(-1,-1), new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(3,3),
                new Point(-1,-2), new Point(0, -1), new Point(1, 0), new Point(2, 1),
                new Point (1, - 1)
        };
        segments = new LineSegment[] {
                new LineSegment(collinearDiagPoints4[0], collinearDiagPoints4[4]),
                new LineSegment(collinearDiagPoints4[5], collinearDiagPoints4[8]),
        };
        collinearPoints = new FastCollinearPoints(collinearDiagPoints4);
        assertEquals(2, collinearPoints.numberOfSegments());
        assertTrue(areSameSegments(segments, collinearPoints.segments()));
    }
    
    @Test
    public void Test2PerpendicularLineSegments() {
        FastCollinearPoints collinearPoints;
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
        collinearPoints = new FastCollinearPoints(collinearHorizontalPoints4);
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
        collinearPoints = new FastCollinearPoints(collinearVerticalPoints4);
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
