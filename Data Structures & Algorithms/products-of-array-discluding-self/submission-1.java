class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int curLeftProduct=1, curRightProduct=1;
        
        for(int i=0;i<nums.length;i++){
            leftProduct[i]=curLeftProduct;
            curLeftProduct*=nums[i];
        }
        
        for(int i=nums.length-1;i>=0;i--){
            rightProduct[i]=curRightProduct;
            curRightProduct*=nums[i];
        } 

        for(int i=0;i<nums.length;i++){
            result[i] = leftProduct[i]*rightProduct[i];
        }
        return result;
    }
}  
