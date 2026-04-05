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
        if(Objects.isNull(list1))
            return list2;
        if(Objects.isNull(list2))
            return list1;
        
        if(list1.val<list2.val){
            // ListNode nextNode = list1.next;
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
           list2.next = mergeTwoLists(list1, list2.next);
           return list2;
        }
        
    }
}