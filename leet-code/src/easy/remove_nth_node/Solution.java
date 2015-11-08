package easy.remove_nth_node;

// Removes nth node from the end of a linked list. We offset a pointer by n nodes, to find
// the node to delete
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head;
        while(ptr != null && n-- > 0) {
            ptr = ptr.next;
        }
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        head = sentinel;
        while(ptr != null) {
            ptr = ptr.next;
            sentinel = sentinel.next;
        }
        sentinel.next = sentinel.next.next;
        return head.next;
    }
}