package medium.preorder_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPreorderTraversal {

    @Test
    public void testEmptyTree() {
        TreeNode node = null;
        Integer[] expected = {};
        List<Integer> resultList = new Solution().preorderTraversal(node);
        Integer[] result = new Integer[resultList.size()];
        result = resultList.toArray(result);
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testFullTree(){
        TreeNode tree = makeTree(new Integer[]{1,2,3,4,5,6,7});
        Integer[] expected = {1,2,4,5,3,6,7};
        List<Integer> resultList = new Solution().preorderTraversal(tree);
        Integer[] result = new Integer[resultList.size()];
        result = resultList.toArray(result);
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testLeftLeaningTree(){
        TreeNode tree = makeTree(new Integer[]{1,2,null,3,null});
        Integer[] expected = {1,2,3};
        List<Integer> resultList = new Solution().preorderTraversal(tree);
        Integer[] result = new Integer[resultList.size()];
        result = resultList.toArray(result);
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRightLeaningTree(){
        TreeNode tree = makeTree(new Integer[]{1,null,2,null,3});
        Integer[] expected = {1,2,3};
        List<Integer> resultList = new Solution().preorderTraversal(tree);
        Integer[] result = new Integer[resultList.size()];
        result = resultList.toArray(result);
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void tesstUnbalancedTree(){
        TreeNode tree = makeTree(new Integer[]{1,2,3,null,4,5,null});
        Integer[] expected = {1,2,4,3,5};
        List<Integer> resultList = new Solution().preorderTraversal(tree);
        Integer[] result = new Integer[resultList.size()];
        result = resultList.toArray(result);
        assertArrayEquals(expected, result);
    }
    
    private TreeNode makeTree(Integer[] values) {
        if(values == null || values.length < 1) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int i = 0;
        TreeNode root = new TreeNode(values[i++]);
        queue.add(root);
        while(!queue.isEmpty() && i + 1 < values.length) {
            TreeNode node = queue.remove();
            if(values[i] != null) {
                node.left = new TreeNode(values[i]);
                queue.add(node.left);
            }
            if(values[i + 1] != null) {
                node.right = new TreeNode(values[i + 1]);
                queue.add(node.right);
            }
            i += 2;
        }
        return root;
    }
}
