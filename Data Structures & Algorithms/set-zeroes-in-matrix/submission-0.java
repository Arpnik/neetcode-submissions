class Solution {
    public void setZeroes(int[][] matrix) {
        if(Objects.isNull(matrix)|| matrix.length==0)
            return;
        //handle single column and row
        Set<Integer> zRows = new HashSet<Integer>();
        Set<Integer> zColumns = new HashSet<Integer>();
        int row, column;
        for(row=0;row<matrix.length;row++){
            for(column=0;column<matrix[0].length;column++){
                if(matrix[row][column]==0){
                    zRows.add(row);
                    zColumns.add(column);
                }
            }
        }

        for(row=0;row<matrix.length;row++){
            for(column=0;column<matrix[0].length;column++){
                if(zRows.contains(row)||zColumns.contains(column)){
                    matrix[row][column]=0;
                }
            }
        }

    }
}
