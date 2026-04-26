class Solution {
    private static int findPathHelper2(int row, int col, int m, int n){
        if(row>=m || col>=n || col<0 || row<0)
            return 0;
        if(row==m-1 && col==n-1)
            return 1;
        
        return findPathHelper2(row+1, col, m, n) + findPathHelper2(row, col+1, m, n);
        
    }

    private static int findPathHelper(int m, int n){
        int[][] matrix = new int[m][n];
        int row=m-1, col=n-1;
        matrix[m-1][n-1] = 1;
        while(row>=0){
            while(col>=0){
                if(row+1<m){
                    matrix[row][col] += matrix[row+1][col];
                }
                if(col+1<n){
                    matrix[row][col] += matrix[row][col+1];
                }
                col--;
            }
            col=n-1;
            row--;
        }

        return matrix[0][0];
        
    }

    public int uniquePaths(int m, int n) {
        if(m<=0 || n<=0)
            return 0;
        return findPathHelper(m, n);
    }
}
