package medium.most_water;

public class Solution {
    // Linear time solution
    public int maxArea(int[] height) {
        int max = 0;
        int low = 0, high = height.length - 1;
        while(low < high) {
            // compute area, and update max
            int tmp = getArea(height, low, high);
            if(tmp > max) {
                max = tmp;
            }
            // update pointers
            if(height[low] < height[high]) {
                low++;
            } else if(height[low] > height[high]) {
                high--;
            } else {
                low++;
                high--;
            }
        }
        return max;
    }
    
    private int getArea(int[] height, int i, int j) {
        return (Math.abs(j - i)) * Math.min(height[i], height[j]);
    }
    
    // Dynamic programming solution that takes O(N/2)
    public int maxArea2(int[] height) {
        int n = height.length;
        int[][] maxArea = new int[n][n];
        
        // populate top row
        for (int i = 0; i < n; i++) {
            if(i == 0) {
                maxArea[0][i] = 0;
            } else {
                maxArea[0][i] = Math.max(maxArea[0][i - 1],
                                            i * Math.min(height[0], height[i]));
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(i == j) {
                    // copy from top
                    maxArea[i][j] = maxArea[i - 1][j];
                } else {
                    // max(top, left, self)
                    int top = maxArea[i - 1][j];
                    int left = maxArea[i][j - 1];
                    int self = (j - i) * Math.min(height[i], height[j]);
                    maxArea[i][j] = Math.max(top, Math.max(left, self));
                }
            }
        }
        return maxArea[n-1][n-1];
    }
}