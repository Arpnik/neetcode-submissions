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

// (3,10), (9,11), (11,40)
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(Objects.isNull(intervals))
            return 0;

        if(intervals.size()<=1){
            return intervals.size();
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b){
                if(a.start!= b.start)
                    return a.start - b.start;
                return a.end - b.end;
            }
        });

        // for(int i=0;i<intervals.size();i++){
        //     System.out.println(intervals.get(i).start);
        // }
        int count = 0, max=1;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(Interval current: intervals){
            // System.out.println(current.start+" "+current.end);
            // System.out.println(heap);
            
            if(!heap.isEmpty() && heap.peek() <= current.start){
                heap.poll();
            } else {
                count++;
            }

            heap.add(current.end);
            max = (max<count)?count:max;
        }

        return max;
    }
}
