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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists[0] == null)
        return null;
        Queue<Integer> que = new PriorityQueue<>();

        for (int i = 0 ; i < lists.length; i++)
        {
            ListNode curr = lists[i];
            while (curr != null)
            {
                que.add(curr.val);
                curr = curr.next;
            }
        }

        ListNode head = new ListNode(que.poll(), null);
        ListNode curr = head;

        while (!que.isEmpty())
        {
            curr.next = new ListNode(que.poll(),null);
            curr = curr.next;
        }

        return head;

    }
}
