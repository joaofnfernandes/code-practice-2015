package medium.populate_right_next_ptr;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class TestConnectTree {

    @Test
    public void testEmptyTree() {
        TreeLinkNode node = null;
        new Solution().connect(node);
        assertNull(node);
    }
    
    @Test
    public void testTree1Level() {
        TreeLinkNode node = makeTree(new Integer[]{1});
        new Solution().connect(node);
        assertNull(node.left);
        assertNull(node.right);
        assertNull(node.next);
    }
    
    @Test
    public void testTree3Levels() {
        TreeLinkNode node = makeTree(new Integer[] {1,2,3,4,5,6,7});
        new Solution().connect(node);
        // level 1
        assertEquals(node.left.next, node.right);
        assertEquals(node.left.left.next, node.left.right);
        assertEquals(node.left.right.next , node.right.left);
        assertEquals(node.right.left.next, node.right.right);
    }
    
    private TreeLinkNode makeTree(Integer[] values) {
        int i = 0;
        TreeLinkNode root = new TreeLinkNode(values[i++]);
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty() && (i + 1 < values.length)) {
            TreeLinkNode node = queue.remove();
            if(values[i] != null) {
                node.left = new TreeLinkNode(values[i]);
                queue.add(node.left);
            }
            if(values[i + 1] != null) {
                node.right = new TreeLinkNode(values[i + 1]);
                queue.add(node.right);
            }
            i += 2;
        }
        return root;
    }
}
