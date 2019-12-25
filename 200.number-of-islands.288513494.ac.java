class Solution {
    final int[][] co = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0' || visited[i][j]) continue;
                expandIsland(grid, visited, i, j);
                count++;
            }
        }
        
        return count;
    }
    
    private void expandIsland(char[][] grid, boolean[][] visited, int row, int col) {
        if (visited[row][col] || grid[row][col] == '0') return;
        
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int newRow = row + co[i][0];
            int newCol = col + co[i][1];
            if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) continue;
            
            expandIsland(grid, visited, newRow, newCol);
        }
    }
}
