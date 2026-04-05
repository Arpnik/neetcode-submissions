class Solution {

    private static void rotate(int[][] matrix, int startRow, int endRow, int startCol, int endCol) {
        if(startCol>=endCol || startRow >= endRow)
            return;

        System.out.println(startRow+" "+endRow+" "+startCol+" "+endCol);
        int temp, change = endRow-startRow;
        for(int i=0;i<change;i++){
            // System.out.println((startRow+change)+" "+(endRow-change)+" "+startCol+" "+(endCol-change));
            temp = matrix[startRow][startCol+i];
            matrix[startRow][startCol+i] = matrix[endRow-i][startCol];
            matrix[endRow-i][startCol] = matrix[endRow][endCol-i];
            matrix[endRow][endCol-i] = matrix[startRow+i][endCol];
            matrix[startRow+i][endCol] = temp;
        }

        rotate(matrix, startRow+1, endRow-1, startCol+1, endCol-1);

    }

    public void rotate(int[][] matrix) {
        int size = matrix.length;
        rotate(matrix, 0, size-1, 0, size-1);
    }
}
