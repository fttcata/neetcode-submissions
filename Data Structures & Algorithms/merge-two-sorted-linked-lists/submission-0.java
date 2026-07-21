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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
        return null;

        if (list1 == null)
        return list2;
        if (list2 == null)
        return list1;

        ListNode head;
        if (list1.val >= list2.val)
        {
        head = new ListNode(list2.val,null);
        list2 = list2.next;
        }
        else 
        {head = new ListNode(list1.val,null);
        list1=list1.next;}

        ListNode curr = head;
        
        while (list1 != null || list2 != null)
        {
            ListNode temp;
            if (list1 == null)
            {
                temp = new ListNode(list2.val,null);
                curr.next = temp;
                curr = curr.next;
                list2=list2.next;
            }
            else if (list2==null)
            {
                temp = new ListNode(list1.val,null);
                curr.next = temp;
                curr = curr.next;
                list1=list1.next; 
            } else if (list1.val >= list2.val)
            {
                temp = new ListNode(list2.val,null);
                curr.next = temp;
                curr = curr.next;
                list2=list2.next;
            }
            else 
            {   temp = new ListNode(list1.val,null);
                curr.next = temp;
                curr = curr.next;
                list1=list1.next; }
        }
        return head;


    }
}