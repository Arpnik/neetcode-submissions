class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            if(n==1)
                return 1;
            if(n==2)
                return 2;
            return -1;
        }
        int[] result = new int[n+1];
        result[0]=0;
        result[1]=1;
        result[2]=2;
        for(int i=3;i<=n;i++){
            result[i]=result[i-2]+result[i-1];
        }
        return result[n];
    }
}
