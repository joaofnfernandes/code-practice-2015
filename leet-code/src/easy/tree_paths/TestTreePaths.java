package easy.tree_paths;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestTreePaths {

    @Test
    public void testEmptyTree(){
        TreeNode tree = null;
        String[] expected = {};
        List<String> resultList = new Solution().binaryTreePaths(tree); 
        String[] result = new String[resultList.size()];
        result = resultList.toArray(result);
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testFullTree(){
        TreeNode tree = makeTree(new Integer[]{1,2,2,3,3,3,3});
        String[] expected = {"1->2->3", "1->2->3", "1->2->3", "1->2->3"};
        List<String> resultList = new Solution().binaryTreePaths(tree); 
        String[] result = new String[resultList.size()];
        result = resultList.toArray(result);
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testLeftLeaningTree(){
        TreeNode tree = makeTree(new Integer[]{1,2,null,3,null});
        String[] expected = {"1->2->3"};
        List<String> resultList = new Solution().binaryTreePaths(tree); 
        String[] result = new String[resultList.size()];
        result = resultList.toArray(result);
        assertArrayEquals(expected, result);
        
    }
    
    @Test
    public void testRightLeaningTree(){
        TreeNode tree = makeTree(new Integer[]{1,null, 2, null, 3});
        String[] expected = {"1->2->3"};
        List<String> resultList = new Solution().binaryTreePaths(tree); 
        String[] result = new String[resultList.size()];
        result = resultList.toArray(result);
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testUnbalancedTree(){
        TreeNode tree = makeTree(new Integer[]{1,2,2,null,3,3,null});
        String[] expected = {"1->2->3", "1->2->3"};
        List<String> resultList = new Solution().binaryTreePaths(tree); 
        String[] result = new String[resultList.size()];
        result = resultList.toArray(result);
        assertArrayEquals(expected, result);
    }
    
    private TreeNode makeTree(Integer[] values) {
        int i = 0;
        TreeNode node;
        Integer value;
        
        TreeNode head = new TreeNode(values[i++]);
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(head);
        while(!queue.isEmpty() && i + 1 < values.length) {
            node = queue.pop();
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
