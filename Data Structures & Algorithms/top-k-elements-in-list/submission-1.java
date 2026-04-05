class Solution {
    private class pair{
        int num;
        int frequency;
        public pair(int num, int freq){
            this.num=num;
            this.frequency=freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int i;
        for(i=0;i<nums.length;i++){
            counts.put(nums[i],counts.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<pair> maxHeap = new PriorityQueue<>(new Comparator<pair>(){
            public int compare(pair a, pair b){
                if(a.frequency > b.frequency)
                    return -1;
                if(a.frequency == b.frequency)
                    return 0;
                return 1;
            }
        });
        for(Map.Entry<Integer,Integer> pr : counts.entrySet()){
            pair p = new pair(pr.getKey(), pr.getValue());
            maxHeap.add(p);
        }
        int[] result = new int[k];
        for(i=0;i<k;i++){
            pair temp = maxHeap.poll();
            // if(i-1>=0){
            //     if(temp==result[i-1]){
            //         i--;
            //         continue;
            //     }
            // }
            result[i] = temp.num;
        }
        return result;
    }
}
