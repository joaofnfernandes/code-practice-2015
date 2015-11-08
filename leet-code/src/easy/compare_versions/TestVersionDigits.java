package easy.compare_versions;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestVersionDigits {

    @Test
    public void testVersionDigits() {
        String[] version1 = {"0", "0.0.0", "0.0",   "0",    "9.10.9", "0", "0.0.0", "10.9.8", "0.1",  "0.1.0", "1", "0.0.1", "0.0.1", "0.0.1","9.10.10"};
        String[] version2 = {"1", "0.0.1", "0.0.1", "0.0.1","9.10.10","0", "0.0.0", "10.9.8", "0.1.0","0.1",   "0" ,"0.0.0", "0.0",   "0",    "9.10.9"};
        int[] expected = {  -1,     -1,     -1,     -1,     -1,         0,  0,      0,          0,      0,      1,  1,          1,      1,      1};
        Solution sol = new Solution();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(String.format("%s", version1[i]),expected[i], sol.compareVersion(version1[i], version2[i]));
        }
    }
}
