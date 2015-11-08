package easy.max_depth_bt;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMaxDepth {

    @Test
    public void testEmptyTree(){
        TreeNode tree = null;
        assertEquals(0, new Solution().maxDepth(tree));
    }
    
    @Test
    public void testTreeSingleNode(){
        TreeNode tree = new TreeNode(0);
        assertEquals(1, new Solution().maxDepth(tree));
    }
    
    @Test
    public void testTree3LeftNods(){
        TreeNode tree = new TreeNode(0);
        tree.left = new TreeNode(1);
        tree.left.left = new TreeNode(2);
        assertEquals(3, new Solution().maxDepth(tree));
    }
}
