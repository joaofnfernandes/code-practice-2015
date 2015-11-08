package easy.palindrome_list;

import java.util.ArrayList;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode middle = getMiddle(head);
        ListNode tail = revertList(middle.next);
        middle.next = null;
        
        while(head != null && tail != null) {
            if(head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        if(tail == null) {
            return true;
        } else {
            return false;
        }
    }
    
    private ListNode getMiddle(ListNode node) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = node;
        ListNode fast = sentinel, slow = sentinel;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow == sentinel ? null : slow;
    }
    
    private ListNode revertList(ListNode node) {
        ListNode previous = null, next = null;
        while(node != null) {
            next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }
        return previous;
    }
    
    
    // Transforms the list into an array. If list is too big, overflows when creating the array
    public boolean isPalindrome2(ListNode head) {
        ArrayList<Integer> list = listToString(head, new ArrayList<Integer>()); 
        return isPalindrome(list);
    }
    
    private boolean isPalindrome(ArrayList<Integer> list) {
        if(list.size() <= 1) {
            return true;
        }
        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr);
        for (int i = 0; i < arr.length / 2; i++) {
            if(!arr[i].equals(arr[arr.length - i - 1])) {
                return false;
            }
        }
        return true;
    }
    
    private ArrayList<Integer> listToString(ListNode node, ArrayList<Integer> list) {
        if(node == null) {
            return list;
        } else {
            list.add(node.val);
            return listToString(node.next, list);
        }
    }
}