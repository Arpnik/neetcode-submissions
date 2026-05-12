class Solution {

    private static void addToResult(List<List<Integer>> result, List<Integer> intermediate){
        List<Integer> temp = new ArrayList<Integer>();
        for(Integer num: intermediate)
            temp.add(num);
            
        result.add(temp);
    }
    
    private static void getCombinations(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> intermediate, int currentSum){

        if(currentSum > target || index >= candidates.length)
            return;
        
        if(index+1 < candidates.length && candidates[index+1] == candidates[index]){
            int end = index + 1;
            while(end<candidates.length && candidates[end] == candidates[end-1])
                end++;
            
            // 0 1 2 3 4 5
            // 2 3 3 3
            getCombinations(candidates, target, end, result, intermediate, currentSum);
            for(int count = 1; count <= (end-index); count++){
                intermediate.add(candidates[index]);
                currentSum += candidates[index];
                if(currentSum == target)
                    addToResult(result, intermediate);
                else
                    getCombinations(candidates, target, end, result, intermediate, currentSum);
            }

            for(int count = 1; count <= (end-index); count++){
                intermediate.remove(intermediate.size()-1);
            }

            return;   
        }

        getCombinations(candidates, target, index+1, result, intermediate, currentSum);
        intermediate.add(candidates[index]);
        currentSum += candidates[index];
        if(currentSum == target){
            addToResult(result, intermediate);
        } else
            getCombinations(candidates, target, index+1, result, intermediate, currentSum);

        intermediate.remove(intermediate.size()-1);
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length <= 0)
            return new ArrayList<List<Integer>>();
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> intermediate = new ArrayList<Integer>();
        Arrays.sort(candidates);
        getCombinations(candidates, target, 0, result, intermediate, 0);
        return result;
    }
}
