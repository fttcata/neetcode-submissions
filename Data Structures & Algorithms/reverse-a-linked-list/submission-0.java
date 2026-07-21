/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        // Edge case List empty, or length of list is 1
        if (head == null)
        return null;
        if (head.next == null)
        return head;


        ListNode curr = head.next;
        ListNode prev = head;
        prev.next = null;
        while (curr != null)
        {
            // Dummy node that saves the next node
            ListNode next = curr.next;
            // Point to previous
            curr.next = prev;
            // Prev = curr;
            prev = curr;
            // Current gets the saved node
            curr = next;
        }

        return prev;
    }
}
