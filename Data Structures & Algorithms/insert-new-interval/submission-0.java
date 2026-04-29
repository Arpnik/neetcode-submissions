class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int diff =1;
        int i;
        int start = newInterval[0];
        int end = newInterval[1];
        for(i=0;i<intervals.length;i++){
            if((intervals[i][0]<=start && start<=intervals[i][1])||
            (start<=intervals[i][0] && intervals[i][0]<=end))
                diff--;
        }
        int count = intervals.length + diff;
        int[][] result = new int[count][2];
        int index=0;
        int maxEnd=-1, minStart=-1;
        boolean checkOverlap = false;
        boolean isAdded = false;
        for(i=0;i<intervals.length;i++){
            if((intervals[i][0]<=start && start<=intervals[i][1]) || (start<=intervals[i][0] && intervals[i][0]<=end)){
                if(!checkOverlap){
                    minStart = (start<intervals[i][0])?start:intervals[i][0];
                    maxEnd = (end>intervals[i][1])?end:intervals[i][1];
                } else {
                    minStart = (minStart<intervals[i][0])?minStart:intervals[i][0];
                    maxEnd = (maxEnd>intervals[i][1])?maxEnd:intervals[i][1];
                }
                System.out.println(i);
                checkOverlap = true;
                continue;
            } else if(checkOverlap){
                System.out.println(index+" "+minStart+" "+maxEnd);
                result[index][0] = minStart;
                result[index][1] = maxEnd;
                checkOverlap = false;
                isAdded = true;
                index+=1;
            }
            if(!isAdded && end<=intervals[i][0]){
                result[index][0] = start;
                result[index][1] = end;
                isAdded = true;
                index+=1;
            }
            result[index][0] = intervals[i][0];
            result[index][1] = intervals[i][1];
            index+=1;
        }
        if(checkOverlap){
            result[index][0] = minStart;
            result[index][1] = maxEnd;
        } else if(!isAdded){
            result[index][0] = start;
            result[index][1] = end;
        }
        return result;

    }
}
