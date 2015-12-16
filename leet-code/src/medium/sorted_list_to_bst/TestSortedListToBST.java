package medium.sorted_list_to_bst;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class TestSortedListToBST {

    @Test
    public void testEmptyList() {
        ListNode list = makeList(new int[] {});
        TreeNode solution = new Solution().sortedListToBST(list);
        assertNull(solution);
    }
    
    @Test
    public void testEvenSizedList(){
        ListNode list = makeList(new int[] {1,2,3,4,5,6});
        TreeNode solution = new Solution().sortedListToBST(list);
        TreeNode expected = makeTree(new Integer[] {4,2,6,1,3,5, null});
        assertTrue(isSameTree(expected, solution));
    }
    
    @Test
    public void testOddSizedList(){
        ListNode list = makeList(new int[] {1,2,3,4,5});
        TreeNode solution = new Solution().sortedListToBST(list);
        TreeNode expected = makeTree(new Integer[] {3,2,5,1,null,4,null});
        assertTrue(isSameTree(expected, solution));
    }
    
    @Test
    public void testFullTree(){
        ListNode list = makeList(new int[] {1,2,3,4,5,6,7});
        TreeNode solution = new Solution().sortedListToBST(list);
        TreeNode expected = makeTree(new Integer[] {4,2,6,1,3,5,7});
        assertTrue(isSameTree(expected, solution));
    }
    
    private ListNode makeList(int[] values) {
        if(values == null || values.length < 1) { return null; }
        ListNode head = new ListNode(values[0]);
        ListNode tail = head;
        for (int i = 1; i < values.length; i++) {
            tail.next = new ListNode(values[i]);
            tail = tail.next;
        }
        return head;
    }
    
    private TreeNode makeTree(Integer[] values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i + 1 < values.length && !queue.isEmpty(); i +=2) {
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
    
    private boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            if(node2 == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if(node2 == null) {
                return false;
            } else {
                return node1.val == node2.val &&
                        isSameTree(node1.left, node2.left) &&
                        isSameTree(node1.right, node2.right);
            }
        }
    }
}
