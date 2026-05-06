class Solution {
    public int[] plusOne(int[] digits) {
        int i, increment=1;
        for(i=digits.length-1;i>=0 && increment==1;i--){
            digits[i]+=increment;
            increment = 0;
            if(digits[i]>=10){
                digits[i] = 0;
                increment = 1;
            }
        }

        if(increment==1){
            int result[] = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
        
        return digits;
    }
}
