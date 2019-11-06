class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        bfs(board, new boolean[board.length][board[0].length], click[0], click[1]);
        return board;
    }
    
    private void bfs(char[][] board, boolean[][] revealed, int i, int j) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0)
            return;
        
        if (revealed[i][j])
            return;
        
        int count = checkNeighbor(board, i, j);
        if (count == 0) {
            board[i][j] = 'B';
            revealed[i][j] = true;
            
            bfs(board, revealed, i-1, j);
            bfs(board, revealed, i+1, j);
            bfs(board, revealed, i, j-1);
            bfs(board, revealed, i, j+1);
            bfs(board, revealed, i-1, j-1);
            bfs(board, revealed, i-1, j+1);
            bfs(board, revealed, i+1, j-1);
            bfs(board, revealed, i+1, j+1);
        }
        else {
            board[i][j] = Character.forDigit(count, 10);
            revealed[i][j] = true;
        }
        
    }
    
    private int checkNeighbor(char[][] board, int row, int col) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                int r = row + i, c = col + j;
                if (r < 0 || r >= board.length || c < 0 || c < 0 || c >= board[0].length) continue;
                if (board[r][c] == 'M' || board[r][c] == 'X') count++;
            }
        }
        return count;
    }
}
