package reverse_list;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestReverseList {

    @Test
    public void testList1Elem(){
        ListNode input = makeList(new int[] {1});
        ListNode expected = makeList(new int[]{1});
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.reverseList(input)));
        input = makeList(new int[] {1});
        assertTrue(isSameList(expected, sol.reverseList2(input)));
    }
    
    @Test
    public void testList2Elemn(){
        ListNode input = makeList(new int[] {1,2});
        ListNode expected = makeList(new int[]{2,1});
        Solution sol = new Solution();
        
        assertTrue(isSameList(expected, sol.reverseList(input)));
        input = makeList(new int[] {1,2});
        assertTrue(isSameList(expected, sol.reverseList2(input)));
    }
    
    @Test
    public void testListNElemn(){
        ListNode input = makeList(new int[] {1,2,3,4,5,6,7});
        ListNode expected = makeList(new int[]{7,6,5,4,3,2,1});
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.reverseList(input)));
        input = makeList(new int[] {1,2,3,4,5,6,7});
        assertTrue(isSameList(expected, sol.reverseList2(input)));
    }
    
    private ListNode makeList(int[] values) {
        if(values == null) {
            return null;
        }
        ListNode head = null, tail = null;
        for (int i = 0; i < values.length; i++) {
            if(i == 0) {
                head = new ListNode(values[i]);
                tail = head;
            } else {
                tail.next = new ListNode(values[i]);
                tail = tail.next;
            }
        }
        return head;
    }
    
    private boolean isSameList(ListNode h1, ListNode h2) {
        while(h1 != null && h2 != null) {
            if(h1.val != h2.val) {
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1 == null && h2 == null;
    }
    
}
