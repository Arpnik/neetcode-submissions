class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length <=0)
            return -1;
        
        int[] result = new int[nums.length];
        result[0]=1;
        int current, previous;
        for(current=1;current<nums.length;current++){
            result[current]=1;
            for(previous = current-1;previous>=0;previous--){
                if(nums[previous]<nums[current]){
                    if(result[current]<result[previous]+1)
                        result[current] = result[previous]+1;
                }
            }
        }
        int answer = result[0];
        for(int i=1;i<nums.length;i++){
           if(answer < result[i])
                answer = result[i];
        }
        return answer;
    }
}
