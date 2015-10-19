package list_intersection;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestListIntersection {

    @Test
    public void testNonIntersectingLists() {
        ListNode listA = makeList(new int[]{1,2,3});
        ListNode listB = makeList(new int[]{4,5,6});
        Solution sol = new Solution();
        assertEquals(null, sol.getIntersectionNode(listA, listB));
    }

    // Lists intersect in middle
    @Test
    public void testIntersectingLists1() {
        ListNode listA = makeList(new int[]{4,5,6,7});
        ListNode listB = makeList(new int[]{1,2});
        listB.next.next = listA.next.next;
        Solution sol = new Solution();
        assertEquals(listA.next.next, sol.getIntersectionNode(listA, listB));
    }

    // List B starts on middle of list A
    @Test
    public void testIntersectingList2() {
        ListNode listA = makeList(new int[]{4,5,6,7,8});
        ListNode listB = listA.next.next;
        Solution sol = new Solution();
        assertEquals(listB, sol.getIntersectionNode(listA, listB));
    }

    // List A starts on middle of list B
    @Test
    public void testIntersectingList3() {
        ListNode listB = makeList(new int[]{4,5,6,7,8});
        ListNode listA = listB.next.next;
        Solution sol = new Solution();
        assertEquals(listA, sol.getIntersectionNode(listA, listB));
    }
    
    // Lists intersect on last node
    @Test
    public void testIntersectingList4() {
        ListNode listA = makeList(new int[]{1,2,3});
        ListNode listB = listA.next.next;
        Solution sol = new Solution();
        assertEquals(listB, sol.getIntersectionNode(listA, listB));
    }

    private ListNode makeList(int[] values) {
        return makeList(values, 0);
    }

    private ListNode makeList(int[] values, int i) {
        if(i >= values.length) {
            return null;
        } else {
            ListNode node = new ListNode(values[i]);
            node.next = makeList(values, i + 1);
            return node;
        }
    }
}
