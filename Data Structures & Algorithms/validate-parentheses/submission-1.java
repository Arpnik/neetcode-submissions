class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty())
            return true;

        Set<Character> openingBrackets = new HashSet<>() {{add('(');add( '{'); add('[');}};
        Set<Character> closingBrackets = new HashSet<>() {{add(')');add(']'); add('}');}};
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            Character ch = s.charAt(i);
            if(openingBrackets.contains(ch)){
                stack.push(ch);
            } else if(closingBrackets.contains(ch)) {
                if(stack.isEmpty())
                    return false;
                Character matchingBracket = stack.pop();
                Character idealBracket=' ';
                switch(matchingBracket){
                    case '(': idealBracket = ')';break;
                    case '[': idealBracket = ']';break;
                    case '{': idealBracket = '}';break;
                }
                if(idealBracket != ch)
                    return false;
            }
        }

        if(stack.isEmpty())
            return true;
        
        return false;
    }
}
