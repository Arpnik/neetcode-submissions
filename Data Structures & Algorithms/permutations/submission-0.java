class Solution {
    private static void getPermutations(int[] nums, boolean[] isIncluded, List<Integer> intermediate, List<List<Integer>> result){
        if(intermediate.size() >= nums.length){
            List<Integer> temp = new ArrayList<Integer>();
            for(Integer num: intermediate)
                temp.add(num);
            result.add(temp);
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!isIncluded[i]){
                intermediate.add(nums[i]);
                isIncluded[i] = true;
                getPermutations(nums, isIncluded, intermediate, result);
                isIncluded[i] = false;
                intermediate.remove(Integer.valueOf(nums[i]));
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if(nums==null || nums.length<=0)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> intermediate = new ArrayList<Integer>();
        boolean[] isIncluded = new boolean[nums.length];
        getPermutations(nums, isIncluded, intermediate, result);
        return result;
    }
}
