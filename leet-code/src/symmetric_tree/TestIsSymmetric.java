package symmetric_tree;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayDeque;


public class TestIsSymmetric {

    @Test
    public void TestTree1Elem(){
        TreeNode tree = makeTree(new Integer[]{1});
        Solution sol = new Solution();
        assertTrue(sol.isSymmetric(tree));
        assertTrue(sol.isSymmetric2(tree));
    }
    
    @Test
    public void TestMirrorFullTree(){
        TreeNode tree = makeTree(new Integer[]{1,2,2,3,4,4,3});
        Solution sol = new Solution();
        assertTrue(sol.isSymmetric(tree));
        assertTrue(sol.isSymmetric2(tree));
    }
    
    @Test
    public void TestMirrorNotFullTree1(){
        TreeNode tree = makeTree(new Integer[]{1,2,2,3,null,null,3});
        Solution sol = new Solution();
        assertTrue(sol.isSymmetric(tree));
        assertTrue(sol.isSymmetric2(tree));
    }
    
    @Test
    public void TestMirrorNotFullTree2(){
        TreeNode tree = makeTree(new Integer[]{1,2,2,null,3,3,null});
        Solution sol = new Solution();
        assertTrue(sol.isSymmetric(tree));
        assertTrue(sol.isSymmetric2(tree));
    }
    
    
    @Test
    public void TestNotMirrorUnbalancedTree1(){
        TreeNode tree = makeTree(new Integer[]{1,2,null});
        Solution sol = new Solution();
        assertFalse(sol.isSymmetric(tree));
        assertFalse(sol.isSymmetric2(tree));
    }
    
    @Test
    public void TestNotMirrorUnbalancedTree2(){
        TreeNode tree = makeTree(new Integer[]{1,null,2});
        Solution sol = new Solution();
        assertFalse(sol.isSymmetric(tree));
        assertFalse(sol.isSymmetric2(tree));
    }
    
    @Test
    public void TestNotMirrorUnbalancedTree3(){
        TreeNode tree = makeTree(new Integer[]{1,2,2,null,3,null,3});
        Solution sol = new Solution();
        assertFalse(sol.isSymmetric(tree));
        assertFalse(sol.isSymmetric2(tree));
    }
    
    @Test
    public void TestNotMirrorUnbalancedTree4(){
        TreeNode tree = makeTree(new Integer[]{1,2,2,3,null,3,null});
        Solution sol = new Solution();
        assertFalse(sol.isSymmetric(tree));
        assertFalse(sol.isSymmetric2(tree));
    }

    private TreeNode makeTree(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        int i = 0;
        TreeNode head = new TreeNode(values[i++]);
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(head);
        TreeNode node;
        while (i + 1 < values.length && !deque.isEmpty()) {
            node = deque.pop();
            if (values[i] != null) {
                node.left = new TreeNode(values[i]);
                deque.addLast(node.left);
            }
            i++;
            if (values[i] != null) {
                node.right = new TreeNode(values[i]);
                deque.addLast(node.right);
            }
            i++;
        }
        return head;
    }
}
