class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /** First solution
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (matrix[i][0] > target) continue;
            int l = 0, r = matrix[0].length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (matrix[i][mid] == target) return true;
                else if (matrix[i][mid] < target) l = mid + 1;
                else r = mid - 1;
            }
        }
        return false;
        */
        
        // Start from top-right corner, try to rule out row or column
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (true) {
            if (i == m || j < 0) return false;
            if (target == matrix[i][j]) return true;
            else if (target < matrix[i][j]) j--;
            else i++;
        }
    }
}
