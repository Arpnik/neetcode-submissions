/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(Objects.isNull(intervals))
            return true;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                if(a.start!=b.start){
                    return a.start-b.start;
                }
                return a.end-b.end;
            }
        });

        int i;
        Interval current, previous;
        for(i=1;i<intervals.size();i++){
            current = intervals.get(i);
            previous = intervals.get(i-1);
            if(current.start<previous.end)
                return false;
        }

        return true;
    }
}
