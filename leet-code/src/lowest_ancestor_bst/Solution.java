package lowest_ancestor_bst;

/*
 * This approach works because this is a BST. For BT or Graphs, need to use Tarjan union-find
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) {
            return null;
        } 
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
