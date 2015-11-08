package easy.max_depth_bt;


public class Solution {
    public int maxDepth(TreeNode root) {
        return depth(root);
    }
    
    private int depth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            return Math.max(depth(root.left) + 1, depth(root.right) + 1);
        }
    }
}
