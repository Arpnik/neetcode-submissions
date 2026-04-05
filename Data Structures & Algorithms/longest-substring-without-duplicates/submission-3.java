class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(Objects.isNull(s) || s.length()==0)
            return 0;
        Map<Character,Integer> arr = new HashMap<>();

        Character index;
        int max=1, startIndex=-1, currentLength=0;
        for(int i=0;i<s.length();i++) {
            index = s.charAt(i);
            if(arr.getOrDefault(index,-1)>=startIndex){
                // d v d f
                // 0 1 2 3

                // d  v  f
                // 0  1  -1
                startIndex=arr.getOrDefault(index,-1)+1;
                // System.out.println(i+" "+currentLength+" "+startIndex);
                currentLength = i-startIndex;
            }

            // System.out.println(i+" "+currentLength);
            arr.put(index,i);
            currentLength++;
            // System.out.println(i+" "+currentLength);

            
            if(max<currentLength)
                max=currentLength;
        }


        return max;
    }
}
