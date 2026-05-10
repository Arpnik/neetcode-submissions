class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length<=1)
            return 0;
        
        int[] result = new int[cost.length+1];
        result[0] = result[1] = 0;
        int index, oneJump, twoJump;
        for(index = 2; index < cost.length + 1; index++){
            oneJump = result[index-1] + cost[index-1];
            twoJump = result[index-2] + cost[index-2];
            result[index] = (oneJump < twoJump)?oneJump: twoJump;
        }

        return result[cost.length];
    }
}
