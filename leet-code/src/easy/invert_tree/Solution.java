package easy.invert_tree;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }
    
    private TreeNode invert(TreeNode node) {
        if(node == null) {
            return null;
        } else {
            TreeNode aux = invertTree(node.left);
            node.left = invertTree(node.right);
            node.right = aux;
        }
        return node;
    }
}
