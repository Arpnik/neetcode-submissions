class Solution {
    public boolean canJump(int[] nums) {
        if(Objects.isNull(nums))
            return false;

        int i, maxRechableIndex=0, jump;
        for(i=0;i<nums.length;i++){
            jump = nums[i];
            System.out.println(i+" "+maxRechableIndex);
            if(maxRechableIndex < i)
                return false;
            if(i!= nums.length-1 && maxRechableIndex < i+jump)
                maxRechableIndex = i+jump;
            // if(maxRechableIndex >= i)
            //     reachable[i] = true;
        }

        return true;
    }
}
