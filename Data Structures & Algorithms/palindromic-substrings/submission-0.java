class Solution {
    public int countSubstrings(String s) {
        if(s==null || s.length() <=0)
            return 0;
        
        int middle, result=0, start, end;
        for(middle=0;middle<s.length();middle++){
            //odd length
            start=end=middle;
            while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
                result += 1;
                start-=1;
                end+=1;
            }

            //even length
            start=middle-1;
            end=middle;
            while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
                result += 1;
                start-=1;
                end+=1;
            }
        }

        return result;
    }
}
