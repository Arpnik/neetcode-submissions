class Solution {
    private void findSum(int[] nums, List<Integer> currentResult, List<List<Integer>> result, int target, int startIndex){
        if(target==0 || startIndex >= nums.length)
            return;
        // System.out.println(startIndex+ " "+nums.length);
        if(target==nums[startIndex]){
            List<Integer> cloned = new ArrayList<>(currentResult);
            cloned.add(nums[startIndex]);
            result.add(cloned);
        } else if(target - nums[startIndex] > 0){
            currentResult.add(nums[startIndex]);
            findSum(nums, currentResult, result, target-nums[startIndex], startIndex);
            currentResult.remove(Integer.valueOf(nums[startIndex]));
        }
            
        if(target > 0)
            findSum(nums, currentResult, result, target, startIndex+1);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if(Objects.isNull(nums))
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        findSum(nums, new ArrayList<>(), result, target, 0);
        return result;
    }
}
