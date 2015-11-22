package medium.kth_smallest;

public class Solution {
    private int kSmallest = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        kSmallest = 0;
        recurse(root, k);
        return kSmallest;
    }
    
    // in-order traversal
    private int recurse(TreeNode node, int k) {
        if(node == null) {
            return 0;
        }
        int leftElements = recurse(node.left, k);
        if(k == leftElements + 1) {
            kSmallest = node.val;
        }
        int rightElements = recurse(node.right, k - leftElements - 1);
        return leftElements + rightElements + 1;
    }
}