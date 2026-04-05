class WordDictionary {
    class Node {
        private Boolean isEnd;
        private Node[] children;

        public Node(){
            isEnd = false;
            children = new Node[26];
        }
    }

    private Node head;
    public WordDictionary() {
        head = new Node();
    }

    public void addWord(String word) {
        if(Objects.isNull(word))
            return;
        
        word = word.toLowerCase();
        Node current = head;
        int i;
        for(i=0;i<word.length();i++){
            Character ch = word.charAt(i);
            int chIndex = ch - 'a';
            if(Objects.isNull(current.children[chIndex])){
                current.children[chIndex] = new Node();
            }
            current = current.children[chIndex];
        }
        current.isEnd = true;
    }

    private boolean searchHelper(String word, int index, Node current){
        System.out.println(word+" "+index+" "+Objects.isNull(current));
        if(Objects.isNull(current))
            return false;
        
        Character ch = word.charAt(index);
        if(ch=='.') {
            if(index >= word.length()-1){
                for(int i=0;i<26;i++){
                    if(Objects.nonNull(current.children[i]) && current.children[i].isEnd)
                        return true;
                }
                return false;
            }

            boolean result = false;
            for(int i=0;i<26;i++){
                result = searchHelper(word, index+1, current.children[i]);
                if(result)
                    return result;
            }
            return result;
        }

        Node currentChar = current.children[ch-'a'];
        System.out.println(word+" "+current.children[ch-'a']);
        if(Objects.isNull(currentChar))
            return false;
        if(index >= word.length()-1){
            return currentChar.isEnd;
        }
        return searchHelper(word, index+1, currentChar);
    }

    public boolean search(String word) {
        word = word.toLowerCase();
        return searchHelper(word, 0, head); 
    }
}
