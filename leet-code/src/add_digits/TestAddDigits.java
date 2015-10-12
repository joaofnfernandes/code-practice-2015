package add_digits;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestAddDigits {

    // Tests that f(0)->0
    @Test
    public void test0() {
        int expected = 0;
        int input = 0;
        assertEquals(expected, new Solution().addDigits(input));
        assertEquals(expected, new Solution().addDigits2(input));
    }

    // Tests that f(1)->1
    @Test
    public void test1() {
        int expected = 1;
        int input = 1;
        assertEquals(expected, new Solution().addDigits(input));
        assertEquals(expected, new Solution().addDigits2(input));
    }

    // Tests that f(10)->1+0->1
    @Test
    public void test10() {
        int expected = 1;
        int input = 10;
        assertEquals(expected, new Solution().addDigits(input));
        assertEquals(expected, new Solution().addDigits2(input));
    }

    // Tests that f(10)->1+9->f(10)->1
    @Test
    public void test19() {
        int expected = 1;
        int input = 10;
        assertEquals(expected, new Solution().addDigits(input));
        assertEquals(expected, new Solution().addDigits2(input));
    }

    // Tests that f(99)->f(18)->9
    @Test
    public void test99() {
        int expected = 9;
        int input = 99;
        assertEquals(expected, new Solution().addDigits(input));
        assertEquals(expected, new Solution().addDigits2(input));
    }

}
