class Solution {

    private static int check(char a, char b){
        return (a-'0')*10+(b-'0');
    }

    private static int countDecodings(String s){
        if(Objects.isNull(s)||s.length()<=0)
            return 1;
        
        char first = s.charAt(0);
        if(first-'0'==0)
            return 0;
        
        int cnt=0;
        cnt += countDecodings(s.substring(1, s.length()));

        if(s.length()>=2){
            char second = s.charAt(1);
            int num = check(first, second);
            if(num>=1 && num <= 26){
                cnt += countDecodings(s.substring(2, s.length()));
            }
        }

        return cnt;
        
    }

    public int numDecodings(String s) {
        if(Objects.isNull(s) || s.length() <=0)
            return 0;
        
        return countDecodings(s);
    }
}
