class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] amt = new int[amount+1];
        amt[0]=0;
        int i, j;
        for(i=1;i<=amount;i++){
            amt[i] = Integer.MAX_VALUE;
            for(j=0;j<coins.length;j++){
                if(i-coins[j] >=0){
                    if(amt[i-coins[j]]!= Integer.MAX_VALUE && amt[i]> amt[i-coins[j]]+1){
                        amt[i] = amt[i-coins[j]]+1;
                    }
                }
            }
        }
        return (amt[amount]!=Integer.MAX_VALUE)?amt[amount]:-1;
    }
}
