package week5.tests;

import org.junit.Test;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;

import week5.PointSET;
import static org.junit.Assert.*;

public class TestPointSet {
    private static final String TEST_PATH = System.getenv("TEST_RESOURCES");
    
    @Test
    public void TestNeighborVerticalPoints() {
        TestNeighborVertical1();
        TestNeiborVertical2();
        TestNeiborVertical3();
        TestNeiborVertical4();
    }
    
    @Test
    public void TestNeighborHorizontalPoints() {
        TestNeighborHorizontal1();
        TestNeighborHorizontal2();
        TestNeighborHorizontal3();
        TestNeighborHorizontal4();
    }
    
    @Test
    public void TestNeighborDiagonalPoints(){
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
        Point2D point = new Point2D(0, 0.4);
        Point2D expected = new Point2D(0, 0.25);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // p in middle of two points. Test that nearest point is above
    private void TestNeiborVertical2(){
        final String file = "vertical2.txt";
        Point2D point = new Point2D(0, 0.6);
        Point2D expected = new Point2D(0, 0.75);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // p on top of two points. Test that nearest point is below
    private void TestNeiborVertical3(){
        final String file = "vertical2.txt";
        Point2D point = new Point2D(0, 1);
        Point2D expected = new Point2D(0, 0.75);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // p below two points. Test that nearest point is above
    private void TestNeiborVertical4(){
        final String file = "vertical2.txt";
        Point2D point = new Point2D(0, 0);
        Point2D expected = new Point2D(0, 0.25);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // p in the middle of two points. Test that nearest point is left
    private void TestNeighborHorizontal1() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(0.4, 0.25);
        Point2D expected = new Point2D(0.25, 0.25);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // p in the middle of two points. Test that nearest point is right
    private void TestNeighborHorizontal2() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(0.6, 0.25);
        Point2D expected = new Point2D(0.75, 0.25);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // p to the left of two points. Test that nearest point is right
    private void TestNeighborHorizontal3() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(0, 0.25);
        Point2D expected = new Point2D(0.25, 0.25);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // p is collinear and to the right of two points. Test that nearest point is left
    private void TestNeighborHorizontal4() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(1, 0.25);
        Point2D expected = new Point2D(0.75, 0.25);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // p is collinear and in the middle of two points. Test that nearest point is left
    private void TestNeighborDiag1() {
        final String file = "diagonal2.txt";
        Point2D point = new Point2D(0.20, 0.20);
        Point2D expected = new Point2D(0, 0);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // p is collinear in the middle of two points. Test that nearest point is right
    private void TestNeighborDiag2() {
        final String file = "diagonal2.txt";
        Point2D point = new Point2D(0.3, 0.3);
        Point2D expected = new Point2D(0.5, 0.5);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // p is in middle of two points and forms a triangle. Test that nearest point is top
    private void TestNeighborDiag3() {
        final String file = "diagonal2.txt";
        Point2D point = new Point2D(0.5, 0.1);
        Point2D expected = new Point2D(0.5, 0.5);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // p is in middle of two points and forms a triangle. Test that nearest point is left
    private void TestNeighborDiag4() {
        final String file = "diagonal2.txt";
        Point2D point = new Point2D(0.4, 0);
        Point2D expected = new Point2D(0, 0);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // p is on the top-right of two collinear points and forms an obtuse triangle.
    // Test that nearest point is left
    private void TestNeighborDiag5() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(1, 0.5);
        Point2D expected = new Point2D(0.75, 0.25);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // p is on the bottom-right of two collinear points and forms an obtuse triangle.
    // Test that nearest point is left
    private void TestNeighborDiag6() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(1, 0);
        Point2D expected = new Point2D(0.75, 0.25);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // p is on the top-left of two collinear points and forms an obtuse triangle.
    // Test that nearest point is right
    private void TestNeighborDiag7() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(0, 0.5);
        Point2D expected = new Point2D(0.25, 0.25);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    // p is on the bottom-left of two collinear points and forms an obtuse triangle.
    // Test that nearest point is right
    private void TestNeighborDiag8() {
        final String file = "horizontal2.txt";
        Point2D point = new Point2D(0, 0);
        Point2D expected = new Point2D(0.25, 0.25);
        PointSET points = readPointsFromFile(TEST_PATH + file);
        assertEquals(expected, points.nearest(point));
    }
    
    private PointSET readPointsFromFile(String filename) {
        PointSET points = new PointSET();
        In in = new In(filename);
        while(!in.isEmpty()) {
            points.insert(new Point2D(in.readDouble(), in.readDouble()));
        }
        return points;
    }

}
