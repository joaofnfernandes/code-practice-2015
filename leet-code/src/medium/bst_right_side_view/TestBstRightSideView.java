package medium.bst_right_side_view;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class TestBstRightSideView {

    @Test
    public void testEmptyTree() {
        TreeNode tree = null;
        List<Integer> expected = Arrays.asList(new Integer[] {});
        List<Integer> result = new Solution().rightSideView(tree);
        assertTrue(isSameList(expected, result));
    }
    
    @Test
    public void testFullTree(){
        TreeNode tree = makeTree(new Integer[] {4,2,6,1,3,5,7});
        List<Integer> expected = Arrays.asList(new Integer[] {4,6,7});
        List<Integer> result = new Solution().rightSideView(tree);
        assertTrue(isSameList(expected, result));
    }
    
    @Test
    public void testLeftLeaningTree(){
        TreeNode tree = makeTree(new Integer[] {5,4,null,3,null,2,null,1,null});
        List<Integer> expected = Arrays.asList(new Integer[] {5,4,3,2,1});
        List<Integer> result = new Solution().rightSideView(tree);
        assertTrue(isSameList(expected, result));
    }
    
    @Test
    public void testRightLeaningTree(){
        TreeNode tree = makeTree(new Integer[] {1,null,2,null,3,null,4,null,5});
        List<Integer> expected = Arrays.asList(new Integer[] {1,2,3,4,5});
        List<Integer> result = new Solution().rightSideView(tree);
        assertTrue(isSameList(expected, result));
    }
    
    @Test
    public void testUnbalancedTree() {
        TreeNode tree = makeTree(new Integer[] {10,9,11,7,null,null,null,6,8,3,null,null,null,null,4,null,5});
        List<Integer> expected = Arrays.asList(new Integer[] {10,11,7,8,3,4,5});
        List<Integer> result = new Solution().rightSideView(tree);
        assertTrue(isSameList(expected, result));
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
    
    private boolean isSameList(List<Integer> l1, List<Integer> l2) {
        if(l1.size() != l2.size()) { return false; }
        Iterator<Integer> iter1 = l1.iterator(), iter2 = l2.iterator();
        while(iter1.hasNext() && iter2.hasNext()) {
            if(iter1.next() != iter2.next()) { return false; }
        }
        return true;
    }
}
