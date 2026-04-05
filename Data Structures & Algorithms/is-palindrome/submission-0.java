class Solution {

    private Boolean isAlphaNumeric(Character c){
        return (c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9');
    }

    public boolean isPalindrome(String s) {
        if(Objects.isNull(s))
            return true;
        int start = 0;
        int end = s.length()-1;
        s = s.toLowerCase();
        while(start<end){
            if(!isAlphaNumeric(s.charAt(start))){
                start++;
                continue;
            }
            if(!isAlphaNumeric(s.charAt(end))){
                end--;
                continue;
            }
            System.out.println(s.charAt(start)+" "+s.charAt(end));
            if(s.charAt(start)!= s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
