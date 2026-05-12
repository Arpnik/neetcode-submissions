/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return head;
        Map<Node, Node> mapToNewNode = new HashMap<Node, Node>();
        Node newHead = null, previous, current = head;
        while(current != null){
            previous = new Node(current.val);
            if(newHead == null)
                newHead = previous;
            mapToNewNode.put(current, previous);
            current = current.next;
        }

        current = head;
        previous = newHead;
        while(current!=null){
            previous.next = mapToNewNode.getOrDefault(current.next, null);
            previous.random = mapToNewNode.getOrDefault(current.random, null);
            current = current.next;
            previous = previous.next;
        }

        return newHead;
    }
}
