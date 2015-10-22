package remove_list_elements;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRemoveElements {

    @Test
    public void testNoMatchingElements() {
        ListNode list = makeList(new int[] {1,2,3,4,5});
        int match = 0;
        int[] expected = {1,2,3,4,5};
        Solution sol = new Solution();
        list = sol.removeElements(list, match);
        assertTrue(isSameList(expected, list));
    }

    @Test
    public void testHeadMatches() {
        ListNode list = makeList(new int[] {1,2,3,4,5});
        int match = 1;
        int[] expected = {2,3,4,5};
        Solution sol = new Solution();
        list = sol.removeElements(list, match);
        assertTrue(isSameList(expected, list));
    }

    @Test
    public void testTailMatches() {
        ListNode list = makeList(new int[] {1,2,3,4,5});
        int match = 5;
        int[] expected = {1,2,3,4};
        Solution sol = new Solution();
        list = sol.removeElements(list, match);
        assertTrue(isSameList(expected, list));
    }
    
    @Test
    public void testAllMatches() {
        ListNode list = makeList(new int[] {0,0,0,0});
        int match = 0;
        int[] expected = {};
        Solution sol = new Solution();
        list = sol.removeElements(list, match);
        assertTrue(isSameList(expected, list));
    }

    @Test
    public void testInterleavedMatches() {
        ListNode list = makeList(new int[] {0,1,0,2,0,3,0});
        int match = 0;
        int[] expected = {1,2,3};
        Solution sol = new Solution();
        list = sol.removeElements(list, match);
        assertTrue(isSameList(expected, list));
    }
    
    private ListNode makeList(int[] values) {
        return makeList(values, 0);
    }
    
    private ListNode makeList(int[] values, int i) {
        if(i >= values.length){
            return null;
        } else {
            ListNode node = new ListNode(values[i]);
            node.next = makeList(values, i + 1);
            return node;
        }
    }
    
    private boolean isSameList(int[] expected, ListNode result) {
        if(result == null && expected.length > 0) {
            return false;
        }
        for (int i = 0; i < expected.length; i++) {
            if(result == null || expected[i] != result.val) {
                return false;
            }
            result = result.next;
        }
        return result == null;
    }
}
