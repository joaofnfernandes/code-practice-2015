package symmetric_tree;
/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * If in order traversal of tree and inverse(tree) is the same -> tree is symmetric
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return sameInOrderTraversal(root, invert(root));
    }
    
    private TreeNode invert(TreeNode node) {
        if(node == null) {
            return null;
        }
        else {
            TreeNode n = new TreeNode(node.val);
            n.left = invert(node.right);
            n.right = invert(node.left);
            return n;
        }
    }
    
    private boolean sameInOrderTraversal(TreeNode n1, TreeNode n2) {
        if(n1 == null) {
            if(n2 == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if(n2 == null) {
                return false;
            } else {
                return n1.val == n2.val &&
                        sameInOrderTraversal(n1.left, n2.left) &&
                        sameInOrderTraversal(n1.right, n2.right);
            }
        }
    }
}
