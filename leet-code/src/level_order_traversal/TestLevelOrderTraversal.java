package level_order_traversal;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TestLevelOrderTraversal {
    
    @Test
    public void testEmptyTree(){
        TreeNode tree = null;
        Integer[][] expected = {};
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.levelOrder(tree)));
    }
    
    @Test
    public void testBalancedTree(){
        TreeNode tree = makeTree(new Integer[]{1,2,2,3,3,3,3});
        Integer[][] expected = {{1},{2,2},{3,3,3,3}};
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.levelOrder(tree)));
    }
    
    @Test
    public void testLeftLeaningTree(){
        TreeNode tree = makeTree(new Integer[]{1,2,null,3,null});
        Integer[][] expected = {{1},{2},{3}};
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.levelOrder(tree)));
    }
    
    @Test
    public void testRightLeaningTree(){
        TreeNode tree = makeTree(new Integer[]{1,null,2,null,3});
        Integer[][] expected = {{1},{2},{3}};
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.levelOrder(tree)));
    }
    
    @Test
    public void testNonBalancedTree(){
        TreeNode tree = makeTree(new Integer[]{1,2,2,null,3,3,null});
        Integer[][] expected = {{1},{2,2},{3,3}};
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.levelOrder(tree)));
    }
    
    
    private TreeNode makeTree(Integer[] values) {
        if(values == null || values.length < 1) {
            return null;
        }
        TreeNode head = new TreeNode(values[0]);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int i = 1;
        while(!queue.isEmpty() && i + 1 < values.length) {
            TreeNode node = queue.pop();
            Integer left = values[i++];
            if(left != null) {
                node.left = new TreeNode(left);
                queue.add(node.left);
            }
            Integer right = values[i++];
            if(right != null) {
                node.right = new TreeNode(right);
                queue.add(node.right);
            }
        }
        return head;
    }
    
    private boolean isSameList(Integer[][] expected, List<List<Integer>> result) {
        if(expected.length != result.size()) {
            return false;
        } else {
            for (int i = 0; i < expected.length; i++) {
                List<Integer> resultRow = result.get(i);
                if(expected[i].length != resultRow.size()) {
                    return false;
                } else {
                    for (int j = 0; j < expected[i].length; j++) {
                        if(expected[i][j] != resultRow.get(j)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
