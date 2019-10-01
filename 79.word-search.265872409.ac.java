class Solution {
    public boolean exist(char[][] board, String word) {
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    flag = backtracking(board, word, i, j, 0);
                    if (flag)
                        return flag;
                }
            }
        }
        
        return flag;
    }
    
    private boolean backtracking(char[][] board, String word, int i, int j, int position) {
        if(position == word.length()) return true;
        boolean flag = false;
        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && position < word.length() && board[i][j] == word.charAt(position)) {
            board[i][j] = '*';
            flag = backtracking(board, word, i+1, j, position+1) || backtracking(board, word, i-1, j, position+1) || backtracking(board, word, i, j+1, position+1) || backtracking(board, word, i, j-1, position+1);
            board[i][j] = word.charAt(position);
        } else
            return false;
        return flag;
    }
}
