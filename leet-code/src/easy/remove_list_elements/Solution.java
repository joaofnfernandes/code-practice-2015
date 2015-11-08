package easy.remove_list_elements;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode previous = sentinel;
        while(head != null) {
            if(head.val == val) {
                previous.next = previous.next.next;
            } else {
                previous = previous.next;
            }
            
            if(previous != null) {
                head = previous.next;
            } else {
                head = null;
            }
        }
        return sentinel.next;
    }
}
