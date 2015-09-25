package week3;

public class LineSegment implements Comparable<LineSegment> {
    private final Point p;
    private final Point q;

    public LineSegment(Point p, Point q) {
        if (p == null || q == null) {
            throw new NullPointerException("argument is null");
        }
        this.p = p;
        this.q = q;
    }

    // draws this line segment
    public void draw() {
        p.drawTo(q);
    }

    public String toString() {
        return p + " -> " + q;
    }

    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int compareTo(LineSegment that) {
        if (that == null) {
            return 1;
        } else if (this == that) {
            return 0;
        } else if ((p.compareTo(that.p) == 0 && q.compareTo(that.q) == 0)
                || (p.compareTo(that.q) == 0 && q.compareTo(that.p) == 0)) {
            return 0;
        } else {
            int yComparison = q.compareTo(that.q);
            int xComparison = p.compareTo(p);
            if (yComparison < 0) {
                return -1;
            } else if (yComparison > 0) {
                return 1;
            } else {
                if (xComparison < 0) {
                    return -1;
                } else if (xComparison > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}
