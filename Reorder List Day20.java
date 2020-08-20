/*

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

*/


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
    public void reorderList(ListNode head) {
        
        if(head==null || head.next==null) {
            return ;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = null;
        ListNode temp= null;
        ListNode curr = slow;
        
        while(curr!=null) {
            
            // 4->5->6->null
            temp = curr.next; // 5->6>null      // 6->null;    // null
            curr.next = prev; // 4-> null       // 5->4->null  // 6->5-4->null
            prev = curr; // 4->5->6->null       // 5->6->null  // 6
            
            curr = temp ; // 5->6>null         // 6->null   // null
        
            
        }
        
        ListNode first = head;
        ListNode second = prev;
        
        while(second.next !=null) {
            temp=first.next;
            first.next = second;
            
            first = temp;
            
            temp = second.next;
            second.next =  first;
            second = temp;
        }
        
    }
}
