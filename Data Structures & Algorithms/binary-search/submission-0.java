class Solution {
    private static int search(int[] nums, int left, int right, int target){
        if(right<left)
            return -1;
        
        int mid = (left + right)/2;
        if(nums[mid]==target)
            return mid;
        
        if(nums[mid]<target)
            return search(nums, mid+1, right, target);
        
        return search(nums, left, mid-1, target);
    }
    public int search(int[] nums, int target) {
        if(nums==null || nums.length<=0)
            return -1;
        
        return search(nums, 0, nums.length-1, target);
    }
}
