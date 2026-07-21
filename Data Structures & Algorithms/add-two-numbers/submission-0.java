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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0, null);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null)
        {   int digit = 0;
            if (l1 == null)
            {
            digit = l2.val + carry;
            l2=l2.next;}
            else if (l2 == null)
            {
            digit = l1.val + carry;
            l1=l1.next;
            }
            else
            {
                digit = l1.val+l2.val + carry;
                l1=l1.next;
                l2=l2.next;
            }
            if (digit > 9)
            {
                carry = 1;
                digit %= 10;
            }
            else carry = 0;
            curr.next = new ListNode(digit,null);
            curr = curr.next;
        }
        if (carry == 1)
        curr.next = new ListNode(1, null);
        return dummy.next;
    }
}
