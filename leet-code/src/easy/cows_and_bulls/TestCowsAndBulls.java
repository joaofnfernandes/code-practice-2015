package easy.cows_and_bulls;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCowsAndBulls {
    
    @Test
    public void testSameString(){
        String secret = "1234";
        String guess = "1234";
        String expected = "4A0B";
        assertEquals(expected, new Solution().getHint(secret, guess));
    }
    
    @Test
    public void testDifferentString(){
        String secret = "1234";
        String guess = "5678";
        String expected = "0A0B";
        assertEquals(expected, new Solution().getHint(secret, guess));
    }
    
    @Test
    public void testAllGuessOutOfPlace(){
        String secret = "1234";
        String guess = "4321";
        String expected = "0A4B";
        assertEquals(expected, new Solution().getHint(secret, guess));
    }
    
    @Test
    public void testHalfCorrectHalfOutOfPlace1() {
        String secret = "1234";
        String guess = "1298";
        String expected = "2A0B";
        assertEquals(expected, new Solution().getHint(secret, guess));
    }
    
    @Test
    public void testHalfCorrectHalfOutOfPlace2() {
        String secret = "1234";
        String guess = "8934";
        String expected = "2A0B";
        assertEquals(expected, new Solution().getHint(secret, guess));
    }
    
    @Test
    public void testHalfCorrectHalfOutOfPlace3() {
        String secret = "1234";
        String guess = "1432";
        String expected = "2A2B";
        assertEquals(expected, new Solution().getHint(secret, guess));
    }
    
    @Test
    public void testSecretSameNumber1() {
        String secret = "1111";
        String guess = "1234";
        String expected = "1A0B";
        assertEquals(expected, new Solution().getHint(secret, guess));
    }
    
    @Test
    public void testSecretSameNumber2() {
        String secret = "1111";
        String guess = "7891";
        String expected = "1A0B";
        assertEquals(expected, new Solution().getHint(secret, guess));
    }
    
    @Test
    public void testGuessSameNumber1() {
        String secret = "1234";
        String guess = "1111";
        String expected = "1A0B";
        assertEquals(expected, new Solution().getHint(secret, guess));
    }
    
    @Test
    public void testGuessSameNumber2() {
        String secret = "1234";
        String guess = "4449";
        String expected = "0A1B";
        assertEquals(expected, new Solution().getHint(secret, guess));
    }
    
    @Test
    public void testGuessSameNumber3() {
        String secret = "1122";
        String guess =  "1222";
        String expected = "3A0B";
        assertEquals(expected, new Solution().getHint(secret, guess));
    }
    
    @Test
    public void testComplementary() {
        String secret = "1122";
        String guess =  "2211";
        String expected = "0A4B";
        assertEquals(expected, new Solution().getHint(secret, guess));
    }

}
