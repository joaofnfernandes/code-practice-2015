package lowest_ancestor_bst;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCommonAncestor {

    @Test
    public void testEmptyTree(){
        TreeNode tree = null;
        assertEquals(null, new Solution().lowestCommonAncestor(tree, tree, tree));
    }
    
    @Test
    public void testParentAndLeftChild(){
        TreeNode tree = new TreeNode(1);
        TreeNode left = new TreeNode(0);
        tree.left = left;
        
        assertEquals(tree, new Solution().lowestCommonAncestor(tree, left, tree));
    }
    
    @Test
    public void testParentAndRightChild(){
        TreeNode tree = new TreeNode(1);
        TreeNode right = new TreeNode(0);
        tree.right = right;
        
        assertEquals(tree, new Solution().lowestCommonAncestor(tree, right, tree));
    }
    
    @Test
    public void testGrandparent1(){
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        
        TreeNode p = new TreeNode(2);
        tree.left.right = p;
        
        tree.right = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        tree.right.left = q;
        assertEquals(tree, new Solution().lowestCommonAncestor(tree, p, q));
    }
    
    @Test
    public void testGrandparent2(){
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        
        TreeNode p = new TreeNode(0);
        tree.left.left = p;
        
        tree.right = new TreeNode(5);
        TreeNode q = new TreeNode(6);
        tree.right.right = q;
        assertEquals(tree, new Solution().lowestCommonAncestor(tree, p, q));
    }
}
