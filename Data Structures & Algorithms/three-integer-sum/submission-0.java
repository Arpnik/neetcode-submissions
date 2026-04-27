class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i,left, right;
        
        //-10.        4 6. 5 5           
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(i=0;i<nums.length;i++){
            if(i>=1 && nums[i]==nums[i-1])
                continue;
            left = i+1;
            right = nums.length-1;
            while(left<right){
                if(left-1!=i && left>=1 && nums[left]==nums[left-1]){
                    left++;
                    continue;
                }
                if(right+1<nums.length && nums[right]==nums[right+1]){
                    right--;
                    continue;
                }
                if(nums[i]+nums[left]+nums[right]==0){
                    current.add(nums[i]);
                    current.add(nums[left]);
                    current.add(nums[right]);
                    result.add(current);
                    current = new ArrayList<Integer>();
                    left++;
                    right--;
                    continue;
                }
                if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                    continue;
                }
                if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }
            }
        }
        return result;
    }
}
