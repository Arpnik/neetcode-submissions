class Solution {
    public void setZeroes(int[][] matrix) {
        if(Objects.isNull(matrix))
            return;
        int row,column;
        boolean firstRow=false, firstColumn=false;
        for(row=0;row<matrix.length;row++){
            if(matrix[row][0]==0){
                firstColumn=true;
                // matrix[row][0]=1;
            }
        }

        for(column=0;column<matrix[0].length;column++){
            if(matrix[0][column]==0){
                firstRow=true;
                // matrix[0][column]=1;
            }
        }


        System.out.println(firstRow+" "+firstColumn);
        for(row=1;row<matrix.length;row++){
            for(column=1;column<matrix[0].length;column++){
                if(matrix[row][column]==0){
                    System.out.println("here");
                    matrix[0][column]=0;
                    matrix[row][0]=0;
                }
            }
        }

        for(column=1;column<matrix[0].length;column++){
            if(matrix[0][column]==0){
                for(row=0;row<matrix.length;row++){
                    matrix[row][column]=0;
                }
            }
        }

        for(row=1;row<matrix.length;row++){
            if(matrix[row][0]==0){
                for(column=0;column<matrix[0].length;column++){
                    matrix[row][column]=0;
                }
            }
        }

        if(firstColumn){
            for(row=0;row<matrix.length;row++){
                matrix[row][0]=0;
            }
        }

        if(firstRow){
            for(column=0;column<matrix[0].length;column++){
                matrix[0][column]=0;
            }
        }
    }
}
