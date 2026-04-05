class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int left = target - nums[i];
            if(map.getOrDefault(left,-1)!=-1){
                result[0]=map.getOrDefault(left,-1);
                result[1]=i;
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
