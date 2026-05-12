class Solution {
    private static int helper(int[] nums, int target, int current, int index, int[][] arr){
        if(index >= nums.length){
            if(current==target)
                return 1;
            return 0;
        }

        int columnIndex = target-current;
        columnIndex = (columnIndex<0)?1000*1000-columnIndex:columnIndex;
        if(arr[index][columnIndex]>=0)
            return arr[index][columnIndex];
        
        int count = 0;
        count += helper(nums, target, current+nums[index], index+1, arr);
        count += helper(nums, target, current-nums[index], index+1, arr);
        arr[index][columnIndex] = count;
        return count;
    }

    public int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length<=0)
            return 0;
        
        int[][] arr = new int[nums.length][2*1000*1000];
        for(int row = 0;row<nums.length;row++){
            for(int col=0;col<2*1000*1000;col++){
                arr[row][col] = -1;
            }
        }
        return helper(nums, target, 0, 0, arr);
    }
}
