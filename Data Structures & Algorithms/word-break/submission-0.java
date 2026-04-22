class Solution {
    private static boolean checkSame(String s, String r){
        int i,j;
        i=0;j=0;
        while(i<s.length() && j<r.length()){
            if(s.charAt(i)!=r.charAt(j))
                return false;
            i++;
            j++;
        }
        if(j<r.length())
            return false;
        
        return true;
    }

    private boolean wordBreakWithMemory(String s, List<String> wordDict, Boolean[] partialResult){
        if(s==null || s.length()<=0)
            return true;
        if(partialResult[s.length()]!=null)
            return partialResult[s.length()];

        boolean result = false;
        for(String reference: wordDict){
            if(checkSame(s, reference)){
                // System.out.println(s+" "+reference+"="+checkSame(s, reference));
                result = wordBreakWithMemory(s.substring(reference.length()), wordDict, partialResult);
                // System.out.println(s+" "+reference+" "+result);
            }
            if(result){
                partialResult[s.length()] = true;
                return true;
            }
        }
        partialResult[s.length()]=false;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.length()<=0)
            return false;
        
        Boolean[] result = new Boolean[s.length()+1];
        return wordBreakWithMemory(s, wordDict, result);
    }
}
