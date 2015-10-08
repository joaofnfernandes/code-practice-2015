package week5;

import java.util.Comparator;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {
    private static final Point2D CANVAS_BOTTOM_LEFT = new Point2D(0, 0);
    private static final Point2D CANVAS_TOP_RIGHT = new Point2D(1, 1);
    private static final Comparator<Point2D> X_ORDER = new X_Order();
    private static final Comparator<Point2D> Y_ORDER = new Y_Order();

    private int size = 0;
    private Node root = null;

    // construct an empty set of points
    public KdTree() {
    }

    // is the set empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // number of points in the set
    public int size() {
        return size;
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Can't compare with null");
        }
        root = insert(root, null, 0, p);
    }

    private Node insert(Node node, Node parent, int depth, Point2D point) {
        if (node == null) {
            Node newNode = new Node(point);
            size++;
            RectHV rect = null;

            // find node rectangle
            if (depth == 0) {
                rect = new RectHV(CANVAS_BOTTOM_LEFT.x(),
                        CANVAS_BOTTOM_LEFT.y(), CANVAS_TOP_RIGHT.x(),
                        CANVAS_TOP_RIGHT.y());
            } else if (depth % 2 == 0) {
                // below parent
                if (Y_ORDER.compare(point, parent.point) < 0) {
                    rect = new RectHV(parent.rect.xmin(), parent.rect.ymin(),
                            parent.rect.xmax(), parent.point.y());
                } else {
                    rect = new RectHV(parent.rect.xmin(), parent.point.y(),
                            parent.rect.xmax(), parent.rect.ymax());
                }
            } else {
                // to the left of parent
                if (X_ORDER.compare(point, parent.point) < 0) {
                    rect = new RectHV(parent.rect.xmin(), parent.rect.ymin(),
                            parent.point.x(), parent.rect.ymax());
                } else {
                    rect = new RectHV(parent.point.x(), parent.rect.ymin(),
                            parent.rect.xmax(), parent.rect.ymax());
                }
            }

            newNode.rect = rect;
            return newNode;
        } else {
            int cmp;
            if (depth % 2 == 0) {
                cmp = X_ORDER.compare(point, node.point);
            } else {
                cmp = Y_ORDER.compare(point, node.point);
            }
            if (cmp < 0) {
                node.leftOrBottom = insert(node.leftOrBottom, node, depth + 1,
                        point);
            } else if (cmp > 0) {
                node.RightOrTop = insert(node.RightOrTop, node, depth + 1,
                        point);
            } else {
                // same point, do nothing
            }
            return node;
        }
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Can't compare with null");
        }
        return contains(root, 0, p);
    }

    private boolean contains(Node node, int depth, Point2D point) {
        if (node == null) {
            return false;
        } else {
            int cmp;
            if (depth % 2 == 0) {
                cmp = X_ORDER.compare(point, node.point);
            } else {
                cmp = Y_ORDER.compare(point, node.point);
            }
            if (cmp < 0) {
                return contains(node.leftOrBottom, depth + 1, point);
            } else if (cmp > 0) {
                return contains(node.RightOrTop, depth + 1, point);
            } else {
                return true;
            }
        }
    }

    // draw all points to standard draw
    public void draw() {
        draw(root, 0);
    }

    private void draw(Node node, int depth) {
        // in-order transversal
        // todo: draw rectangle
        if (node != null) {
            draw(node.leftOrBottom, depth + 1);
            drawSelf(node, depth);
            draw(node.RightOrTop, depth + 1);
        }
    }

    private void drawSelf(Node node, int depth) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.01);
        node.point.draw();

        StdDraw.setPenRadius();
        Point2D p1, p2;
        if (depth % 2 == 0) {
            StdDraw.setPenColor(StdDraw.RED);
            p1 = new Point2D(node.point.x(), node.rect.ymin());
            p2 = new Point2D(node.point.x(), node.rect.ymax());
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            p1 = new Point2D(node.rect.xmin(), node.point.y());
            p2 = new Point2D(node.rect.xmax(), node.point.y());
        }
        StdDraw.line(p1.x(), p1.y(), p2.x(), p2.y());
    }

    /*
     * Returns all points that are inside a rectangle
     * 
     * start at the root and recursively search for points in both subtrees
     * using the following pruning rule: if the query rectangle does not
     * intersect the rectangle corresponding to a node, there is no need to
     * explore that node (or its subtrees). A subtree is searched only if it
     * might contain a point contained in the query rectangle.
     */
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new NullPointerException("Can't compare with null");
        }
        if (rect.xmin() > rect.xmax() || rect.ymin() > rect.ymax()) {
            throw new IllegalArgumentException("Invalid rectangle");
        }
        Queue<Point2D> points = new Queue<Point2D>();
        range(root, points, rect);
        return points;
    }

    private void range(Node node, Queue<Point2D> queue, RectHV rect) {
        if (node != null && rect.intersects(node.rect)) {
            if (rect.contains(node.point)) {
                queue.enqueue(node.point);
            }
            range(node.leftOrBottom, queue, rect);
            range(node.RightOrTop, queue, rect);
        }
    }

    /*
     * start at the root and recursively search in both subtrees using the
     * following pruning rule: if the closest point discovered so far is closer
     * than the distance between the query point and the rectangle corresponding
     * to a node, there is no need to explore that node (or its subtrees).
     * 
     * That is, a node is searched only if it might contain a point that is
     * closer than the best one found so far.
     * 
     * The effectiveness of the pruning rule depends on quickly finding a nearby
     * point. To do this, organize your recursive method so that when there are
     * two possible subtrees to go down, you always choose the subtree that is
     * on the same side of the splitting line as the query point as the first
     * subtree to explore—the closest point found while exploring the first
     * subtree may enable pruning of the second subtree.
     */
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Can't compare with null");
        }
        return nearest(root, null, 0, p);
    }

    private Point2D nearest(Node node, Point2D nearestSoFar, int depth, Point2D point) {
        if (node == null) {
            return nearestSoFar;
        }
        if(nearestSoFar == null) {
            nearestSoFar = node.point;
        }
        
        double distanceToNodeRect = node.rect.distanceSquaredTo(point);
        double distanceToNearestPoint = nearestSoFar.distanceSquaredTo(point);
        double distanceToNodePoint, distanceToSubtreePoint;

        // Explore node and its subtrees
        if (distanceToNodeRect < distanceToNearestPoint) {
            distanceToNodePoint = node.point.distanceSquaredTo(point);
            // Update nearest point
            if (distanceToNodePoint < distanceToNearestPoint) {
                nearestSoFar = node.point;
                distanceToNearestPoint = distanceToNodePoint;
            }
            
            int cmp;
            if (depth % 2 == 0) {
                cmp = X_ORDER.compare(point, node.point);
            } else {
                cmp = Y_ORDER.compare(point, node.point);
            }

            Point2D nearestPointSubtree;
            if (cmp < 0) {
                // explore left tree
                nearestPointSubtree = nearest(node.leftOrBottom, nearestSoFar, depth + 1, point);
            } else {
             // explore right tree
                nearestPointSubtree = nearest(node.RightOrTop, nearestSoFar, depth + 1, point);
            }
            
            // update nearest point
            distanceToSubtreePoint = nearestPointSubtree.distanceSquaredTo(point);
            if(distanceToSubtreePoint < distanceToNearestPoint) {
                nearestSoFar = nearestPointSubtree;
                distanceToNearestPoint = distanceToSubtreePoint;
            }
            
            if (cmp < 0) {
                // explore right tree
                nearestPointSubtree = nearest(node.RightOrTop, nearestSoFar, depth + 1, point);
            } else {
                // explore left tree
                nearestPointSubtree = nearest(node.leftOrBottom, nearestSoFar, depth + 1, point);
            }
            
            // update nearest point
            distanceToSubtreePoint = nearestPointSubtree.distanceSquaredTo(point);
            if(distanceToSubtreePoint < distanceToNearestPoint) {
                nearestSoFar = nearestPointSubtree;
                distanceToNearestPoint = distanceToSubtreePoint;
            }

        }
        return nearestSoFar;
    }

    private static class Node {
        // the point
        private Point2D point;
        // the axis-aligned rectangle corresponding to this node
        private RectHV rect;
        // the left/bottom subtree
        private Node leftOrBottom;
        // the right/top subtree
        private Node RightOrTop;

        private Node(Point2D point) {
            this.point = point;
        }
    }

    private static class X_Order implements Comparator<Point2D> {

        @Override
        public int compare(Point2D p, Point2D q) {
            if (p.x() < q.x()) {
                return -1;
            } else if (p.x() > q.x()) {
                return +1;
            } else {
                if (p.y() < q.y()) {
                    return -1;
                } else if (p.y() > q.y()) {
                    return +1;
                } else {
                    return 0;
                }
            }
        }
    }

    private static class Y_Order implements Comparator<Point2D> {

        @Override
        public int compare(Point2D p, Point2D q) {
            if (p.y() < q.y()) {
                return -1;
            } else if (p.y() > q.y()) {
                return +1;
            } else {
                if (p.x() < q.x()) {
                    return -1;
                } else if (p.x() > q.x()) {
                    return +1;
                } else {
                    return 0;
                }
            }
        }
    }
}
