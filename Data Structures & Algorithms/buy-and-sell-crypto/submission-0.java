class Solution {
    public int maxProfit(int[] prices) {
        if(Objects.isNull(prices) || prices.length<=1)
            return 0;

        int[] maxRight = new int[prices.length];

        int currentMax=prices[prices.length-1];
        for(int i=prices.length-1;i>=0;i--){
            if(currentMax<prices[i])
                currentMax = prices[i];
            maxRight[i]=currentMax;
        }

        int currentProfit, maxProfit = 0, currentLeftMin = prices[0];
        for(int i=0;i<prices.length;i++){
            
            if(currentLeftMin > prices[i])
                currentLeftMin = prices[i];

            currentProfit = maxRight[i] - currentLeftMin;

            if(maxProfit < currentProfit)
                maxProfit=currentProfit;
        }

        return maxProfit;
    }
}
