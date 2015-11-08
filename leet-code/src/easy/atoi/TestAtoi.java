package easy.atoi;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestAtoi {

    @Test
    public void testValidAtoi() {
        String[] inputs = {"0", "1234", "-0", "-1234", "  1234", "1234   ", "  1234  ", "-1234ab21", "1234.1234", "2147483648","-2147483648", "18446744073709551617"};
        int[] expectedValues = {0,1234,0,-1234,1234,1234,1234, -1234, 1234, 2147483647, -2147483648, 2147483647};
        Solution sol = new Solution();
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(String.format("%s failed test", inputs[i]),
                            expectedValues[i], sol.myAtoi(inputs[i]));
        }
        
    }
    
    @Test
    public void testInvalidAtoi() {
        int expected = 0;
        String[] inputs = {"aa", "",  "", "  ","-", "+"};
        Solution sol = new Solution();
        for (String s : inputs) {
            assertEquals(String.format("%s failed test", s), expected, sol.myAtoi(s));
        }
    }
}
