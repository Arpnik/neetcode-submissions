class Solution {
    
    private static void generateBracketsHelper(int openBrackets, int closedBrackets, List<String> result, StringBuilder intermediate, int n){
        if(openBrackets==n && closedBrackets==n){
            result.add(intermediate.toString());
            return;
        }
        if(openBrackets<n){
            intermediate.append("(");
            generateBracketsHelper(openBrackets+1, closedBrackets, result, intermediate, n);
            intermediate.deleteCharAt(intermediate.length()-1);
        }
        if(openBrackets-closedBrackets>0){
            intermediate.append(")");
            generateBracketsHelper(openBrackets, closedBrackets+1, result, intermediate, n);
            intermediate.deleteCharAt(intermediate.length()-1);
        }

    }

    public List<String> generateParenthesis(int n) {
        int openBrackets = 0;
        int closedBrackets = 0;
        List<String> result = new ArrayList<String>();
        StringBuilder intermediate = new StringBuilder();
        generateBracketsHelper(openBrackets, closedBrackets, result, intermediate, n);
        return result;
    }
}
