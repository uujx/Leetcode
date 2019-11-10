class Solution {
    private int m;
    private int n;
    private final int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}}; 
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
            
        m = matrix.length;
        n = matrix[0].length;
        int max = 0;
        int[][] memo = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, memo, i, j));
            }
        }
        
        return max;
    }
    
    // Find the length of the longest increasing path starting from (i,j)
    private int dfs(int[][] matrix, int[][] memo, int i, int j) {
        if (memo[i][j] != 0) return memo[i][j];
        
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j])
                continue;
            max = Math.max(max, 1 + dfs(matrix, memo, x, y));
        }
        memo[i][j] = max;
        return max;
    }
}
