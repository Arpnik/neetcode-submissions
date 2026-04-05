/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node clone(Node node, Map<Node, Node> map){
        if(Objects.isNull(node))
            return node;
        
        if(Objects.nonNull(map.getOrDefault(node, null)))
            return map.get(node);

        Node current = new Node(node.val);
        map.put(node, current);

        for(int i=0;i<node.neighbors.size();i++){
            Node next = node.neighbors.get(i);
            if(Objects.nonNull(map.getOrDefault(next, null)))
                current.neighbors.add(map.get(next));
            else {
                current.neighbors.add(clone(next, map));
            }
        }

        return current;
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
            if(Objects.isNull(node))
                return node;
        clone(node, map);
        return map.get(node);
    }
}