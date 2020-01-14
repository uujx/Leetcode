class Solution {
    public int minFallingPathSum(int[][] A) {
        /* 1. first implementation
        int m = A.length, n = A.length;
        int[][] f = new int[m][n];
        int[][] dirs = new int[][]{{1, -1}, {1, 0}, {1, 1}};
        
        for (int j = 0; j < n; j++)
            f[0][j] = A[0][j];
        
        for (int i = 0; i < m-1; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    int r = i + dir[0], c = j + dir[1];
                    if (r >= 0 && r < m && c >= 0 && c < n) {
                        if (f[r][c] == 0 || f[i][j] + A[r][c] < f[r][c])
                            f[r][c] = f[i][j] + A[r][c];
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (f[m-1][j] < min)
                min = f[m-1][j];
        }
        
        return min;
        */
        
        // 2. 
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) 
                A[i][j] += Math.min(A[i-1][Math.max(j - 1, 0)], Math.min(A[i-1][j], A[i-1][Math.min(A.length-1, j+1)]));
        }
        return Arrays.stream(A[A.length - 1]).min().getAsInt();
    }
}
