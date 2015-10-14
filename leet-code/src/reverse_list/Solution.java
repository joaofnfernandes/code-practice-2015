package reverse_list;

public class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
    
    private ListNode reverse(ListNode node, ListNode previous) {
        if(node == null) {
            return previous;
        } else {
            ListNode next = node.next;
            node.next = previous;
            return reverse(next, node);
        }
    }
    
    // Iterative solution
    public ListNode reverseList2(ListNode head) {
            if(head == null) {
                return null;
            }
            if(head.next == null) {
                return head;
            }
            ListNode one = head;
            ListNode two = head.next;
            ListNode three = head.next.next;
            one.next = null;
            while(two != null) {
                two.next = one;
                one = two;
                two = three;
                if(three != null) {
                    three = three.next;
                }
            }
            return one;
        }
}
