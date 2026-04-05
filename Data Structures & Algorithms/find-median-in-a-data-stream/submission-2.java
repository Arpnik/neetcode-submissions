class MedianFinder {
    PriorityQueue<Integer> firstHalf; // max
    PriorityQueue<Integer> secondHalf; // min
    int count;

    public MedianFinder() {
        secondHalf = new PriorityQueue<Integer>();
        firstHalf = new PriorityQueue<Integer>(Comparator.reverseOrder());
        count=0;
    }
    
    public void addNum(int num) {
        count++;
        if(count%2!=0){
            if(firstHalf.isEmpty() || (!secondHalf.isEmpty() && num < secondHalf.peek()))
                firstHalf.add(num);
            else {
                firstHalf.add(secondHalf.poll());
                secondHalf.add(num);
            }
        } else {
            if(!firstHalf.isEmpty() && num > firstHalf.peek())
                secondHalf.add(num);
            else{
                secondHalf.add(firstHalf.poll());
                firstHalf.add(num);
            }
        }

    }
    
    public double findMedian() {
        System.out.println(firstHalf);
        System.out.println(secondHalf);
        return (count%2==0)? ((firstHalf.peek()+secondHalf.peek())/2.0) : firstHalf.peek();    
    }
}
