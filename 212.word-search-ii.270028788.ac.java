class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        
        for (String word : words) {
            label:
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    
                    if (board[i][j] == word.charAt(0)) {
                        boolean[][] used = new boolean[board.length][board[0].length];
                        if (backtracking(board, word, used, i, j, 0)) {
                            res.add(word);  
                            break label;
                        }
                    }
                        
                }
            }
            
        }
        return res;
    }
    
    private boolean backtracking(char[][] board, String word, boolean[][] used, int row, int col, int index) {
        if (index == word.length())
            return true;
        if (row < 0 || row == board.length || col < 0 || col == board[0].length)
            return false;
        
        boolean flag;
        if (!used[row][col] && board[row][col] == word.charAt(index)) {
            used[row][col] = true;
             flag =  backtracking(board, word, used, row-1, col, index+1) || backtracking(board, word, used, row+1, col, index+1) || backtracking(board, word, used, row, col-1, index+1) || backtracking(board, word, used, row, col+1, index+1);
            used[row][col] = false;
        } else 
            return false;
        
        return flag ? true : false;
        
    }
}
