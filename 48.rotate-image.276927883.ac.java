class Solution {
    public void rotate(int[][] matrix) {
        /** Non-in-place
        /*
        int[][] res = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length-1, k = 0; j >= 0 && k < matrix.length; j--, k++) {
                res[i][k] = matrix[j][i];
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                matrix[i][j] = res[i][j];
        }
        */
        
        
        /** In-place
        /* Clockwise rotate: reverse up and down, then swap the symmetric
        /*               OR  swap the symmetric, then reverse left and right
        /* Counterclockwise: reverse left and right, then swap the symmetric
        */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = tmp;
            }
        }
    }
}
