package easy.add_binary_strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAddBinary {
    
    @Test
    public void testAddBinary() {
        String[] a =        {"0", "0",  "1",  "11",  "11"};
        String[] b =        {"0", "1",  "1",   "1",  "11"};
        String[] expected = {"0", "1", "10", "100", "110"};
        Solution sol = new Solution();
        for (int i = 0; i < a.length; i++) {
            assertEquals(String.format("%d",i),expected[i], sol.addBinary(a[i], b[i]));
        }
    }

}
