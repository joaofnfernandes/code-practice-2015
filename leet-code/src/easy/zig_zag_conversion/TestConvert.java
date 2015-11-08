package easy.zig_zag_conversion;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestConvert {

    @Test
    public void testConvert1() {
        String input = "catdogcowduck";
        int n = 1;
        Solution sol = new Solution();
        assertEquals(input, sol.convert(input, n));
    }
    
    @Test
    public void testConvert2() {
        String input = "catdogcowduck";
        String expected = "ctocwukadgodc";
        int n = 2;
        Solution sol = new Solution();
        assertEquals(expected, sol.convert(input, n));
    }
    
    @Test
    public void testConvert3() {
        String input = "catdogcowduck";
        String expected = "cowkadgodctcu";
        int n = 3;
        Solution sol = new Solution();
        assertEquals(expected, sol.convert(input, n));
    }
    
    @Test
    public void testConvert5() {
        String input = "catdogcowduck";
        String expected = "cwaodtcudgcok";
        int n = 5;
        Solution sol = new Solution();
        assertEquals(expected, sol.convert(input, n));
    }
    
}
