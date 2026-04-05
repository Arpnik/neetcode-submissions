class Solution {
    private void spiralHelper(int[][] matrix, int startRow, int endRow, int startCol, int endCol, List<Integer> result){
        if(endRow<startRow || endCol<startCol){
            return;
        }
        // System.out.println(startRow+" "+endRow+" "+startCol+" "+endCol);
        int i;

        if(startRow==endRow && startCol == endCol) {
            result.add(matrix[startRow][startCol]);
            return;
        }

        if(startRow==endRow){
            for(i=startCol;i<=endCol;i++){
                result.add(matrix[startRow][i]);
            }
            return;
        }

        if(startCol==endCol){
            for(i=startRow;i<=endRow;i++){
                result.add(matrix[i][endCol]);
            }
            return;
        }

        for(i=startCol;i<=endCol;i++){
            result.add(matrix[startRow][i]);
        }
        for(i=startRow+1;i<endRow;i++){
            result.add(matrix[i][endCol]);
        }
        for(i=endCol;i>=startCol;i--){
            result.add(matrix[endRow][i]);
        }
        for(i=endRow-1;i>startRow;i--){
            result.add(matrix[i][startCol]);
        }
        spiralHelper(matrix, startRow+1, endRow-1, startCol+1, endCol-1, result);

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        if(Objects.isNull(matrix)){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        spiralHelper(matrix,0,matrix.length-1, 0, matrix[0].length-1, result);
        return result;
    }
}
