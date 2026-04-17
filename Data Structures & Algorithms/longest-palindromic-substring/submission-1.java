class Solution {
    public String longestPalindrome(String input) {
        if(input == null || input.length() <= 1)
            return input;
        int maxStart=0, maxEnd=0, initial, currentStart, currentEnd, maxLength=0, currentLength;
        for(initial=0;initial<input.length();initial++){
            //odd length palindrome
            currentStart = initial - 1;
            currentEnd = initial + 1;
            currentLength = 1;
            while(currentStart >= 0 && currentEnd < input.length() && 
            input.charAt(currentStart)==input.charAt(currentEnd)) {
                currentLength+=2;
                currentStart--;
                currentEnd++;
            }
            if(maxLength<currentLength){
                maxLength = currentLength;
                maxStart = currentStart+1;
                maxEnd = currentEnd-1;
            }
            //even length palindrome
            currentStart = initial-1;
            currentEnd = initial;
            currentLength = 0;
            while(currentStart >= 0 && currentEnd < input.length() && 
            input.charAt(currentStart)==input.charAt(currentEnd)) {
                currentLength += 2;
                currentStart--;
                currentEnd++;
            }
            if(maxLength<currentLength){
                maxLength = currentLength;
                maxStart = currentStart+1;
                maxEnd = currentEnd-1;
            }
        }

        return input.substring(maxStart, maxEnd+1);

    }
}
