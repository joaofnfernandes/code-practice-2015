package invert_tree;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestInvertTree {

    @Test
    public void testEmptyTree() {
        TreeNode tree = null;
        tree = new Solution().invertTree(tree);
        assertEquals(tree, null);
    }

    @Test
    public void test7ElemTree() {
        int[] t1 = new int[]{0,4,2,7,1,3,6,9};
        int[] t2 = new int[]{0,4,7,2,9,6,3,1};
        
        TreeNode result = makeBalancedTree(t1);
        TreeNode expected = makeBalancedTree(t2);
        
        new Solution().invertTree(result);
        assertTrue(areTreesEqual(expected, result));
    }

    @Test
    public void testUnbalancedTree() {
        TreeNode result = new TreeNode(3);
        result.left = new TreeNode(2);
        result.left.left = new TreeNode(1);
        
        TreeNode expected = new TreeNode(3);
        expected.right = new TreeNode(2);
        expected.right.right = new TreeNode(1);
        
        new Solution().invertTree(result);
        assertTrue(areTreesEqual(expected, result));
    }

    private TreeNode makeBalancedTree(int[] arr) {
        return makeBalancedTree(arr, 1);
    }
    
    private TreeNode makeBalancedTree(int[] arr, int i) {
        if(i >= arr.length) {
            return null;
        } else {
            TreeNode node = new TreeNode(arr[i]);
            node.left = makeBalancedTree(arr, i * 2);
            node.right = makeBalancedTree(arr, i * 2 + 1);
            return node;
        }
    }
    
    private boolean areTreesEqual(TreeNode n1, TreeNode n2) {
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
                        areTreesEqual(n1.left, n2.left) &&
                        areTreesEqual(n1.right, n2.right);
            }
        }
    }
}
