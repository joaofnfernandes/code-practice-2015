package medium.buy_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0, max = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += prices[i] - prices[i - 1];
            if(sum < 0) {
                sum = 0;
            }
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }
}