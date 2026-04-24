class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length<=0)
            return 0; 
        int prevSum=0;
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            if(prevSum>=0){
                prevSum += nums[i];
                if(max<prevSum)
                    max = prevSum;
            } else
                prevSum=nums[i];

            if(max<prevSum)
                max = prevSum;
        }
        return max;
    }
}
