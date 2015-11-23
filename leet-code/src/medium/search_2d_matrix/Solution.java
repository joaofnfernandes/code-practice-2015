package medium.search_2d_matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] column = copyMatrixColumn(matrix, 0);
        int colIndex = binarySearch(column, target);
        if(colIndex < 0 || colIndex >= matrix.length) {
            return false;
        }
        int rowIndex = binarySearch(matrix[colIndex], target);
        if(rowIndex < 0 || rowIndex >= matrix[colIndex].length) {
            return false;
        }
        return matrix[colIndex][rowIndex] == target;
    }
    
    private int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return high;
    }
    
    private int[] copyMatrixColumn(int[][] matrix, int i) {
        int[] column = new int[matrix.length];
        for (int j = 0; j < column.length; j++) {
            column[j] = matrix[j][0];
        }
        return column;
    }
}