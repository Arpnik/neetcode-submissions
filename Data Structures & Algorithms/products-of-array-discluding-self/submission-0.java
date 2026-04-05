class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
                product*=nums[i];
            else
                zeroCount+=1;
        }
        // System.out.println(product+" "+zeroCount);
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(zeroCount>0){
                if(nums[i]==0 && zeroCount<=1)
                    result[i] = product;
                else
                    result[i] = 0;
            } else {
                result[i] = product/nums[i];
            }
        }
        return result;
    }
}  
