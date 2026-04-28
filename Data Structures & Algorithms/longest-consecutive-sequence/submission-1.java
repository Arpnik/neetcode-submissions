class Solution {
    private static int findRoot(int[] parents, int current){
        while(parents[current]!=current){
            parents[current] = parents[parents[current]];
            current = parents[current];
        }
        return current;
    }

    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length <=0)
            return 0;
        
        int i;
        Map<Integer, Integer> indexes = new HashMap<Integer, Integer>();
        boolean[] duplicate = new boolean[nums.length];
        int[] parent = new int[nums.length];
        int[] size = new int[nums.length];
        for(i=0;i<nums.length;i++) {
            parent[i] = i;
            size[i] = 1;
            if(indexes.getOrDefault(nums[i], -1) != -1){
                duplicate[i] = true;
            }
            indexes.put(nums[i], i);
        }
        int previous, rootPrevious, rootCurrent, current, max = 1;
        for(i=0;i<nums.length;i++){
            current = nums[i];
            previous = indexes.getOrDefault(current-1, -1);
            if(previous==-1){
                continue;
            }
            System.out.println(nums[i]+" "+previous);
            rootPrevious = findRoot(parent, previous);
            rootCurrent = findRoot(parent, i);
            if(size[rootCurrent] > size[rootPrevious]){
                parent[rootPrevious] = rootCurrent;
                size[rootCurrent] += size[rootPrevious];
                if(duplicate[i])
                    size[rootCurrent]-=1;
                max = (max<size[rootCurrent])?size[rootCurrent]:max;                    
            } else {
                parent[rootCurrent] = rootPrevious;
                size[rootPrevious] += size[rootCurrent];
                if(duplicate[i])
                    size[rootPrevious]-=1;
                max = (max<size[rootPrevious])?size[rootPrevious]:max;
            }
        }
        System.out.println();
        for(i=0;i<nums.length;i++){
            System.out.println(i+" "+nums[i]+" "+size[i]);

        }

        return max;
        
    }
}
