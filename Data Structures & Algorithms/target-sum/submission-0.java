class Solution {
    private static int helper(int[] nums, int target, int current, int index){
        if(index >= nums.length){
            if(current==target)
                return 1;
            return 0;
        }

        int count = 0;
        count += helper(nums, target, current+nums[index], index+1);
        count += helper(nums, target, current-nums[index], index+1);
        return count;
    }

    public int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length<=0)
            return 0;
        
        return helper(nums, target, 0, 0);
    }
}
