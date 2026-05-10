class Solution {
    public int trap(int[] height) {
        int[] rightMaxHeight = new int[height.length];
        int index, maxHeight = height[height.length-1], sum = 0, currentAmt = 0;
        for(index=height.length-1;index>=0;index--){
            maxHeight = (maxHeight<height[index])?height[index]:maxHeight;
            rightMaxHeight[index] = maxHeight;
        }

        //print heights
        // for(index=0; index<height.length; index++){
        //     System.out.print(rightMaxHeight[index]+" ");
        // }
        // System.out.println("");

        maxHeight = height[0];
        for(index=1; index<height.length-1; index++){
            if(maxHeight==0 || rightMaxHeight[index+1]==0){
                maxHeight = (maxHeight<height[index])?height[index]:maxHeight;
                continue;
            }
            
            currentAmt = (maxHeight<rightMaxHeight[index+1])?maxHeight:rightMaxHeight[index+1];
            currentAmt -= height[index];
            currentAmt = (currentAmt<0)?0:currentAmt;
            // System.out.println(index+" "+maxHeight+" "+currentAmt);
            sum+=currentAmt;
            maxHeight = (maxHeight<height[index])?height[index]:maxHeight;
        }


        return sum;
    }
}
