class Solution {
    public int missingNumber(int[] nums) {
        boolean lastPresent = false;

        int i=0, num, temp;
        while(i<nums.length){
            num = nums[i];
            if(i!=num){
                if(num==nums.length){
                    lastPresent = true;
                    i++;
                    continue;
                }
                temp = nums[num];
                nums[num] = nums[i];
                nums[i]=temp;
            } else {
                i++;
            }
        }

        if(!lastPresent)
            return nums.length;
        
        for(i=0;i<nums.length;i++){
            if(i!=nums[i])
                return i;
        }

        return -1;

    }
}
