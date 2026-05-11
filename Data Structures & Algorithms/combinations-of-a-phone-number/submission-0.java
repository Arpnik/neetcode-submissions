class Solution {
    private static String getStringFromNum(char ch){
        switch(ch){
            case '2':return "abc";
            case '3':return "def";
            case '4':return "ghi";
            case '5':return "jkl";
            case '6':return "mno";
            case '7':return "pqrs";
            case '8':return "tuv";
            case '9':return "wxyz";
            default: return "";
        }
    }

    private static void getCombinationsHelper(String digits, StringBuilder intermediate, List<String> result){
        if(digits==null || digits.length()<=0){
            result.add(intermediate.toString());
            return;
        }
        char ch = digits.charAt(0);
        String letters = getStringFromNum(ch);
        for(int i=0;i<letters.length();i++){
            intermediate.append(letters.charAt(i));
            getCombinationsHelper(digits.substring(1), intermediate, result);
            intermediate.deleteCharAt(intermediate.length()-1);
        }
        
    }

    public List<String> letterCombinations(String digits) {
            if(digits==null || digits.length()<=0)
                return new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        StringBuilder intermediate = new StringBuilder();
        getCombinationsHelper(digits, intermediate, result);
        return result;
    }
}
