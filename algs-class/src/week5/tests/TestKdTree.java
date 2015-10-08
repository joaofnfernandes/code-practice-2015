package week5.tests;

import org.junit.Test;
import static org.junit.Assert.*;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import java.util.Arrays;

import week5.KdTree;

public class TestKdTree {

    private static final String TEST_PATH = System.getenv("TEST_RESOURCES");

    
    @Test
    public void TestEmptyTree() {
        KdTree tree = new KdTree();

        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
    }

    @Test
    public void TestSize() {
        KdTree tree = new KdTree();
        Point2D p1 = new Point2D(0, 0);
        Point2D p2 = new Point2D(1, 1);

        assertEquals(0, tree.size());

        tree.insert(p1);
        assertEquals(1, tree.size());

        tree.insert(p2);
        assertEquals(2, tree.size());

        // Insert same point, should replace existing one, not add one
        tree.insert(p1);
        tree.insert(p2);
        assertEquals(2, tree.size());

    }

    @Test
    public void TestContains() {
        KdTree tree = new KdTree();
        Point2D p1 = new Point2D(0, 0);
        Point2D p2 = new Point2D(1, 1);

        assertFalse(tree.contains(p1));
        assertFalse(tree.contains(p2));

        tree.insert(p1);
        assertTrue(tree.contains(p1));
        assertFalse(tree.contains(p2));

        tree.insert(p2);
        assertTrue(tree.contains(p1));
        assertTrue(tree.contains(p2));
    }

    @Test
    public void TestNearestNeighbor() {
        TestNeighborVerticalPoints();
        TestNeighborHorizontalPoints();
        TestNeighborDiagonalPoints();
        TestNeighborCircle();
    }

    @Test
    public void TestRange() {
        TestRangeHorizontalPoints();
        TestRangeVerticalPoints();
        TestRangeDiagonalPoints();
    }
    

    private void TestRangeHorizontalPoints() {
        TestHorizontalRange1();
        TestHorizontalRange2();
        TestHorizontalRange3();
        TestHorizontalRange4();
        TestHorizontalRange5();
        TestHorizontalRange6();
    }

    private void TestRangeVerticalPoints() {
        TestVerticalRange1();
        TestVerticalRange2();
        TestVerticalRange3();
        TestVerticalRange4();
        TestVerticalRange5();
        TestVerticalRange6();
    }

    private void TestRangeDiagonalPoints() {
        TestDiagonalRange1();
        TestDiagonalRange2();
        TestDiagonalRange3();
        TestDiagonalRange4();
        TestDiagonalRange5();
        TestDiagonalRange6();
    }

    // Tests that two horizontal collinear points are not in range of a rect
    // below them
    private void TestHorizontalRange1() {
        final String file = "horizontal2.txt";
        RectHV rect = new RectHV(0, 0, 1, 0.2);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertFalse(points.range(rect).iterator().hasNext());
    }

    // Tests that two horizontal collinear points are not in range of a rect
    // above them
    private void TestHorizontalRange2() {
        final String file = "horizontal2.txt";
        RectHV rect = new RectHV(0, 0.3, 1, 1);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertFalse(points.range(rect).iterator().hasNext());
    }

    // Tests that two horizontal collinear points are not in range of a rect to
    // the left of them
    private void TestHorizontalRange3() {
        final String file = "horizontal2.txt";
        RectHV rect = new RectHV(0, 0, 0.2, 1);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertFalse(points.range(rect).iterator().hasNext());
    }

    // Tests that two horizontal collinear points are not in range of a rect to
    // the right of them
    private void TestHorizontalRange4() {
        final String file = "horizontal2.txt";
        RectHV rect = new RectHV(0.8, 0, 1, 1);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertFalse(points.range(rect).iterator().hasNext());
    }

    // Tests that two horizontal collinear points are in range of rect
    private void TestHorizontalRange5() {
        final String file = "horizontal2.txt";
        RectHV rect = new RectHV(0, 0, 1, 1);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        Point2D[] expectedPoints = { new Point2D(0.25, 0.25),
                new Point2D(0.75, 0.25) };
        assertTrue(samePointList(Arrays.asList(expectedPoints),
                points.range(rect)));
    }

    // Tests that one of two horizontal collinear points is in range of rect
    private void TestHorizontalRange6() {
        final String file = "horizontal2.txt";
        RectHV rect = new RectHV(0, 0, 0.3, 1);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        Point2D[] expectedPoints = { new Point2D(0.25, 0.25) };
        assertTrue(samePointList(Arrays.asList(expectedPoints),
                points.range(rect)));
    }

    // Tests that two vertical collinear points are not in range of a rect below
    // them
    private void TestVerticalRange1() {
        final String file = "vertical2.txt";
        RectHV rect = new RectHV(0, 0, 1, 0.2);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertFalse(points.range(rect).iterator().hasNext());
    }

