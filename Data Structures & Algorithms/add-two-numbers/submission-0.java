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
    private ListNode addHelper(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null){
            if(carry > 0)
                return new ListNode(carry);
            return l1;
        }

        if(0 == carry && (null == l1 || null == l2))
            return (null == l1)? l2: l1;
        
        
        
        if(l1 != null && l2 != null){
            l1.val += l2.val;
            l1.val += carry;
        } else if(l1 != null) {
            l1.val += carry;
        } else if (l2 != null) {
            l1 = l2;
            l2 = null;
            l1.val += carry;
        }

        carry = l1.val/10;
        l1.val = l1.val%10;
        l1.next = addHelper(l1.next, l2==null?l2:l2.next, carry);
        return l1;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addHelper(l1, l2, 0);
    }
}
