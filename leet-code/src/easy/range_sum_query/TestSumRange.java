package easy.range_sum_query;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TestSumRange {
    
    @Rule
    public Timeout timeout = Timeout.millis(100);

    @Test
    public void testZeroes() {
        final int N = 10;
        final int value = 0;
        int[] nums = makeArray(N, value);
        int[][] ranges = {{0,0}, {0, N/2}, {0,N-1}, {N/2, N-1}, {N-1, N-1}};
        int expected = 0;
        NumArray numArray = new NumArray(nums);
        for (int i = 0; i < ranges.length; i++) {
            assertEquals(expected, numArray.sumRange(ranges[i][0], ranges[i][1]));
        }
    }
    
    @Test
    public void testConstantNums() {
        final int N = 10;
        final int value = 5;
        int[] nums = makeArray(N, value);
        int[][] ranges = {{0,0}, {0, (N-1)/2}, {0,N-1}, {N/2, N-1}, {N-1, N-1}};
        int[] expected = {  5,       25,     50,         25,          5};
        NumArray numArray = new NumArray(nums);
        for (int i = 0; i < ranges.length; i++) {
            assertEquals(expected[i], numArray.sumRange(ranges[i][0], ranges[i][1]));
        }
    }
    
    @Test
    public void testIncreasingNums() {
        final int N = 10;
        final int startValue = -5;
        int[] nums = makeIncreasingArray(N, startValue);
        int[][] ranges = {{0,0}, {0, (N-1)/2}, {0,N-1}, {N/2, N-1}, {N-1, N-1}};
        int[] expected = {  -5,       -15,     -5,         10,          4};
        NumArray numArray = new NumArray(nums);
        for (int i = 0; i < ranges.length; i++) {
            assertEquals(expected[i], numArray.sumRange(ranges[i][0], ranges[i][1]));
        }
    }
    
    @Test
    public void testDecreasingNums() {
        final int N = 10;
        final int startValue = 5;
        int[] nums = makeDecreasingArray(N, startValue);
        int[][] ranges = {{0,0}, {0, (N-1)/2}, {0,N-1}, {N/2, N-1}, {N-1, N-1}};
        int[] expected = {  5,       15,         5,         -10,          -4};
        NumArray numArray = new NumArray(nums);
        for (int i = 0; i < ranges.length; i++) {
            assertEquals(expected[i], numArray.sumRange(ranges[i][0], ranges[i][1]));
        }
    }
    
    @Test
    public void testNNums() {
        final int N = 10000;
        final int low = -5;
        final int high = 5;
        int[] nums = makeRandomArray(N, low, high);
        NumArray numArray = new NumArray(nums);
        
        int n1, n2;
        for (int i = 0; i < N; i++) {
            n1 = (int) Math.random() * (N - 1);
            n2 = (int) Math.random() * (N - 1);
            numArray.sumRange(n1, n2);
        }
    }
    
    private int[] makeArray(int N, int value) {
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = value;
        }
        return nums;
    }
    
    private int[] makeIncreasingArray(int N, int startValue) {
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = startValue++;
        }
        return nums;
    }
    
    private int[] makeDecreasingArray(int N, int startValue) {
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = startValue--;
        }
        return nums;
    }
    
    private int[] makeRandomArray(int N, int low, int high) {
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = (int)(Math.random() * (high - low)) + low;
        }
        return nums;
    }
}
