package medium.flatten_bt;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class TestFlattenBT {

    @Test
    public void testEmptyTree(){
        TreeNode tree = null;
        new Solution().flatten(tree);
        assertNull(tree);
    }
    
    @Test
    public void testLeftLeaningTree() {
        TreeNode tree = makeTree(new Integer[] {1,2,null,3,null,4,null,5,null});
        int[] expected = {1,2,3,4,5};
        new Solution().flatten(tree);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], tree.val);
            assertNull(tree.left);
            tree = tree.right;
        }
        assertNull(tree);
    }
    
    @Test
    public void testRightLeaningTree(){
        TreeNode tree = makeTree(new Integer[] {1,null,2,null,3,null,4,null,5});
        int[] expected = {1,2,3,4,5};
        new Solution().flatten(tree);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], tree.val);
            assertNull(tree.left);
            tree = tree.right;
        }
        assertNull(tree);
    }
    
    @Test
    public void testFullTree(){
        TreeNode tree = makeTree(new Integer[] {1,2,5,3,4,6,7});
        int[] expected = {1,2,3,4,5,6,7};
        new Solution().flatten(tree);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], tree.val);
            assertNull(tree.left);
            tree = tree.right;
        }
        assertNull(tree);
    }
    
    @Test
    public void testUnbalancedTreeLeft(){
        TreeNode tree = makeTree(new Integer[] {1,2,5,null,3,null,null,4,null});
        int[] expected = {1,2,3,4,5};
        new Solution().flatten(tree);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], tree.val);
            assertNull(tree.left);
            tree = tree.right;
        }
        assertNull(tree);
    }
    
    @Test
    public void testUnbalancedTreeRight(){
        TreeNode tree = makeTree(new Integer[] {1,2,3,null,null,4,null,null,5});
        int[] expected = {1,2,3,4,5};
        new Solution().flatten(tree);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], tree.val);
            assertNull(tree.left);
            tree = tree.right;
        }
        assertNull(tree);
    }
    
    private TreeNode makeTree(Integer[] values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i + 1 < values.length && !queue.isEmpty(); i += 2) {
            TreeNode node = queue.remove();
            if(values[i] != null) {
                node.left = new TreeNode(values[i]);
                queue.add(node.left);
            }
            if(values[i + 1] != null) {
                node.right = new TreeNode(values[i + 1]);
                queue.add(node.right);
            }
        }
        return root;
    }
    
}
