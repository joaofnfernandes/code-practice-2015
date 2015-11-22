package medium.swap_list_pairs;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSwapPairs {

    @Test
    public void testSwapEmptyList(){
        ListNode list = null;
        ListNode expected = null;
        list = new Solution().swapPairs(list);
        assertTrue(isSameList(expected, list));
    }
    
    @Test
    public void testSwapListOneElement(){
        ListNode list = makeList(new int[]{1});
        ListNode expected = makeList(new int[]{1});
        list = new Solution().swapPairs(list);
        assertTrue(isSameList(expected, list));
    }
    
    @Test
    public void testSwapListTwoElements(){
        ListNode list = makeList(new int[]{1,2});
        ListNode expected = makeList(new int[]{2,1});
        list = new Solution().swapPairs(list);
        assertTrue(isSameList(expected, list));
    }
    
    @Test
    public void testSwapListThreeElements(){
        ListNode list = makeList(new int[]{1,2,3});
        ListNode expected = makeList(new int[]{2,1,3});
        list = new Solution().swapPairs(list);
        assertTrue(isSameList(expected, list));
    }
    
    @Test
    public void testSwapListFourElements(){
        ListNode list = makeList(new int[]{1,2,3,4});
        ListNode expected = makeList(new int[]{2,1,4,3});
        list = new Solution().swapPairs(list);
        assertTrue(isSameList(expected, list));
    }
    
    @Test
    public void testSwapListOddElements() {
        ListNode list = makeList(new int[]{1,2,3,4,5,6,7});
        ListNode expected = makeList(new int[]{2,1,4,3,6,5,7});
        list = new Solution().swapPairs(list);
        assertTrue(isSameList(expected, list));
    }
    
    @Test
    public void testSwapListEvenElements() {
        ListNode list = makeList(new int[]{1,2,3,4,5,6});
        ListNode expected = makeList(new int[]{2,1,4,3,6,5});
        list = new Solution().swapPairs(list);
        assertTrue(isSameList(expected, list));
    }
    
    private ListNode makeList(int[] values) {
        ListNode head = new ListNode(values[0]);
        ListNode node = head;
        for (int i = 1; i < values.length; i++) {
            node.next = new ListNode(values[i]);
            node = node.next;
        }
        return head;
    }
    
    private boolean isSameList(ListNode l1, ListNode l2) {
        while(l1 != null && l2 != null) {
            if(l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
}
