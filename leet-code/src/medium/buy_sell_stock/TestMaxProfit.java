package medium.buy_sell_stock;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TestMaxProfit {
    @Rule
    public Timeout globalTimeout = new Timeout(20);
    
    @Test
    public void testNoPrices() {
        int[] prices = {};
        int expected = 0;
        int result = new Solution().maxProfit(prices);
        assertEquals(expected, result);
    }
    
    @Test
    public void testIncreasingPrices(){
        int[] prices = {0,1,2,3,4,5};
        int expected = 5;
        int result = new Solution().maxProfit(prices);
        assertEquals(expected, result);
    }
    
    @Test
    public void testIncreasingPrices2() {
        int n = 10000;
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = i;
        }
        int expected = 9999;
        int result = new Solution().maxProfit(prices);
        assertEquals(expected, result);
    }
    
    @Test
    public void testDecreasingPrices(){
        int[] prices = {5,4,3,2,1,0};
        int expected = 0;
        int result = new Solution().maxProfit(prices);
        assertEquals(expected, result);
    }
    
    @Test
    public void testDecreaingPrices2() {
        int n = 10000;
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = n - i;
        }
        int expected = 0;
        int result = new Solution().maxProfit(prices);
        assertEquals(expected, result);
    }
    
    @Test
    public void testConstantPrices(){
        int[] prices = {5,5,5,5,5,5};
        int expected = 0;
        int result = new Solution().maxProfit(prices);
        assertEquals(expected, result);
    }
    
    @Test
    public void testValleyPrices(){
        int[] prices = {5,4,3,2,1,0,0,0,1,2,3,4,5};
        int expected = 5;
        int result = new Solution().maxProfit(prices);
        assertEquals(expected, result);
    }
    
    @Test
    public void testPlateauPrices(){
        int[] prices = {0,1,2,3,4,5,5,5,4,3,2,1,0};
        int expected = 5;
        int result = new Solution().maxProfit(prices);
        assertEquals(expected, result);
    }
    
    @Test
    public void test2ValleysIncrease(){
        int[] prices = {0,5,0,5,0,5,0};
        int expected = 5;
        int result = new Solution().maxProfit(prices);
        assertEquals(expected, result);
    }
    
    @Test
    public void test2ValleysDecrease(){
        int[] prices = {5,0,5,0,5};
        int expected = 5;
        int result = new Solution().maxProfit(prices);
        assertEquals(expected, result);
    }
    
    @Test
    public void testPricesNotSorted(){
        int[] prices = {6,1,3,2,4,7};
        int expected = 6;
        int result = new Solution().maxProfit(prices);
        assertEquals(expected, result);
    }
    
    @Test
    public void testPricesNotSorted2() {
        int[] prices = {3,2,6,5,0,3};
        int expected = 4;
        int result = new Solution().maxProfit(prices);
        assertEquals(expected, result);
    }
}
