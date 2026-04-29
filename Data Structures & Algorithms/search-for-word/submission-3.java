class Solution {
    private static boolean checkWord(char[][] board, String word, int row, int col, int index, boolean[][] visited){
        if(index >= word.length())
            return true;
        
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || visited[row][col])
            return false;
        
        if(word.charAt(index)!=board[row][col])
            return false;
        
        System.out.println(row+" "+col+" "+board[row][col]+" "+word.charAt(index));

        visited[row][col] = true;
        boolean result = false;
        result = checkWord(board, word, row+1, col, index+1, visited);
        if(result)
            return result;
        
        result = checkWord(board, word, row, col+1, index+1, visited);
        if(result)
            return result;
        System.out.println((row-1)+" "+col);
        result = checkWord(board, word, row-1, col, index+1, visited);
        System.out.println(result+" "+index);
        
        if(result)
            return result;
        result = checkWord(board, word, row, col-1, index+1, visited);
        System.out.println(index);
        visited[row][col] = false;
        return result;
    }

    public boolean exist(char[][] board, String word) {
        if(word==null || board==null || word.length()<=0)
            return false;

        int row, col;
        boolean result = false;
        for(row=0;row<board.length; row++){
            for(col=0;col<board[row].length;col++){
                if(board[row][col] == word.charAt(0)){
                    result = checkWord(board, word, row, col, 0, new boolean[board.length][board[0].length]);
                    if(result)
                        return result;
                }
            }
        }
        return result;
    }
}
