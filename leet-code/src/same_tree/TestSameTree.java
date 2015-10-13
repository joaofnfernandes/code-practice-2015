package same_tree;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSameTree {

    @Test
    public void testEmptyTrees() {
        TreeNode p = null, q = null;
        assertTrue(new Solution().isSameTree(p, q));
    }
    
    @Test
    public void testTreeVsEmpty() {
        TreeNode p = null, q = new TreeNode(0);
        assertFalse(new Solution().isSameTree(p, q));
    }
    
    @Test
    public void testDifferentTrees(){
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(0);
        
        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);
        
        assertFalse(new Solution().isSameTree(p, q));
    }
    
    @Test
    public void testSameTree(){
        TreeNode p = new TreeNode(1);
        TreeNode q = p;
        p.left = new TreeNode(0);
        
        assertTrue(new Solution().isSameTree(p, q));
        p.right = new TreeNode(2);
        assertTrue(new Solution().isSameTree(p, q));
    }
    

}
