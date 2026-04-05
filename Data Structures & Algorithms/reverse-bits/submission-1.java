class Solution {
    public int reverseBits(int n) {
        //0001101
        //1110010
        //1011000
        int reversed=0, cnt=32, cur=0;
        boolean changeSign=false;
        if(n<0){
            n=~n;
            changeSign=true;
        }

        while(n>0){
            if(n%2==1){
                reversed+=1;
            }
            cur++;
            reversed = reversed<<1;
            // System.out.print(reversed);
            n=n>>1;
            // cnt--;
        }
        reversed = reversed << (cnt-cur-1);
        if(changeSign){
            reversed = ~reversed;
        }
        return reversed;
    }
}
