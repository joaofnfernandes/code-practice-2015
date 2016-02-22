package medium.subsets;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a set of distinct integers, nums, return all possible subsets.
 *  * Solution doesn't contain duplicate subsets
 *  * Elements in subset are in ascending order
 */
public class Solution {
    List<List<Integer>> solution;
    
    public List<List<Integer>> subsets(int[] nums) {
        solution = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            solution.addAll(subsetsK(nums, i));
        }
        return solution;
    }
    
    private List<List<Integer>> subsetsK (int[] nums, int k) {
        List<List<Integer>> subsetK = new LinkedList<>();
        if(k > 0) {
            subset(nums, 0, k, subsetK, new LinkedList<Integer>());
        } else {
            subsetK.add(new LinkedList<Integer>());
        }
        return subsetK;
    }
    
    private void subset(int[] nums, int i, int k, List<List<Integer>> result, List<Integer> resultSoFar) {
        if(i >= nums.length || resultSoFar.size() >= k) { return; }
        // Explore path where we use number
        List<Integer> soFarCopy = new LinkedList<>(resultSoFar);
        soFarCopy.add(nums[i]);
        if(soFarCopy.size() == k) {
            result.add(soFarCopy);
        } else {
            subset(nums, i + 1, k, result, soFarCopy);
        }
        // Explore path where we don't use number
        soFarCopy = new LinkedList<>(resultSoFar);
        subset(nums, i + 1, k, result, soFarCopy);
    }
}