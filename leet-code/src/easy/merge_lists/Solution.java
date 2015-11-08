package easy.merge_lists;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (l1 != null || l2 != null) {
            if(l1 == null) {
                tail.next = l2;
                break;
            } else if(l2 == null) {
                tail.next = l1;
                break;
            } else {
                if(l1.val <= l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
            }
            tail = tail.next;
        }
        return head.next;
    }
}
