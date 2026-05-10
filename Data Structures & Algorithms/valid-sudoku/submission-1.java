class Solution {
    private static boolean checkPlacement(char[][] board, int row, int col){
        int index, num = (board[row][col]-'0');
        // row check
        for(index=0;index<board.length;index++){
            // System.out.println(board[index][col]+" "+row);
            if(index!=row && (board[index][col]-'0')==num){
                return false;
            }
        }

        //column check
        for(index=0;index<board.length;index++){
            if(index!= col && (board[row][index]-'0')==num)
                return false;
        }

        //square check
        int blockRowBase = row/3;
        int blockColBase = col/3;
        for(int rowIndex = 0; rowIndex<3;rowIndex++){
            for(int colIndex = 0; colIndex<3;colIndex++){
                if((3*blockRowBase)+ rowIndex == row && (3*blockColBase) + colIndex == col)
                    continue;
                if((board[(3*blockRowBase)+ rowIndex][(3*blockColBase) + colIndex]-'0')==num){
                    // System.out.println("Box check failed");
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkHelper(char[][] board, int row, int col){
        if(row>=board.length)
            return true;
        
        if(col>=board.length)
            return checkHelper(board, row+1, 0);

        if(board[row][col]=='.')
            return checkHelper(board, row, col+1);

        boolean isSolvable = checkPlacement(board, row, col);
        System.out.println(row+" "+col+" "+isSolvable);
        if(!isSolvable)
            return isSolvable;
        
        return checkHelper(board, row, col+1);

    }

    public boolean isValidSudoku(char[][] board) {
        return checkHelper(board, 0, 0);
    }
}
