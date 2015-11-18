package medium.linked_list_cycle;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestListHasCycle {
    
    @Test
    public void testEmptyList(){
        ListNode node = null;
        assertFalse(new Solution().hasCycle(node));
    }
    
    @Test
    public void testOneElementNoCycle(){
        ListNode head = new ListNode(0);
        assertFalse(new Solution().hasCycle(head));
    }
    
    @Test
    public void testTwoElemenentsNoCycle(){
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        assertFalse(new Solution().hasCycle(head));
    }
    
    @Test
    public void testOneElementCycle(){
        ListNode head = new ListNode(0);
        head.next = head;
        assertTrue(new Solution().hasCycle(head));
    }
    
    @Test
    public void testTwoElementsCycle(){
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = head;
        assertTrue(new Solution().hasCycle(head));
    }
    
    @Test
    public void testThreeElementsCycle(){
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = head;
        assertTrue(new Solution().hasCycle(head));
    }

}
