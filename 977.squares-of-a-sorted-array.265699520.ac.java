class Solution {
    public int[] sortedSquares(int[] A) {
        /** Sorting solution
        /*
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        
        Arrays.sort(A);
        return A;
        */
        
        
        // Two pointer
        int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0) 
            j++;
        int i = j - 1;
            
        int t = 0;
        int[] res = new int[N];
        while (i >= 0 && j < N) {
            if (A[i] * A[i] > A[j] * A[j]){
                res[t++] = A[j] * A[j];
                j++;
            } else {
                res[t++] = A[i] * A[i];
                i--;
            }
        }
        
        while (i >= 0) {
            res[t++] = A[i] * A[i];
            i--;
        }
        
        while (j < N) {
            res[t++] = A[j] * A[j];
            j++;
        }
        
        return res;
    }
}
