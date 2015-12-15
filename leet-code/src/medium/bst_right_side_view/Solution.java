package medium.bst_right_side_view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * For each level on a binary tree, returns the right-most node
 *      1       ----> 1
 *     / \
 *    2   3     ----> 3
 *    \
 *      4       ----> 4
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) { return result; }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int nodes = queue.size();
            TreeNode current = null;
            for (int i = 0; i < nodes; i++) {
                current = queue.remove();
                if(current.left != null) { queue.add(current.left); }
                if(current.right != null) { queue.add(current.right);}
            }
            result.add(current.val);
        }
        return result;
    }
}