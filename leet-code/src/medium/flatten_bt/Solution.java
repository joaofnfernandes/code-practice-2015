package medium.flatten_bt;

import java.util.Stack;

/*
 *  Takes a binary tree, and creates a linked-list in place.
 *    1         1
 *   / \         \
 *  2   3         2
 *                 \
 *                  3
 */

public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) { return; }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode parent = null;
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if(current.right != null) {
                stack.add(current.right);
                current.right = null;
            }
            if(current.left != null) {
                stack.add(current.left);
                current.left = null;
            }
            if(parent != null) {
                parent.right = current;
            }
            parent = current;
        }
    }
}