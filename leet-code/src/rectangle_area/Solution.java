package rectangle_area;

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G,
            int H) {
        Rectangle a = new Rectangle(A, B, C, D);
        Rectangle b = new Rectangle(E, F, G, H);
        Rectangle intersection = a.getIntersection(b);
        int area = a.getArea() + b.getArea() - intersection.getArea();
        return area;
    }

    private static class Rectangle implements Comparable<Rectangle> {
        
        private int bottomLeftX;
        private int bottomLeftY;
        private int topRightX;
        private int topRightY;

        private Rectangle(int bottomLeftX, int bottomLeftY, int topRightX,
                int topRightY) {
            this.bottomLeftX = bottomLeftX;
            this.bottomLeftY = bottomLeftY;
            this.topRightX = topRightX;
            this.topRightY = topRightY;
        }
        
        private Rectangle EMPTY() {
            return new Rectangle(0,0,0,0);
        }
        

        // Returns the rectangle with the intersection, or null if there is none
        private Rectangle getIntersection(Rectangle other) {
            // sort rectangles by Y coord
            int cmp = this.compareTo(other);
            if (cmp > 0) {
                return other.getIntersection(this);
            }
            // intersects on the Y coord
            if (other.bottomLeftY < this.topRightY) {
                // intersects on the X coord
                if (other.topRightX > this.bottomLeftX
                        && other.bottomLeftX < this.topRightX) {
                    int intersectBottomY = Math.max(this.bottomLeftY,
                            other.bottomLeftY);
                    int intersectTopY = Math.min(this.topRightY,
                            other.topRightY);
                    int intersectLeftX = Math.max(this.bottomLeftX,
                            other.bottomLeftX);
                    int intersectRightX = Math.min(this.topRightX,
                            other.topRightX);
                    return new Rectangle(intersectLeftX, intersectBottomY,
                            intersectRightX, intersectTopY);
                } else {
                    return EMPTY();
                }
            } else {
                return EMPTY();
            }
        }

        private int getArea() {
            return (topRightX - bottomLeftX) * (topRightY - bottomLeftY);
        }

        @Override
        public int compareTo(Rectangle other) {
            int cmp = this.bottomLeftY - other.bottomLeftY;
            if (cmp < 0) {
                return -1;
            } else if (cmp > 0) {
                return 1;
            } else {
                cmp = this.bottomLeftX - other.bottomLeftX;
                if (cmp < 0) {
                    return -1;
                } else if (cmp > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}