


class PrefixTree {
    class Node {
        private Character ch;
        private Boolean isEnd = false;
        private Node[] children;

        public Node(Character ch){
            this.ch = ch;
            this.isEnd = false;
            this.children = new Node[26];
        }
    }
    
    private Node head;

    public PrefixTree() {
        head = new Node(null);
    }

    public void insert(String word) {
        word = word.toLowerCase();
        Node current = head;
        for(int i=0;i<word.length();i++){
            Character ch = word.charAt(i);
            int charIndex = ch - 'a';
            if(Objects.isNull(current.children[charIndex])){
                current.children[charIndex] = new Node(ch);
            }
            current = current.children[charIndex];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        word = word.toLowerCase();
        Node current = head;
        for(int i=0;i<word.length();i++){
            Character ch = word.charAt(i);
            int charIndex = ch - 'a';
            if(Objects.isNull(current.children[charIndex])){
                return false;
            }
            current = current.children[charIndex];
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        prefix = prefix.toLowerCase();
         Node current = head;
        for(int i=0;i<prefix.length();i++){
            Character ch = prefix.charAt(i);
            int charIndex = ch - 'a';
            if(Objects.isNull(current.children[charIndex])){
                return false;
            }
            current = current.children[charIndex];
        }
        return true;
    }
}
