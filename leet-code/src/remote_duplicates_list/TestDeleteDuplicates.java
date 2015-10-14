package remote_duplicates_list;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDeleteDuplicates {
    
    @Test
    public void testListWithoutDuplicates(){
        ListNode input = makeList(new int[]{1,2,3,4});
        ListNode expected = makeList(new int[]{1,2,3,4});
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.deleteDuplicates(input)));
    }
    
    @Test
    public void testListWithDuplicatesOnLeft(){
        ListNode input = makeList(new int[]{1,1,1,2,3,4});
        ListNode expected = makeList(new int[]{1,2,3,4});
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.deleteDuplicates(input)));
    }
    
    @Test
    public void testListWithDuplicatesOnRight(){
        ListNode input = makeList(new int[]{1,2,3,4,4,4,4});
        ListNode expected = makeList(new int[]{1,2,3,4});
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.deleteDuplicates(input)));
    }
    
    @Test
    public void testListInterleavedDuplicates(){
        ListNode input = makeList(new int[]{1,1,1,2,3,3,4,4,4});
        ListNode expected = makeList(new int[]{1,2,3,4});
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.deleteDuplicates(input)));
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
