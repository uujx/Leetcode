class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            if (i == 0) dp[i][0] = grid[0][0];
            else dp[i][0] = dp[i - 1][0] + grid[i][0];
            
            for (int j = 1; j < grid[0].length; j++) {
                if (i == 0)
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }   
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
