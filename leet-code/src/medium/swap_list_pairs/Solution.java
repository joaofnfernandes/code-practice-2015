package medium.swap_list_pairs;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode slow = sentinel;
        ListNode fast = sentinel.next.next;
        
        while(fast != null) {
            ListNode tmp = fast.next;
            fast.next = slow.next;
            slow.next.next = tmp;
            slow.next = fast;
            
            slow = fast.next;
            if(tmp != null) {
                fast = tmp.next;
            } else {
                fast = null;
            }
            
        }
        return sentinel.next;
    }
}