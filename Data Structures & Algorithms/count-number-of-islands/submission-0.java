class Solution {
    private static void bfs(char[][] grid, boolean[][] visited, int row, int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length)
            return;

        if(visited[row][col])
            return;
        
        visited[row][col] = true;

        if(grid[row][col]=='0')
            return;
        
        bfs(grid, visited, row+1, col);
        bfs(grid, visited, row, col+1);
        bfs(grid, visited, row-1, col);
        bfs(grid, visited, row, col-1);
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length <= 0)
            return 0;
        int row, col;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(row=0;row<grid.length;row++){
            for(col=0;col<grid[row].length;col++){
                visited[row][col] = false;
            }
        }

        int count = 0;
        for(row=0;row<grid.length;row++){
            for(col=0;col<grid[row].length;col++){
                if(grid[row][col]=='1' && !visited[row][col]){
                    bfs(grid, visited, row, col);
                    count++;
                }
            }
        }

        return count;
    }
}
