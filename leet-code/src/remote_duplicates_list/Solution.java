package remote_duplicates_list;

/*
 * Assuming the list is sorted, remove duplicates
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = head;
        while(ptr != null) {
            if(ptr.next != null && ptr.val == ptr.next.val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }
        return head;
    }
}