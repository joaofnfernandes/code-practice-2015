package path_sum;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Deque;
import java.util.LinkedList;

public class TestPathSum {

    @Test
    public void testEmptyTree() {
        TreeNode tree = null;
        int pathSum = 0;
        Solution sol = new Solution();
        assertFalse(sol.hasPathSum(tree, pathSum));
    }
    
    @Test
    public void testSingleNodeSums() {
        TreeNode tree = makeTree(new Integer[] { 1 });
        int pathSum = 1;
        Solution sol = new Solution();
        assertTrue(sol.hasPathSum(tree, pathSum));
    }

    @Test
    public void testSingleNodeDoesntSum() {
        TreeNode tree = makeTree(new Integer[] { 1 });
        int pathSum = 2;
        Solution sol = new Solution();
        assertFalse(sol.hasPathSum(tree, pathSum));
    }

    @Test
    public void testBalancedTreeSums() {
        TreeNode tree = makeTree(new Integer[] { 3, 1, 5, 0, 2, 4, 6 });
        int pathSum = 12;
        Solution sol = new Solution();
        assertTrue(sol.hasPathSum(tree, pathSum));
    }

    @Test
    public void testBalancedTreeDoesntSum1() {
        TreeNode tree = makeTree(new Integer[] { 2, 2, 2 });
        int pathSum = 2;
        Solution sol = new Solution();
        assertFalse(sol.hasPathSum(tree, pathSum));
    }

    @Test
    public void testBalancedTreeDoesntSum2() {
        TreeNode tree = makeTree(new Integer[] { 2, 2, 2 });
        int pathSum = 10;
        Solution sol = new Solution();
        assertFalse(sol.hasPathSum(tree, pathSum));
    }

    @Test
    public void testLeftLeaningTreeSums() {
        TreeNode tree = makeTree(new Integer[] { 5, null, 4, null, 3 });
        int pathSum = 12;
        Solution sol = new Solution();
        assertTrue(sol.hasPathSum(tree, pathSum));
    }

    @Test
    public void testLeftLeaningTreeDoesntSum() {
        TreeNode tree = makeTree(new Integer[] { 5, null, 4, null, 3 });
        int pathSum = 9;
        Solution sol = new Solution();
        assertFalse(sol.hasPathSum(tree, pathSum));
    }

    @Test
    public void tesRightLeaningTreeSums() {
        TreeNode tree = makeTree(new Integer[] { 3, null, 4, null, 5 });
        int pathSum = 12;
        Solution sol = new Solution();
        assertTrue(sol.hasPathSum(tree, pathSum));
    }

    @Test
    public void testRightLeaningTreeDoesntSum() {
        TreeNode tree = makeTree(new Integer[] { 3, null, 4, null, 5 });
        int pathSum = 7;
        Solution sol = new Solution();
        assertFalse(sol.hasPathSum(tree, pathSum));
    }

    private TreeNode makeTree(Integer[] values) {
        TreeNode head = new TreeNode(values[0]);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int i = 1;
        Integer value;
        while (!queue.isEmpty() && i + 1 < values.length) {
            TreeNode node = queue.pop();
            value = values[i++];
            if(value != null) {
                node.left = new TreeNode(value);
                queue.add(node.left);
            }
            value = values[i++];
            if(value != null) {
                node.right = new TreeNode(value);
                queue.add(node.right);
            }
        }
        return head;
    }
}
