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
        ListNode head = null;
        int cnt = 0;
        int length = lists.length;
        ListNode temp, current=null;
        int selectedIndex=0;
        while(cnt<length){
            temp=null;
            for(int i=0;i<lists.length;i++){
                if(Objects.nonNull(lists[i])){
                    if(Objects.nonNull(temp)){
                        if(temp.val > lists[i].val){
                            temp = lists[i];
                            selectedIndex = i;
                        }
                    } else {
                        temp = lists[i];
                        selectedIndex = i;
                    }
                }
            }

            lists[selectedIndex] = lists[selectedIndex].next;
            if(Objects.isNull(lists[selectedIndex]))
                cnt++;
            if(Objects.isNull(head)){
                head = temp;
                current = temp;
            } else {
                current.next=temp;
                current = temp;
            }
            current.next = null;
        }

        return head;
    }
}
