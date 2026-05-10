class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1, currentSum=0;
        while(left<right){
            currentSum = numbers[left] + numbers[right];
            if(currentSum==target){
                int[] result = new int[2];
                result[0] = left+1;
                result[1] = right+1;
                return result;
            } else if(currentSum > target){
                right--;
            } else {
                left++;
            }
        }

        return new int[2];

    }
}
