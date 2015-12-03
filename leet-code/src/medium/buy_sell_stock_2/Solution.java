package medium.buy_sell_stock_2;

public class Solution {
    // linear time implementation
    public int maxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int i = 0, j = 0;
        while(j < prices.length - 1) {
            if(prices[j] < prices[j + 1]) {
                j++;
            } else {
                maxProfit += prices[j] - prices[i];
                j++;
                i = j;
            }
        }
        maxProfit += prices[j] - prices[i];
        return maxProfit;
    }
    
    // dynamic programming solution -> O(N^2)
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if(n < 2) {
            return 0;
        }
        int[][] maxProfit = new int[n][n];
        
        // fill-in first row
        for (int i = 0; i < n; i++) {
            maxProfit[0][i] = prices[i] - prices[0];
        }
        
        // compute profit for all other pairs
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                int current = prices[j] - prices[i]; // buy in i, and sell in j
                int top = maxProfit[i - 1][j]; // buy earlier
                int leftDiag = maxProfit[i - 1][j -1] + (prices[j] - prices[j-1]); // sell, and then buy
                int max = Math.max(current, Math.max(top, leftDiag));
                        
                if(i == j) {
                    maxProfit[i][j] = max;
                } else {
                    int left = maxProfit[i][j-1]; // sell earlier
                    maxProfit[i][j] = Math.max(left, max);
                }
            }
        }
        return maxProfit[n-1][n-1];
    }
}