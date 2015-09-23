package week3;

import edu.princeton.cs.algs4.StdDraw;

public class LineSegment {
    public Point p, q;
    
    public LineSegment(Point p, Point q){
        this.p = p;
        this.q = q;
    }

    // draws this line segment
    public   void draw(){
        p.drawTo(q);
    }
    
    public String toString(){
        return p + " -> " + q;
    }
    
    public int hashCode() {
        throw new UnsupportedOperationException();
    }
 }
