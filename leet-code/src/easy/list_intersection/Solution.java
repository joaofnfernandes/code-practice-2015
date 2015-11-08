package easy.list_intersection;


public class Solution {
    // Reduce the length of the longest list to the same of the shortest.
    // Now they are synchronized, and you can iterate both at same time to find intersection
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Sync list size
        int aSize = listSize(headA);
        int bSize = listSize(headB);
        if(aSize >= bSize) {
            headA = nodeGet(headA, aSize - bSize);
        } else {
            headB = nodeGet(headB, bSize - aSize);
        }
        // lists are synched, we can iterate
        while(headA != null && headB != null) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    private int listSize(ListNode node) {
        int size = 0;
        while(node != null) {
            size++;
            node = node.next;
        }
        return size;
    }
    
    private ListNode nodeGet(ListNode listHead, int i) {
        while(i > 0 && listHead != null) {
            listHead = listHead.next;
            i--;
        }
        return listHead;
    }
}
