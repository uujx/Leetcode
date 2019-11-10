class Solution {
    int[][][] memo;
    int[][] grid;
    int N;
    
    public int cherryPickup(int[][] grid) {
        // 1. Greedy DP is not working
        
        // 2. DP Top-down
        this.grid = grid;
        this.N = grid.length;
        memo = new int[N][N][N];
        for (int[][] layer : memo) {
            for (int[] row : layer) 
                Arrays.fill(row, Integer.MIN_VALUE);
        }
        return Math.max(0, dp(0,0,0));
    }
    
    private int dp(int r1, int c1, int c2) {
        int r2 = r1 + c1 - c2;
        if (r1 == N || r2 == N || c1 == N || c2 == N || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return -99999;
        else if (r1 == N-1 && c1 == N-1)
            return grid[r1][c1];
        else if (memo[r1][c1][c2] != Integer.MIN_VALUE)
            return memo[r1][c1][c2];
        else {
            int res = grid[r1][c1];
            if (c1 != c2)
                res += grid[r2][c2];
            res += Math.max(Math.max(dp(r1, c1+1, c2+1), dp(r1+1, c1, c2+1)), Math.max(dp(r1, c1+1, c2), dp(r1+1, c1, c2)));
            memo[r1][c1][c2] = res;
            return res;
        }
    }
    
}
