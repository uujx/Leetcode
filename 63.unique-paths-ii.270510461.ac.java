class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] F = new int[m][n];
        
        boolean meetObstacle = false;
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                meetObstacle = true;
            }
            F[0][j] = meetObstacle ? 0 : 1;
        }
        
        meetObstacle = false;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1){
                meetObstacle = true;
            } 
            F[i][0] = meetObstacle ? 0 : 1;
            for (int j = 1; j < n; j++) {
                F[i][j] = obstacleGrid[i][j] == 1 ? 0 : F[i-1][j] + F[i][j-1];
            }
        }
        
        return F[m-1][n-1];
    }
}
