package easy.house_robber;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestHouseRobber {

    @Test
    public void testEndsHaveMoney() {
        int[] input = {5,2,2,5};
        int expected = 10;
        assertEquals(expected, new Solution().rob(input));
        assertEquals(expected, new Solution().rob2(input));
    }
    
    @Test
    public void testOnlyEvensHaveMoney(){
        int[] input = {5,0,5};
        int expected = 10;
        assertEquals(expected, new Solution().rob(input));
        assertEquals(expected, new Solution().rob2(input));
    }
    
    @Test
    public void testOnlyOddsHaveMoney(){
        int[] input = {0,10,0};
        int expected = 10;
        assertEquals(expected, new Solution().rob(input));
        assertEquals(expected, new Solution().rob2(input));
    }
    
    @Test
    public void testEvensHaveMoreMoney(){
        int[] input = {5,5,5};
        int expected = 10;
        assertEquals(expected, new Solution().rob(input));
        assertEquals(expected, new Solution().rob2(input));
    }
    
    @Test
    public void testOddsHaveMoreMoney(){
        int[] input = {5,25,5};
        int expected = 25;
        assertEquals(expected, new Solution().rob(input));
        assertEquals(expected, new Solution().rob2(input));
    }
}
