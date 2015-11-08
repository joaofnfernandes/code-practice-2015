package easy.merge_lists;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMerge {

    @Test
    public void testListsOneElem() {
        ListNode in1 = makeList(new int[]{1});
        ListNode in2 = makeList(new int[]{2});
        ListNode expected = makeList(new int[]{1,2});
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.mergeTwoLists(in1, in2)));
    }

    @Test
    public void testSameSizeLists() {
        ListNode in1 = makeList(new int[]{1,2,3,5});
        ListNode in2 = makeList(new int[]{4,6,7,8});
        ListNode expected = makeList(new int[]{1,2,3,4,5,6,7,8});
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.mergeTwoLists(in1, in2)));
    }

    @Test
    public void testLeftListLonger() {
        ListNode in1 = makeList(new int[]{2,3,4,5});
        ListNode in2 = makeList(new int[]{1,6});
        ListNode expected = makeList(new int[]{1,2,3,4,5,6});
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.mergeTwoLists(in1, in2)));
    }

    @Test
    public void testRightListLonger() {
        ListNode in1 = makeList(new int[]{1,6});
        ListNode in2 = makeList(new int[]{2,3,4,5});
        ListNode expected = makeList(new int[]{1,2,3,4,5,6});
        Solution sol = new Solution();
        assertTrue(isSameList(expected, sol.mergeTwoLists(in1, in2)));
    }

    private ListNode makeList(int[] values) {
        return makeList(values, 0);
    }

    private ListNode makeList(int[] values, int i) {
        if (i >= values.length) {
            return null;
        } else {
            ListNode node = new ListNode(values[i]);
            node.next = makeList(values, i + 1);
            return node;
        }
    }

    private boolean isSameList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            if (l2 == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if(l2 == null) {
                return false;
            } else {
                return l1.val == l2.val && isSameList(l1.next, l2.next);
            }
        }
    }

}
