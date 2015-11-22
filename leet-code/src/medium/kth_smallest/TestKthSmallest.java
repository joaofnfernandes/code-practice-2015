
package medium.kth_smallest;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class TestKthSmallest {

    @Test
    public void testFullTreeFirst(){
        TreeNode tree = makeTree(new Integer[]{6,4,8,3,5,7,9});
        int k = 1;
        int expected = 3;
        assertEquals(expected, new Solution().kthSmallest(tree, k));
    }
    
    @Test
    public void testFullTreeLast(){
        TreeNode tree = makeTree(new Integer[]{6,4,8,3,5,7,9});
        int k = 7;
        int expected = 9;
        assertEquals(expected, new Solution().kthSmallest(tree, k));
    }
    
    @Test
    public void testFullTreeMiddleLeft(){
        TreeNode tree = makeTree(new Integer[]{6,4,8,3,5,7,9});
        int k = 2;
        int expected = 4;
        assertEquals(expected, new Solution().kthSmallest(tree, k));
    }
    
    @Test
    public void testFullTreeMiddleRight(){
        TreeNode tree = makeTree(new Integer[]{6,4,8,3,5,7,9});
        int k = 6;
        int expected = 8;
        assertEquals(expected, new Solution().kthSmallest(tree, k));
    }
    
    @Test
    public void testLeftLeaningTreeMiddleLeft(){
        TreeNode tree = makeTree(new Integer[]{6,5,null,3,null,null,4});
        int k = 3;
        int expected = 5;
        assertEquals(expected, new Solution().kthSmallest(tree, k));
    }
    
    @Test
    public void testLeftLeaningTreeMiddleRight(){
        TreeNode tree = makeTree(new Integer[]{6,4,8,3,5,7,9});
        int k = 2;
        int expected = 4;
        assertEquals(expected, new Solution().kthSmallest(tree, k));
    }
    
    @Test
    public void testRightLeaningTreeMiddleRight(){
        TreeNode tree = makeTree(new Integer[]{1,null,2,null,4,3,null});
        int k = 4;
        int expected = 4;
        assertEquals(expected, new Solution().kthSmallest(tree, k));
    }
    
    @Test
    public void testRightLeaningTreeMiddleLeft(){
        TreeNode tree = makeTree(new Integer[]{1,null,2,null,4,3,null});
        int k = 3;
        int expected = 3;
        assertEquals(expected, new Solution().kthSmallest(tree, k));
    }
    
    private TreeNode makeTree(Integer[] values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; !queue.isEmpty() && i + 1 < values.length; i += 2) {
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
