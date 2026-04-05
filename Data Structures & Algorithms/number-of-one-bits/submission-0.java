class Solution {
    public int hammingWeight(int n) {
        if(n==0)
            return 0;
        else if(n%2==0)
            return hammingWeight(n>>1);
        else
            return hammingWeight(n>>1)+1;

    }
}
