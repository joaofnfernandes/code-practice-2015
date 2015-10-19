package min_depth_bt;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class TestMinDepth {

    @Test
    public void testEmptyTree() {
        TreeNode tree = null;
        int expected = 0;
        Solution sol = new Solution();
        assertEquals(expected, sol.minDepth(tree));
        assertEquals(expected, sol.minDepth2(tree));
    }

    @Test
    public void testFullTree() {
        TreeNode tree = makeTree(new Integer[] { 1, 2, 2, 3, 3, 3, 3 });
        int expected = 3;
        Solution sol = new Solution();
        assertEquals(expected, sol.minDepth(tree));
        assertEquals(expected, sol.minDepth(tree));
    }

    @Test
    public void testLeftLeaningTree() {
        TreeNode tree = makeTree(new Integer[] { 1, 2, null, 3, null });
        int expected = 3;
        Solution sol = new Solution();
        assertEquals(expected, sol.minDepth(tree));
        assertEquals(expected, sol.minDepth(tree));
    }

    @Test
    public void testRightLeaningTree() {
        TreeNode tree = makeTree(new Integer[] { 1, null, 2, null, 3 });
        int expected = 3;
        Solution sol = new Solution();
        assertEquals(expected, sol.minDepth(tree));
        assertEquals(expected, sol.minDepth(tree));
    }
    
    @Test
    public void testUnbalancedTree() {
        TreeNode tree = makeTree(new Integer[] {1,2,2,3,null,3,null,null,4});
        int expected = 3;
        Solution sol = new Solution();
        assertEquals(expected, sol.minDepth(tree));
        assertEquals(expected, sol.minDepth(tree));
    }

    private TreeNode makeTree(Integer[] values) {
        if (values == null || values.length < 1) {
            return null;
        }
        int i = 0;
        TreeNode head = new TreeNode(values[i++]);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        TreeNode node;
        Integer value;

        while (!queue.isEmpty() && i + 1 < values.length) {
            node = queue.pop();
            value = values[i++];
            if (value != null) {
                node.left = new TreeNode(value);
                queue.add(node.left);
            }
            value = values[i++];
            if (value != null) {
                node.right = new TreeNode(value);
                queue.add(node.right);
            }
        }
        return head;
    }
}
