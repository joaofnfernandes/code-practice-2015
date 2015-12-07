package medium.BST_iterator;

import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> stack;
    private TreeNode node;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if(root == null) {
            return;
        }
        node = root;
        while(node.left != null) {
            stack.add(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return node != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        int value;
        if(node == null) {
            node = stack.pop();
        } else {
            while(node.left != null) {
                stack.add(node);
                node = node.left;
            }
        }
        value = node.val;
        node = node.right;
        return value;
    }
}
