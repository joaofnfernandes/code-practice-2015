package rectangle_area;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRectangleArea {

    @Test
    public void testNonIntersectingToLeft() {
        int result = new Solution().computeArea(5, 5, 10, 10, 0, 0, 2, 15);
        // areaA + areaB - areaIntersection
        int expected = 25 + 30 - 0;
        assertEquals(String.format("Expected %d but was %d", expected, result),
                expected, result);
    }

    @Test
    public void testNonIntersectingToRight() {
        int result = new Solution().computeArea(5, 5, 10, 10, 15, 0, 20, 15);
        int expected = 25 + 75 - 0;
        assertEquals(String.format("Expected %d but was %d", expected, result),
                expected, result);
    }

    @Test
    public void testNonIntersectingToTop() {
        int result = new Solution().computeArea(5, 5, 10, 10, 0, 15, 15, 20);
        int expected = 25 + 75 - 0;
        assertEquals(String.format("Expected %d but was %d", expected, result),
                expected, result);

    }

    @Test
    public void testNonIntersectingToBottom() {
        int result = new Solution().computeArea(5, 5, 10, 10, 0, 0, 2, 2);
        int expected = 25 + 4 - 0;
        assertEquals(String.format("Expected %d but was %d", expected, result),
                expected, result);
    }

    @Test
    public void testInterceptingLeft() {
        int result = new Solution().computeArea(5, 5, 10, 10, 0, 0, 8, 15);
        int expected = 25 + 120 - 15;
        assertEquals(String.format("Expected %d but was %d", expected, result),
                expected, result);
    }

    @Test
    public void testInterceptingRight() {
        int result = new Solution().computeArea(5, 5, 10, 10, 8, 0, 15, 15);
        int expected = 25 + 105 - 10;
        assertEquals(String.format("Expected %d but was %d", expected, result),
                expected, result);
    }

    @Test
    public void testInterceptingTop() {
        int result = new Solution().computeArea(5, 5, 10, 10, 0, 8, 15, 15);
        int expected = 25 + 105 - 10;
        assertEquals(String.format("Expected %d but was %d", expected, result),
                expected, result);
    }

    @Test
    public void testInterceptingBottom() {
        int result = new Solution().computeArea(5, 5, 10, 10, 0, 0, 15, 7);
        int expected = 25 + 105 - 10;
        assertEquals(String.format("Expected %d but was %d", expected, result),
                expected, result);
    }

    @Test
    public void testAContainedInB() {
        int result = new Solution().computeArea(5, 5, 10, 10, 0, 0, 15, 15);
        int expected = 25 + 225 - 25;
        assertEquals(String.format("Expected %d but was %d", expected, result),
                expected, result);
    }

    @Test
    public void testBContainedInA() {
        int result = new Solution().computeArea(0, 0, 15, 15, 5, 5, 10, 10);
        int expected = 225 + 25 - 25;
        assertEquals(String.format("Expected %d but was %d", expected, result),
                expected, result);
    }

}
