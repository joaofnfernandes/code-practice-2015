package medium.longest_increasing_subsequence;

import java.util.Arrays;

public class Solution {
    // O(NlogN) solution
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        final int N = nums.length;
        int[] tails = new int[N];
        int i = 0, j = 0;
        tails[j++] = nums[i++];
        for (; i < N; i++) {
            int value = nums[i];
            int index = Arrays.binarySearch(tails, 0, j, value);
            if (index < 0) {
                if (index == -(j + 1)) {
                    tails[j++] = value;
                } else {
                    tails[-(index + 1)] = value;
                }
            }
        }
        return j;
    }

    // Dynamic programming solution to longest increasing subsequence problem.
    // O(N/2)
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        final int N = nums.length;
        int maxSequenceLength = 1;
        int[] sequenceLength = new int[N];

        for (int i = 0; i < N; i++) {
            sequenceLength[i] = 1; // Length of this subsequence is 1
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // if we can add this number to the subsequence, choose the
                    // longest
                    // subsequence possible
                    sequenceLength[i] = Math.max(sequenceLength[i],
                            sequenceLength[j] + 1);
                    maxSequenceLength = Math.max(maxSequenceLength,
                            sequenceLength[i]);
                }
            }
        }
        return maxSequenceLength;
    }

}