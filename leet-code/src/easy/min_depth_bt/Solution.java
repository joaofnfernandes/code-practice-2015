package easy.min_depth_bt;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    // Iterative solution with BFS.
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0, count = 0;
        TreeNode node;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            depth++;
            count = queue.size();
            for (int i = 0; i < count; i++) {
                node = queue.pop();
                if (node.left == null && node.right == null) {
                    return depth;
                } else {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }
        return depth;
    }

    // Recursive solution with DFS.
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}