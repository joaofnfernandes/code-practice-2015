package height_balanced;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIsBalanced {

    @Test
    public void testBalancedTree1() {
        TreeNode input = makeTree(new Integer[] {-1, 2, 1});
        Solution sol = new Solution();
        assertTrue(sol.isBalanced(input));
    }

    @Test
    public void testBalanceTree2() {
        TreeNode input = makeTree(new Integer[] {-1, 5, 4, 6, 3, null, null, 7});
        Solution sol = new Solution();
        assertTrue(sol.isBalanced(input));
    }
    
    @Test
    public void testUnbalancedTreeLeft(){
        TreeNode input = makeTree(new Integer[] {-1,4,3,5,2,null,null,null,1});
        Solution sol = new Solution();
        assertFalse(sol.isBalanced(input));
    }
    
    @Test
    public void unbalancedTreeRight(){
        TreeNode input = makeTree(new Integer[] {-1,2,1,3,null,null,null,4,null,null,null,null,null,null,null,5});
        Solution sol = new Solution();
        assertFalse(sol.isBalanced(input));
    }

    private TreeNode makeTree(Integer[] values) {
        return makeTree(values, 1);
    }

    private TreeNode makeTree(Integer[] values, int i) {
        if (i >= values.length || values[i] == null) {
            return null;
        } else {
            TreeNode node = new TreeNode(values[i]);
            node.left = makeTree(values, i * 2);
            node.right = makeTree(values, (i * 2) + 1);
            return node;
        }
    }
}
