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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head.next == null)
        return null;
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dummy;
        int index = 0;
        while (first != null)
        {
            if (index >= n)
            second = second.next;
            first = first.next;
            index++;
        }

        second.next = second.next.next;
        return dummy.next;
    }
}
