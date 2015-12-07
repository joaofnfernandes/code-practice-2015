package medium.BST_iterator;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class TestBstIterator {

    @Test
    public void testEmptyTree(){
        TreeNode tree = null;
        BSTIterator iter = new BSTIterator(tree);
        assertFalse(iter.hasNext());
    }
    
    @Test
    public void testFullTree() {
        TreeNode tree = makeTree(new Integer[] {4,2,6,1,3,5,7});
        int[] expected = {1,2,3,4,5,6,7};
        BSTIterator iter = new BSTIterator(tree);
        for (int value : expected) {
            assertTrue(iter.hasNext());
            assertEquals(value, iter.next());
        }
    }
    
    @Test
    public void testLeftLeaningTree(){
        TreeNode tree = makeTree(new Integer[] {5,4,null,3,null,2,null,1,null});
        int[] expected = {1,2,3,4,5};
        BSTIterator iter = new BSTIterator(tree);
        for (int value : expected) {
            assertTrue(iter.hasNext());
            assertEquals(value, iter.next());
        }
    }
    
    @Test
    public void testRightLeaningTree(){
        TreeNode tree = makeTree(new Integer[] {1,null,2,null,3,null,4,null,4});
        int[] expected = {1,2,3,4};
        BSTIterator iter = new BSTIterator(tree);
        for (int value : expected) {
            assertTrue(iter.hasNext());
            assertEquals(value, iter.next());
        }
    }
    
    @Test
    public void testUnbalancedTree(){
        TreeNode tree = makeTree(new Integer[] {5,2,7,null,4,null,10,3,null,8,null});
        int[] expected = {2,3,4,5,7,8,10};
        BSTIterator iter = new BSTIterator(tree);
        for (int value : expected) {
            assertTrue(iter.hasNext());
            assertEquals(value, iter.next());
        }
    }
    
    private TreeNode makeTree(Integer[] values) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(values[0]);
        queue.add(root);
        for (int i = 1; i + 1 < values.length; i += 2) {
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
