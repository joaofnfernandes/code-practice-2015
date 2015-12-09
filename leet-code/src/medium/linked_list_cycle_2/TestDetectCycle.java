package medium.linked_list_cycle_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDetectCycle {

    @Test
    public void testEmptyLinkedList() {
        ListNode node = null;
        ListNode result = new Solution().detectCycle(node);
        ListNode expected = null;
        assertEquals(expected, result);
    }
    
    @Test
    public void testNoCycle1Element() {
        ListNode node = makeLinkedList(new int[]{1});
        ListNode result = new Solution().detectCycle(node);
        ListNode expected = null;
        assertEquals(expected, result);
    }
    
    @Test
    public void testNoCycleNElements(){
        ListNode node = makeLinkedList(new int[]{1,2,3,4,5});
        ListNode result = new Solution().detectCycle(node);
        ListNode expected = null;
        assertEquals(expected, result);
    }
    
    @Test
    public void testCycle1Element(){
        ListNode node = makeLinkedList(new int[]{1});
        node.next = node;
        ListNode result = new Solution().detectCycle(node);
        ListNode expected = node;
        assertEquals(String.format("Expected %d, was %d", getNodeValueOrNull(expected), getNodeValueOrNull(result)),
                    expected, result);
    }
    
    @Test
    public void testCycle2Elements() {
        ListNode node = makeClosedLinkedList(new int[]{1,2});
        ListNode result = new Solution().detectCycle(node);
        ListNode expected = node;
        assertEquals(String.format("Expected %d, was %d", getNodeValueOrNull(expected), getNodeValueOrNull(result)),
                expected, result);
    }
    
    @Test
    public void testCycleEndStartEven() {
        ListNode node = makeClosedLinkedList(new int[]{1,2,3,4,5,6});
        ListNode result = new Solution().detectCycle(node);
        ListNode expected = node;
        assertEquals(String.format("Expected %d, was %d", getNodeValueOrNull(expected), getNodeValueOrNull(result)),
                expected, result);
    }
    
    @Test
    public void testCycleEndStartOdd() {
        ListNode node = makeClosedLinkedList(new int[]{1,2,3,4,5,6,7});
        ListNode result = new Solution().detectCycle(node);
        ListNode expected = node;
        assertEquals(String.format("Expected %d, was %d", getNodeValueOrNull(expected), getNodeValueOrNull(result)),
                expected, result);
    }
    
    @Test
    public void testCycleEndMid() {
        ListNode node = makeLinkedList(new int[]{1,2,3});
        node.next.next.next = node.next;
        ListNode result = new Solution().detectCycle(node);
        ListNode expected = node.next;
        assertEquals(String.format("Expected %d, was %d", getNodeValueOrNull(expected), getNodeValueOrNull(result)),
                expected, result);
    }
    
    private ListNode makeLinkedList(int[] values) {
        ListNode head = new ListNode(values[0]);
        ListNode tail = head;
        for (int i = 1; i < values.length; i++) {
            tail.next = new ListNode(values[i]);
            tail = tail.next;
        }
        return head;
    }
    
    private ListNode makeClosedLinkedList(int[] values) {
        ListNode head = new ListNode(values[0]);
        ListNode tail = head;
        for (int i = 1; i < values.length; i++) {
            tail.next = new ListNode(values[i]);
            tail = tail.next;
        }
        tail.next = head;
        return head;
    }
    
    private Integer getNodeValueOrNull(ListNode node) {
        return node == null ? null : node.val;
    }
}
