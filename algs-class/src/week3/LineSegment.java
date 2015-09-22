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
        StdDraw.line(p.x, p.y, q.x, q.y);
    }
    
    public String toString(){
        return String.format("%s-%s", p.toString(), q.toString());
    }
 }
