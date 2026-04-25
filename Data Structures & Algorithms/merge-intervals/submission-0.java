class Solution {
    public int[][] merge(int[][] intervals) {
        // System.out.println(intervals.length);
        if(intervals.length<=1)
            return intervals;

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]!=b[0])
                    return a[0]-b[0];
                return a[1] - b[1];
            }
        });

        int i;
        // for(i=0;i<intervals.length;i++){
        //     System.out.println(intervals[i][0]+" "+intervals[i][1]);
        // }
        // System.out.println("Here");z

        //count
        int maxStart=intervals[0][0], maxEnd=intervals[0][1];
        int count=1;
        for(i=1;i<intervals.length;i++){
            if(maxStart<=intervals[i][0] && intervals[i][0]<=maxEnd){
                maxEnd = (maxEnd<intervals[i][1])?intervals[i][1]:maxEnd;
                continue;
            } 
            if(intervals[i][0] > maxEnd){
                // System.out.println(i+" "+intervals[i][0]+" "+maxEnd);
                count++;
                maxEnd = intervals[i][1];
                maxStart = intervals[i][0];
            }
        }

        // System.out.println(count);

        int[][] result = new int[count][2];
        int index=0;
        maxStart = intervals[0][0];
        maxEnd = intervals[0][1];
        for(i=1;i<intervals.length;i++){
            // System.out.println(maxEnd+" "+intervals[i][1]);
            if(maxStart<=intervals[i][0] && intervals[i][0]<=maxEnd){
                // System.out.println(maxEnd+" "+intervals[i][1]);
                maxEnd = (maxEnd<intervals[i][1])?intervals[i][1]:maxEnd;
                continue;
            }
            result[index][0] = maxStart;
            result[index][1] = maxEnd;
            index++;
            maxStart = intervals[i][0];
            maxEnd = intervals[i][1];
        }

        if(index<=count){
            result[index][0] = maxStart;
            result[index][1] = maxEnd;
        }

        return result;
    }
}
