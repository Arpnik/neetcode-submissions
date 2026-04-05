class Solution {
    private int count(int n){
        if(n==0)
            return 0;
        return ((n%2!=0)?1:0)+count(n>>1);
    }
    public int[] countBits(int n) {
        if(n<0)
            return new int[0];
        int[] arr = new int[n+1];
        int i;
        for(i=0;i<=n;i++){
            arr[i] = count(i);
        }
        return arr;
    }
}
