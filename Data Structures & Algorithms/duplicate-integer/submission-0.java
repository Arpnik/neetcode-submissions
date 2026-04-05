
class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            if(map.getOrDefault(num, 0) > 0){
                return true;
            }
            map.put(num,map.getOrDefault(num, 0)+1);
        }
        return false;
    }
}