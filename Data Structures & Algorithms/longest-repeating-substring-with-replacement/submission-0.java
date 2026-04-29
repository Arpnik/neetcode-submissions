class Solution {
    private int checkUnique(int[] alphabets){
        int cnt=0;
        int max=0;
        for(int i=0;i<26;i++){
            cnt+=alphabets[i];
            max = (max<alphabets[i])?alphabets[i]:max;
        }
        return cnt-max;
    }
    public int characterReplacement(String s, int k) {
        if(s==null)
            return 0;
        if(s.length()<=1)
            return s.length();
        int[] alphabets = new int[26];
        int start=0;
        int end=0;
        int i, count, result=1;
        
        char current;
        while(start<=end && start<s.length() && end<s.length()){
            if(checkUnique(alphabets)>k){
                alphabets[s.charAt(start)-'A']-=1;
                start++;
                continue;
            }
            current=s.charAt(end);
            alphabets[current-'A']+=1;
            count = end-start;
            result = (result<count)?count:result;
            // System.out.println(start+" "+end+" "+checkUnique(alphabets));
            end++;
        }

        if(start<end && end==s.length() && checkUnique(alphabets)<=k){
            count = end-start;
            result = (result<count)?count:result;
        }

        return result;

    }
}