    // Tests that two vertical collinear points are not in range of a rect above
    // them
    private void TestVerticalRange2() {
        final String file = "vertical2.txt";
        RectHV rect = new RectHV(0, 0.8, 1, 1);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertFalse(points.range(rect).iterator().hasNext());
    }

    // Tests that two vertical collinear points are not in range of a rect to
    // the left of them
    private void TestVerticalRange3() {
        final String file = "vertical2.txt";
        RectHV rect = new RectHV(0, 0, 0.2, 1);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertFalse(points.range(rect).iterator().hasNext());
    }

    // Tests that two vertical collinear points are not in range of a rect to
    // the right of them
    private void TestVerticalRange4() {
        final String file = "vertical2.txt";
        RectHV rect = new RectHV(0.3, 0, 1, 1);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertFalse(points.range(rect).iterator().hasNext());
    }

    // Tests that two vertical collinear points are in range of rect
    private void TestVerticalRange5() {
        final String file = "vertical2.txt";
        RectHV rect = new RectHV(0, 0, 1, 1);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        Point2D[] expectedPoints = { new Point2D(0.25, 0.25),
                new Point2D(0.25, 0.75) };
        assertTrue(samePointList(Arrays.asList(expectedPoints),
                points.range(rect)));

    }

    // Tests that one of two vertical collinear points is in range of rect
    private void TestVerticalRange6() {
        final String file = "vertical2.txt";
        RectHV rect = new RectHV(0, 0, 1, 0.3);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        Point2D[] expectedPoints = { new Point2D(0.25, 0.25) };
        assertTrue(samePointList(Arrays.asList(expectedPoints),
                points.range(rect)));
    }

    // Tests that two diagonal collinear points are not in range of a rect below
    // them
    private void TestDiagonalRange1() {
        final String file = "diagonal2.txt";
        RectHV rect = new RectHV(0, 0, 1, 0.2);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertFalse(points.range(rect).iterator().hasNext());
    }

    // Tests that two diagonal collinear points are not in range of a rect above
    // them
    private void TestDiagonalRange2() {
        final String file = "diagonal2.txt";
        RectHV rect = new RectHV(0, 0.8, 1, 1);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertFalse(points.range(rect).iterator().hasNext());
    }

    // Tests that two diagonal collinear points are not in range of a rect to
    // the left of them
    private void TestDiagonalRange3() {
        final String file = "diagonal2.txt";
        RectHV rect = new RectHV(0, 0, 0.2, 1);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertFalse(points.range(rect).iterator().hasNext());
    }

    // Tests that two diagonal collinear points are not in range of a rect to
    // the right of them
    private void TestDiagonalRange4() {
        final String file = "diagonal2.txt";
        RectHV rect = new RectHV(0.8, 0, 1, 1);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertFalse(points.range(rect).iterator().hasNext());
    }

    // Tests that two diagonal collinear points are in range of rect
    private void TestDiagonalRange5() {
        final String file = "diagonal2.txt";
        RectHV rect = new RectHV(0, 0, 1, 1);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        Point2D[] expectedPoints = { new Point2D(0.25, 0.25),
                new Point2D(0.5, 0.5) };
        assertTrue(samePointList(Arrays.asList(expectedPoints),
                points.range(rect)));

    }

    // Tests that one of two diagonal collinear points is in range of rect
    private void TestDiagonalRange6() {
        final String file = "diagonal2.txt";
        RectHV rect = new RectHV(0, 0, 1, 0.3);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        Point2D[] expectedPoints = { new Point2D(0.25, 0.25) };
        assertTrue(samePointList(Arrays.asList(expectedPoints),
                points.range(rect)));
    }

    // Tests nearest neighbors with 3 vertical collinear points
    private void TestNeighborVerticalPoints() {
        TestNeighborVertical1();
        TestNeiborVertical2();
        TestNeiborVertical3();
        TestNeiborVertical4();
    }

    // Tests nearest neighbors with 3 horizontal collinear points
    private void TestNeighborHorizontalPoints() {
        TestNeighborHorizontal1();
        TestNeighborHorizontal2();
        TestNeighborHorizontal3();
        TestNeighborHorizontal4();
    }

    // Tests nearest neighbors with 3 points
    private void TestNeighborDiagonalPoints() {
        TestNeighborDiag1();
        TestNeighborDiag2();
        TestNeighborDiag3();
        TestNeighborDiag4();
        TestNeighborDiag5();
        TestNeighborDiag6();
        TestNeighborDiag7();
        TestNeighborDiag8();
    }

