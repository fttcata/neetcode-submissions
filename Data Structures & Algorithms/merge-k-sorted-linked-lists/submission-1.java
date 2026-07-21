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
        PriorityQueue<ListNode> que = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Store only the head of the nodes
        for (int i = 0 ; i < lists.length; i++)
        {
            if (lists[i] != null)
            {
                que.add(lists[i]);
            }
        }

        // Head is first node;
        ListNode head = que.poll();
        if (head.next!=null)
        que.add(head.next);
        ListNode curr = head;

        // Traverse the nodes in order, until queue is empty
        while (!que.isEmpty())
        {
            ListNode newNode = que.poll();
            curr.next = newNode;
            if (newNode.next != null)
            que.add(newNode.next);
            curr = curr.next;
        }

        return head;

    }
}
