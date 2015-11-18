package medium.preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) {
            return list;
        }
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null) {
                stack.add(node.right);
            }
            if(node.left != null) {
                stack.add(node.left);
            }
        }
        return list;
    }
    
    
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        return preorderTraversalRecursive(root, list);
    }
    
    private List<Integer> preorderTraversalRecursive(TreeNode node, List<Integer> list) {
        if(node == null) {
            return list;
        } else {
            list.add(node.val);
            preorderTraversalRecursive(node.left, list);
            preorderTraversalRecursive(node.right, list);
            return list;
        }
    }
}