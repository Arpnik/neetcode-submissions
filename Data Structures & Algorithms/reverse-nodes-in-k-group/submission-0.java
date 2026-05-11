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
    private static ListNode reverse(ListNode head, ListNode prev){
        if(head==null)
            return prev;
        ListNode nextNode = head.next;
        head.next = prev;
        return reverse(nextNode, head);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k==0)
            return head;
        int cnt = k;
        ListNode current = head, previous = null;
        while(cnt>0 && current!=null){
            previous = current;
            current = current.next;
            cnt--;
        }
        if(cnt>0)
            return head;
        
        if(previous!=null)
            previous.next = null;
        ListNode newHead = reverse(head, null);
        head.next = reverseKGroup(current, k);
        return newHead;
    }
}
