package easy.range_sum_query;

// performs a 1-d range query. O(N) constructor, O(1) query
public class NumArray {

    
    private int[] accumulated = null;
    
    public NumArray(int[] nums) {
        if(nums == null || nums.length < 1) {
            return;
        }
        // [0, acc(0,1), acc(0,2), ...]
        accumulated = new int[nums.length + 1];
        int sum = 0;
        for (int i = 1; i < accumulated.length; i++) {
            sum += nums[i - 1];
            accumulated[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return accumulated[j + 1] - accumulated[i];
    }
}
