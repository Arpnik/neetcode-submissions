class Solution {
    public int rob(int[] nums) {
        if(Objects.isNull(nums))
            return 0;
        if(nums.length==1)
            return nums[0];
        int[] result = new int[nums.length];
        int with=0; int without =0;
        for(int i=0;i<nums.length;i++){
            without = ((i-1)>=0)?result[i-1]:0;
            with = nums[i]+ (((i-2)>=0)?result[i-2]:0);
            result[i] = (with>without)? with: without;
        }

        return result[nums.length-1]>result[nums.length-2]?result[nums.length-1]:result[nums.length-2];
    }
}
