class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        
        // find the row
        int i = 0;
        for (; i < m && target >= matrix[i][0]; i++) {}
        i--;
        
        if (i < 0) return false;
        
        // binary search 
        int left = 0, right = n-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[i][mid] == target)
                return true;
            else if (matrix[i][mid] < target)
                left = mid + 1;
            else 
                right = mid - 1;
        }
        return false;
    }
}
