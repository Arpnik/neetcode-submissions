class Solution {
    private boolean searchHelper(int[][] matrix, int target, int start, int end, int row,  int col){
        if(start>end)
            return false;

        int mid = (start+end)/2;
        int rowIndex = mid/col;
        int colIndex = mid%col;
        if(matrix[rowIndex][colIndex]==target)
            return true;
    
        if(start==end)
            return false;

        if(matrix[rowIndex][colIndex]>target)
            return searchHelper(matrix, target, start, mid-1, row, col);
        
        return searchHelper(matrix, target, mid+1, end, row, col);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        return searchHelper(matrix, target, 0, ((row*col)-1), row, col);
    }
}
