package medium.sorted_list_to_bst;

/*
 * Creates a BST from a sorted linked list.
 * It recursively breaks the list in [left-list][mid-node][right-list]
 * To create [mid-node]
 *            /       \
 *      [left-list] [right-list]
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head, leftEnd = null;
        while (fast != null && fast.next != null) {
            leftEnd = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        // if list has only one element, return, otherwise break list in two
        if (leftEnd == null) {
            return node;
        } else {
            leftEnd.next = null;
        }
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);
        return node;
    }
}