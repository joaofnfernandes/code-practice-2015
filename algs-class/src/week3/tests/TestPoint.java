package week3.tests;

import java.util.Comparator;

import org.junit.Test;

import week3.Point;
import static org.junit.Assert.*;

public class TestPoint {

    private Point p = new Point(0, 0);
    
    private Point n = new Point(0, 1);
    private Point s = new Point(0, -1);
    private Point w = new Point(-1, 0);
    private Point e = new Point(1, 0);
    
    private Point ne = new Point(1, 1);
    private Point se = new Point(1, -1);
    private Point nw = new Point(-1, 1);
    private Point sw = new Point(-1, -1);
    
    @Test
    public void TestPointCompareTo() {
        // self
        assertEquals(0, p.compareTo(p));
        
        // colinear
        assertEquals(-1, p.compareTo(n));
        assertEquals(1, p.compareTo(s));
        assertEquals(1, p.compareTo(w));
        assertEquals(-1, p.compareTo(e));
        
        //non-colinear
        assertEquals(-1, p.compareTo(ne));
        assertEquals(1, p.compareTo(se));
        assertEquals(-1, p.compareTo(nw));
        assertEquals(1, p.compareTo(sw));
    }
    
    @Test
    public void TestPointSlopeTo(){
        // self
        assertEquals(Double.NEGATIVE_INFINITY, p.slopeTo(p), 0);
        
        // colinear
        assertEquals(Double.POSITIVE_INFINITY, p.slopeTo(n), 0);
        assertEquals(Double.POSITIVE_INFINITY, p.slopeTo(s), 0);
        assertEquals(0, p.slopeTo(w), 0);
        assertEquals(0, p.slopeTo(e), 0);
        
        // non-colinear
        assertEquals(1, p.slopeTo(ne), 0);
        assertEquals(-1, p.slopeTo(se), 0);
        assertEquals(-1, p.slopeTo(nw), 0);
        assertEquals(1, p.slopeTo(sw), 0);
    }
    
    @Test
    public void TestPointSlopeOrder(){
        Comparator<Point> slopeComparator = p.slopeOrder();
        
        // same point
        assertEquals(0, slopeComparator.compare(p, p));
        
        
        // colinear vertical
        assertEquals(0, slopeComparator.compare(n, n));
        Point n2 = new Point(0, 2);
        assertEquals(0, slopeComparator.compare(n, n2));
        assertEquals(0, slopeComparator.compare(n2, n));
        
        assertEquals(0, slopeComparator.compare(s, s));
        Point s2 = new Point(0, -2);
        assertEquals(0, slopeComparator.compare(s, s2));
        assertEquals(0, slopeComparator.compare(s2, s));
        
        // colinear horizontal
        assertEquals(0, slopeComparator.compare(w, w));
        Point w2 = new Point(-2, 0);
        assertEquals(0, slopeComparator.compare(w, w2));
        assertEquals(0, slopeComparator.compare(w2, w));
        
        assertEquals(0, slopeComparator.compare(e, e));
        Point e2 = new Point(2, 0);
        assertEquals(0, slopeComparator.compare(e, e2));
        assertEquals(0, slopeComparator.compare(e2, e));
        
        // non-colinear, horizontal/ vertical
        assertEquals(-1, slopeComparator.compare(e, n));
        assertEquals(-1, slopeComparator.compare(e, s));
        assertEquals(-1, slopeComparator.compare(w, n));
        assertEquals(-1, slopeComparator.compare(w, s));
        
        // non-colinear, vertical / horizontal
        assertEquals(1, slopeComparator.compare(n, e));
        assertEquals(1, slopeComparator.compare(s, e));
        assertEquals(1, slopeComparator.compare(n, w));
        assertEquals(1, slopeComparator.compare(s, w));
    }
}
