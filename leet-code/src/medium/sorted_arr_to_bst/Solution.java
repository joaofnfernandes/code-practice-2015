package medium.sorted_arr_to_bst;
/*
 * Converts a sorted array to a BST
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start >= end) {
            return null;
        } else {
            int middle = start + (end - start) / 2;
            TreeNode node = new TreeNode(nums[middle]);
            node.left = sortedArrayToBST(nums, start, middle);
            node.right = sortedArrayToBST(nums, middle + 1, end);
            return node;
        }
    }
}
