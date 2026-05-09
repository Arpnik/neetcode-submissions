class Solution {

    private boolean check(List<StringBuilder> board, int row, int col, int n){
        int i,j;
        //horizontally
        StringBuilder horizontalRow = board.get(row);
        for(i=0;i<n;i++){
            if(horizontalRow.charAt(i)=='Q')
                return false;
        }

        //vertically
        StringBuilder verticalRow;
        for(i=0;i<n;i++){
            verticalRow = board.get(i);
            if(verticalRow.charAt(col)=='Q')
                return false;
        }

        //upper left diagonal
        i=row-1;
        j=col-1;

        while(i>=0 && j>=0){
            horizontalRow = board.get(i);
            if(horizontalRow.charAt(j)=='Q')
                return false;
            i--;
            j--;
        }

        //bottom right diagonal
        i=row+1;
        j=col+1;

        while(i<n && j<n){
            horizontalRow = board.get(i);
            if(horizontalRow.charAt(j)=='Q')
                return false;
            i++;
            j++;
        }

        //upper right diagonal
        i=row-1;
        j=col+1;

        while(i>=0 && j<n){
            horizontalRow = board.get(i);
            if(horizontalRow.charAt(j)=='Q')
                return false;
            i--;
            j++;
        }

        //bottom left diagonal
        i=row+1;
        j=col-1;

        while(j>=0 && i<n){
            horizontalRow = board.get(i);
            if(horizontalRow.charAt(j)=='Q')
                return false;
            i++;
            j--;
        }

        return true;  
    }

    private void findPlacement(List<StringBuilder> board, int row, int n, List<List<String>> result){
        if(row>=n){
            List<String> solution = new ArrayList<String>();
            for(int i=0;i<n;i++){
                solution.add(board.get(i).toString());
            }
            result.add(solution);
            return;
        }

        StringBuilder horizontalRow = board.get(row);
        boolean solved = false;
        for(int i=0;i<n;i++){
            if(check(board, row, i, n)){
                horizontalRow.replace(i,i+1, "Q");
                findPlacement(board, row+1, n, result);
                horizontalRow.replace(i,i+1, ".");
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        if(n<=0)
            return new ArrayList<List<String>>();
        
        if(n==1){
            List<String> cell = new ArrayList<String>();
            cell.add("Q");
            List<List<String>> board = new ArrayList<List<String>>();
            board.add(cell);
        }

        int rowIndex, colIndex;
        List<List<String>> result = new ArrayList<List<String>>();
        List<StringBuilder> board = new ArrayList<StringBuilder>();
        StringBuilder row = new StringBuilder("");
        for(colIndex=0;colIndex<n;colIndex++){
            row.append(".");
        }
        for(rowIndex=0;rowIndex<n;rowIndex++){
            board.add(new StringBuilder(row));
        }

        findPlacement(board, 0, n, result);
        return result;
    }
}
