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
        if(head==null)
            return prev;
        
        ListNode nextNode = head.next;
        head.next = prev;
        return reverse(nextNode, head);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = reverse(head, null);
        ListNode prev = head, current = head;
        int cnt=1;
        while(cnt<n){
            prev = current;
            current = current.next;
            cnt++;
        }

        // System.out.println(prev.val);

        if(n==1)
            return reverse(head.next, null);
        if(Objects.nonNull(prev)||Objects.nonNull(prev.next))
            prev.next = prev.next.next;

        return reverse(head, null);
    }
}
