class Solution {
    final int[][] co = new int[][]{{-1,-1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public void gameOfLife(int[][] board) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = countLive(board, i, j);
                if (board[i][j] == 1) {
                    if (count > 3 || count < 2) {
                        s.push(j);
                        s.push(i);
                    }
                } else if (count == 3) {
                    s.push(j);
                    s.push(i);
                }
            }
        }
        
        while (!s.isEmpty()) {
            int i = s.pop(), j = s.pop();
            board[i][j] = board[i][j] == 1 ? 0 : 1;
        }
    }
    
    private int countLive(int[][] board, int row, int col) {
        int count = 0;
        for (int i = 0; i < co.length; i++) {
            int newRow = row + co[i][0];
            int newCol = col + co[i][1];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) continue;
            if (board[newRow][newCol] == 1) count++;
        }
        return count;
    }
}
