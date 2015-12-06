package medium.inorder_traversal;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestInOrderTraversal {

    @Test
    public void testEmptyTree(){
        TreeNode tree = null;
        Integer[] expected = {};
        Integer[] result = new Integer[expected.length];
        result = new Solution().inorderTraversal(tree).toArray(result);
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testFullTree(){
        TreeNode tree = makeTree(new Integer[] {4,2,6,1,3,5,7});
        Integer[] expected = {1,2,3,4,5,6,7};
        Integer[] result = new Integer[expected.length];
        result = new Solution().inorderTraversal(tree).toArray(result);
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testLeftLeaningTree(){
        TreeNode tree = makeTree(new Integer[] {4,3,null,2,null,1,null});
        Integer[] expected = {1,2,3,4};
        Integer[] result = new Integer[expected.length];
        result = new Solution().inorderTraversal(tree).toArray(result);
        assertArrayEquals(expected, result);
    }
    
    // TODO: tests are failing
    @Test
    public void testLeftLeaningTree2(){
        TreeNode tree = makeTree(new Integer[] {2,1, null});
        Integer[] expected = {1,2};
        Integer[] result = new Integer[expected.length];
        result = new Solution().inorderTraversal(tree).toArray(result);
        assertArrayEquals(expected, result);
    }
    
    
    
    @Test
    public void testRightLeaningTree(){
        TreeNode tree = makeTree(new Integer[] {1,null,2,null,3,null,4});
        Integer[] expected = {1,2,3,4};
        Integer[] result = new Integer[expected.length];
        result = new Solution().inorderTraversal(tree).toArray(result);
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testUnbalancedLeftTree(){
        TreeNode tree = makeTree(new Integer[] {4,2,null,1,3});
        Integer[] expected = {1,2,3,4};
        Integer[] result = new Integer[expected.length];
        result = new Solution().inorderTraversal(tree).toArray(result);
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testUnbalancedRightTree(){
        TreeNode tree = makeTree(new Integer[] {1,null,3,2,4});
        Integer[] expected = {1,2,3,4};
        Integer[] result = new Integer[expected.length];
        result = new Solution().inorderTraversal(tree).toArray(result);
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testUnbalancedCenterTree(){
        TreeNode tree = makeTree(new Integer[] {5,1,10,null,2,9,null,null,3,8,null});
        Integer[] expected = {1,2,3,5,8,9,10};
        Integer[] result = new Integer[expected.length];
        result = new Solution().inorderTraversal(tree).toArray(result);
        assertArrayEquals(expected, result);
    }
    
    private TreeNode makeTree(Integer[] values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; !queue.isEmpty() && i < values.length - 1; i +=2) {
            TreeNode node = queue.remove();
            if(values[i] != null) {
                node.left = new TreeNode(values[i]);
                queue.add(node.left);
            }
            if(values[i + 1] != null) {
                node.right = new TreeNode(values[i+ 1]);
                queue.add(node.right);
            }
        }
        return root;
    }
}
