package remove_nth_node;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRemoveNth {

    @Test
    public void removeHead() {
        ListNode list = makeList(new int[] {1});
        int n = 1;
        int[] expected = {};
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.removeNthFromEnd(list, n)));
    }
    
    @Test
    public void remove1() {
        ListNode list = makeList(new int[] {1,2,3,4,5});
        int n = 1;
        int[] expected = {1,2,3,4};
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.removeNthFromEnd(list, n)));
    }

    @Test
    public void remove2() {
        ListNode list = makeList(new int[] {1,2,3,4,5});
        int n = 2;
        int[] expected = {1,2,3,5};
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.removeNthFromEnd(list, n)));
    }
    
    @Test
    public void remove3() {
        ListNode list = makeList(new int[] {1,2,3,4,5});
        int n = 3;
        int[] expected = {1,2,4,5};
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.removeNthFromEnd(list, n)));
    }

    private boolean isSameList(int[] expected, ListNode result) {
        int i = 0;
        for (i = 0; i < expected.length; i++) {
            if (result == null || expected[i] != result.val) {
                return false;
            }
            result = result.next;
        }
        return i > 0 ? true : result == null;
    }

    private ListNode makeList(int[] values) {
        return makeList(values, 0);
    }

    private ListNode makeList(int[] values, int i) {
        if (i >= values.length) {
            return null;
        } else {
            ListNode node = new ListNode(values[i]);
            node.next = makeList(values, i + 1);
            return node;
        }
    }

}
