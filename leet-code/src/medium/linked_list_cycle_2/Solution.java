package medium.linked_list_cycle_2;

import java.util.HashSet;

public class Solution {
    // Uses fast/slow technique to detect cycles in a linked list
    // Counts the N nodes are part of the cycle
    // Repositions pointers with N distance between them, and traverses the list again
    // Pointers meet a the beginning of the cycle
    public ListNode detectCycle(ListNode head) {
        ListNode node = floydCycleDetection(head);
        if(node == null) { return null;} // no cycle
        int n = countNodesInCycle(node);
        ListNode ptr1 = head, ptr2 = head;
        for (int i = 0; i < n; i++) {
            ptr2 = ptr2.next;
        }
        while(ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
    
    private ListNode floydCycleDetection(ListNode head) {
        if(head == null) {return null;}
        ListNode slow = head;
        ListNode fast = slow.next;

        while(fast != null && fast != slow) {
            slow = slow.next;
            fast = fast.next;
            if(fast != null) { fast = fast.next;}
        }
        return fast;
    }
    
    private int countNodesInCycle(ListNode nodeInCycle) {
        int n = 0;
        HashSet<ListNode> set = new HashSet<>();
        while(!set.contains(nodeInCycle)) {
            set.add(nodeInCycle);
            n++;
            nodeInCycle = nodeInCycle.next;
        }
        return n;
    }
}