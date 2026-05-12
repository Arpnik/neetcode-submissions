class Solution {

    private static void getSubsets(int[] nums, int index, List<List<Integer>> result, List<Integer> intermediate){
        if(index >= nums.length){
            List<Integer> temp = new ArrayList<Integer>();
            for(Integer num: intermediate){
                temp.add(num);
            }
            result.add(temp);
            return;
        }

        if(index+1 < nums.length && nums[index] == nums[index+1]){
            int i, end=index+1;
            while(end < nums.length && nums[end-1] == nums[end])
                end++;
            
            for(i=0;i<=(end-index);i++){
                getSubsets(nums, end, result, intermediate);
                intermediate.add(nums[index]);
            }

            for(i=0;i<=(end-index);i++){
                intermediate.remove(intermediate.size()-1);
            }

            return;
        }

        getSubsets(nums, index+1, result, intermediate);
        intermediate.add(nums[index]);
        getSubsets(nums, index+1, result, intermediate);
        intermediate.remove(intermediate.size()-1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length <= 0)
            return new ArrayList<List<Integer>>();
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> intermediate = new ArrayList<Integer>();
        Arrays.sort(nums);
        getSubsets(nums, 0, result, intermediate);
        return result;   
    }
}
