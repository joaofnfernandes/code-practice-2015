package medium.sorted_arr_to_bst;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSortedArrayToBst {

    @Test
    public void testEmptyTree(){
        int[] values = {};
        TreeNode expected = null;
        TreeNode result = new Solution().sortedArrayToBST(values);
        assertTrue(isSameTree(expected, result));
    }
    
    @Test
    public void testFullTreeConsecutiveNums(){
        int[] values = {0,1,2,3,4,5,6};
        TreeNode expected = makeTree(new Integer[]{3,1,5,0,2,4,6});
        TreeNode result = new Solution().sortedArrayToBST(values);
        assertTrue(isSameTree(expected, result));
    }
    
    @Test
    public void testFullTreeNonCosecutiveNums(){
        int[] values = {0,2,3,5,7,10,11};
        TreeNode expected = makeTree(new Integer[]{5,2,10,0,3,7,11});
        TreeNode result = new Solution().sortedArrayToBST(values);
        assertTrue(isSameTree(expected, result));
    }
    
    @Test
    public void testNotFullTreeConsecutiveNums(){
        int[] values = {0,1,2,3,4};
        TreeNode expected = makeTree(new Integer[]{2,1,4,0,null,3,null});
        TreeNode result = new Solution().sortedArrayToBST(values);
        assertTrue(isSameTree(expected, result));
    }
    
    @Test
    public void testNotFullTreeNonConsecutiveNums(){
        int[] values = {0,2,3,5,9};
        TreeNode expected = makeTree(new Integer[]{3,2,9,0,null,5,null});
        TreeNode result = new Solution().sortedArrayToBST(values);
        assertTrue(isSameTree(expected, result));
    }
    
    
    private TreeNode makeTree(Integer[] values){
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = null;
        for(int i = 1; !queue.isEmpty() && i + 1 < values.length; i += 2) {
            node = queue.remove();
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
    
    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            if(t2 == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if(t2 == null) {
                return false;
            } else {
                if(t1.val == t2.val) {
                    return isSameTree(t1.left, t2.left) &&
                            isSameTree(t1.right,  t2.right);
                } else {
                    return false;
                }
            }
        }
    }
}
