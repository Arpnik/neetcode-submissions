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

    private ListNode reverse(ListNode head, ListNode prev){
        if(Objects.isNull(head))
            return prev;
        
        ListNode nextNode = head.next;
        head.next = prev;
        return reverse(nextNode, head);
    }

    public void reorderList(ListNode head) {
        if(Objects.isNull(head) || Objects.isNull(head.next))
            return;
        
        ListNode fast=head, slow=head;
        while(fast != null && fast.next!=null){
            if(Objects.nonNull(fast.next) && Objects.nonNull(fast.next))
                fast = fast.next.next;
            else 
                break;
            slow = slow.next;
        }

        ListNode secondHalf = reverse(slow.next, null);
        slow.next = null;
        ListNode secondHalfNext, nextNode, current=head;
        while(Objects.nonNull((secondHalf))){
            secondHalfNext = secondHalf.next;
            nextNode = current.next;
            current.next = secondHalf;
            if(Objects.nonNull(secondHalf)){
                secondHalf.next = nextNode;
                secondHalf = secondHalfNext;
            }
            current = nextNode;
        }

    }
}
