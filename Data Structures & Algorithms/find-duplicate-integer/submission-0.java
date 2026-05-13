class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        int temp, current;
        while(i < nums.length){
            current = nums[i];
            if(current != nums[current]){
                temp = nums[current];
                nums[current] = current;
                nums[i] = temp;
                continue;
            } else if(current != i){
                return current;
            }
            i++;
        }

        return nums[0];
    }
}
