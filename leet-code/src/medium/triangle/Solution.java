package medium.triangle;

import java.util.List;

/*
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * 
 * [
 *    [2],
 *   [3,4],
 *  [6,5,7],
 * [4,1,8,3]
 *]
 * Should return 2+3+5+1 = 11
 */
public class Solution {
    // Uses dynamic programming to calculate the min path sum of a row in level i
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() < 1) { return 0; }
        int N = triangle.size();
        int[] minPathSums = new int[N];
        minPathSums[0] = triangle.get(0).get(0);
        
        // Foreach row in the pyramid, compute all its min path sums
        for (int i = 1; i < N; i++) {
            List<Integer> row = triangle.get(i);
            int topLeft = minPathSums[0], tmp;

            // Special case for (i,0) -> current path sum = current value + path sum left
            minPathSums[0] += row.get(0);
            // Regular case. Current path sum = current value + min(path sum left, path sum right)
            for (int j = 1; j < i; j++) {
                tmp = minPathSums[j];
                minPathSums[j] = row.get(j) + Math.min(topLeft, minPathSums[j]);
                topLeft = tmp;
            }
            // Special case for (i,i) ->  current path sum = current value + path sum left
            minPathSums[i] = row.get(i) + topLeft;
        }
        
        // MinPathSums has values for level N, so we just need to get its min
        int min = minPathSums[0];
        for (int i = 1; i < minPathSums.length; i++) {
            min = Math.min(min, minPathSums[i]);
        }
        return min;
    }
    
    
}