    // p in middle of two points. Test that nearest point is below
    private void TestNeighborVertical1() {
        final String file = "vertical2.txt";
        Point2D point = new Point2D(0.25, 0.4);
        Point2D expected = new Point2D(0.25, 0.25);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }

    // p in middle of two points. Test that nearest point is above
    private void TestNeiborVertical2() {
        final String file = "vertical2.txt";
        Point2D point = new Point2D(0.25, 0.6);
        Point2D expected = new Point2D(0.25, 0.75);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }

    // p on top of two points. Test that nearest point is below
    private void TestNeiborVertical3() {
        final String file = "vertical2.txt";
        Point2D point = new Point2D(0.25, 1);
        Point2D expected = new Point2D(0.25, 0.75);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }

    // p below two points. Test that nearest point is above
    private void TestNeiborVertical4() {
        final String file = "vertical2.txt";
        Point2D point = new Point2D(0.25, 0);
        Point2D expected = new Point2D(0.25, 0.25);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }

    // p in the middle of two points. Test that nearest point is left
    private void TestNeighborHorizontal1() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(0.4, 0.25);
        Point2D expected = new Point2D(0.25, 0.25);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }

    // p in the middle of two points. Test that nearest point is right
    private void TestNeighborHorizontal2() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(0.6, 0.25);
        Point2D expected = new Point2D(0.75, 0.25);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }

    // p to the left of two points. Test that nearest point is right
    private void TestNeighborHorizontal3() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(0, 0.25);
        Point2D expected = new Point2D(0.25, 0.25);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }

    // p is collinear and to the right of two points. Test that nearest point is
    // left
    private void TestNeighborHorizontal4() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(1, 0.25);
        Point2D expected = new Point2D(0.75, 0.25);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }

    // p is collinear and in the middle of two points. Test that nearest point
    // is left
    private void TestNeighborDiag1() {
        final String file = "diagonal2.txt";
        Point2D point = new Point2D(0.20, 0.20);
        Point2D expected = new Point2D(0.25, 0.25);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }

    // p is collinear in the middle of two points. Test that nearest point is
    // right
    private void TestNeighborDiag2() {
        final String file = "diagonal2.txt";
        Point2D point = new Point2D(0.4, 0.4);
        Point2D expected = new Point2D(0.5, 0.5);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }

    // p is in middle of two points and forms a triangle. Test that nearest
    // point is top
    private void TestNeighborDiag3() {
        final String file = "diagonal2.txt";
        Point2D point = new Point2D(0.75, 0.1);
        Point2D expected = new Point2D(0.5, 0.5);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }

    // p is in middle of two points and forms a triangle. Test that nearest
    // point is left
    private void TestNeighborDiag4() {
        final String file = "diagonal2.txt";
        Point2D point = new Point2D(0.4, 0.25);
        Point2D expected = new Point2D(0.25, 0.25);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }

    // p is on the top-right of two collinear points and forms an obtuse
    // triangle.
    // Test that nearest point is left
    private void TestNeighborDiag5() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(1, 0.5);
        Point2D expected = new Point2D(0.75, 0.25);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }

    // p is on the bottom-right of two collinear points and forms an obtuse
    // triangle.
    // Test that nearest point is left
    private void TestNeighborDiag6() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(1, 0);
        Point2D expected = new Point2D(0.75, 0.25);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }

    // p is on the top-left of two collinear points and forms an obtuse
    // triangle.
    // Test that nearest point is right
    private void TestNeighborDiag7() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(0, 0.5);
        Point2D expected = new Point2D(0.25, 0.25);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }

    // p is on the bottom-left of two collinear points and forms an obtuse
    // triangle.
    // Test that nearest point is right
    private void TestNeighborDiag8() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(0, 0);
        Point2D expected = new Point2D(0.25, 0.25);
        KdTree points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // circle with 6 points, test p is closest to top right point
    public void TestNeighborCircle() {
        KdTree tree = readPointsFromFile(TEST_PATH + "circle6.txt");
        Point2D point = new Point2D(0.41, 0.32);
        Point2D expectedPoint = new Point2D(0.4, 0.4);
        Point2D result = tree.nearest(point);
        assertEquals(expectedPoint, result);
    }

    private KdTree readPointsFromFile(String filename) {
        KdTree points = new KdTree();
        In in = new In(filename);
        while (!in.isEmpty()) {
            points.insert(new Point2D(in.readDouble(), in.readDouble()));
        }
        return points;
    }

    private boolean samePointList(Iterable<Point2D> expected,
            Iterable<Point2D> result) {
        boolean match = false;
        for (Point2D expectedPoint : expected) {
            match = false;
            for (Point2D resultPoint : result) {
                if (expectedPoint.compareTo(resultPoint) == 0) {
                    match = true;
                    break;
                }
            }
            if (!match) {
                return false;
            }
        }
        return true;
    }
}
