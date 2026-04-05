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

    private static ListNode reverseHelper(ListNode head, ListNode prev){
        if(Objects.isNull(head))
            return prev;
        
        ListNode nextNode = head.next;
        head.next = prev;
        return reverseHelper(nextNode, head);
    }

    public ListNode reverseList(ListNode head) {
        return reverseHelper(head, null);
    }
}
