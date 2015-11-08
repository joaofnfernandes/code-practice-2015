package easy.roman_numerals;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanToInt {

    @Test
    public void test1Digit() {
        String[] inputs =       { "I", "V", "X", "L", "C", "D", "M" };
        int[] expectedResults = {1, 5, 10, 50, 100, 500, 1000 };
        Solution sol = new Solution();
        
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expectedResults[i], sol.romanToInt(inputs[i]) );
        }
    }

    @Test
    public void testExceptionalDigits() {
        String[] inputs =       { "IV", "IX", "XL", "XC", "CD", "CM" };
        int[] expectedResults = {4, 9, 40, 90, 400, 900 };
        Solution sol = new Solution();
        
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expectedResults[i], sol.romanToInt(inputs[i]) );
        }
    }

    @Test
    public void test2Digits() {
        String[] inputs =       { "II", "VI", "XI", "XX", "CC", "MM" };
        int[] expectedResults = {2, 6, 11, 20, 200, 2000 };
        Solution sol = new Solution();
        
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expectedResults[i], sol.romanToInt(inputs[i]) );
        }
    }

    @Test
    public void test3Digits() {
        String[] inputs =       { "III", "XXX", "CCC", "MMM"};
        int[] expectedResults = {3, 30, 300, 3000};
        Solution sol = new Solution();
        
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expectedResults[i], sol.romanToInt(inputs[i]) );
        }
    }

}
