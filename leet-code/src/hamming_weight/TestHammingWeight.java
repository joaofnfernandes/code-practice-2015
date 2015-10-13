package hamming_weight;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestHammingWeight {

    @Test
    public void Test0(){
        int expected = 0;
        int result = new Solution().hammingWeight(0);
        assertEquals(expected, result);
    }
    
    @Test
    public void Test1Bit(){
        int expected = 1;
        int result;
        
        result = new Solution().hammingWeight(1);
        assertEquals(expected, result);
        result = new Solution().hammingWeight(2);
        assertEquals(expected, result);
        result = new Solution().hammingWeight(4);
        assertEquals(expected, result);
        result = new Solution().hammingWeight(8);
        assertEquals(expected, result);
        result = new Solution().hammingWeight(16);
        assertEquals(expected, result);
    }
    
    @Test
    public void Test2Bits(){
        int expected = 2;
        int result;
        
        result = new Solution().hammingWeight(3);
        assertEquals(expected, result);
        result = new Solution().hammingWeight(6);
        assertEquals(expected, result);
        result = new Solution().hammingWeight(12);
        assertEquals(expected, result);
        result = new Solution().hammingWeight(17);
        assertEquals(expected, result);
        result = new Solution().hammingWeight(18);
        assertEquals(expected, result);
    }
    
    @Test
    public void TestNBits(){
        int expected, result;
        
        expected = 3;
        result = new Solution().hammingWeight(28);
        assertEquals(expected, result);
        result = new Solution().hammingWeight(22);
        assertEquals(expected, result);
        result = new Solution().hammingWeight(19);
        assertEquals(expected, result);
        
        expected = 4;
        result = new Solution().hammingWeight(30);
        assertEquals(expected, result);
        result = new Solution().hammingWeight(15);
        assertEquals(expected, result);
        
        expected = 5;
        result = new Solution().hammingWeight(31);
        assertEquals(expected, result);
    }
}
