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
    public boolean hasCycle(ListNode head) {
        if(Objects.isNull(head)||Objects.isNull(head.next))
            return false;
        
        ListNode fast, slow;
        fast=slow=head;
        while(Objects.nonNull(fast)){
            if(Objects.nonNull(fast.next)){
                fast = fast.next.next;
            } else {
                fast = fast.next;
            } 
            slow = slow.next;
            if(fast==slow)
                return true;
        }

        return false;

    }
}
