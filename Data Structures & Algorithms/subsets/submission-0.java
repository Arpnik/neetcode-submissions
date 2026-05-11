class Solution {
    private static void createSubsetsHelper(int[] nums, int index, List<Integer> intermediate, List<List<Integer>> result){
        if(index >= nums.length){
            List<Integer> temp = new ArrayList<Integer>();
            for(Integer num: intermediate)
                temp.add(num);
            result.add(temp);
            return;
        }

        createSubsetsHelper(nums,index+1, intermediate, result);
        intermediate.add(nums[index]);
        createSubsetsHelper(nums, index+1, intermediate, result);
        intermediate.remove(Integer.valueOf(nums[index]));
    }

    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<Integer>();
        createSubsetsHelper(nums, 0, arr, result);
        return result;
    }
}
