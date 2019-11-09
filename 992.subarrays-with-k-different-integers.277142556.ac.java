class Solution {
    /** 1. at most k - at most k-1
    /*
    public int subarraysWithKDistinct(int[] A, int K) {
        // #(Exact K distinct elements) = #(at most K) - #(at most K-1)
        return atMostK(A, K) - atMostK(A, K - 1);
    }
    
    private int atMostK(int[] A, int K) {
        int left = 0, res = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for (int right = 0; right < A.length; right++) {
            if (count.getOrDefault(A[right], 0) == 0)
                K--;
            count.put(A[right], count.getOrDefault(A[right], 0) + 1);
            
            // Shrink sliding window
            while (K < 0) {
                count.put(A[left], count.get(A[left]) - 1);
                if (count.get(A[left]) == 0)
                    K++;
                left++;
            }
            
            res += right - left + 1;
        }
        return res;
    }
    */
    
    
    // 2. count += 1 + prefix
    public int subarraysWithKDistinct(int[] A, int K) {
        int[] count = new int[A.length + 1];
        int res = 0;
        int size = 0; // size of distinct elements
        int head = 0;
        int old = 0; // prefix = head - old
        
        for (int tail = 0; tail < A.length; tail++) {
            // Add A[tail] & change state
            if (count[A[tail]] == 0)
                size++;
            count[A[tail]]++;
            
            // size > k -> move head until size = k
            while (size > K) {
                count[A[head]]--;
                if (count[A[head]] == 0) {
                    size--;
                    old = head + 1; // !!!
                }
                head++;
            }
            
            // size == k -> count res by prefix+1
            if (size == K) {
                while (count[A[head]] > 1) { // count prefix
                    count[A[head]]--;
                    head++;
                }
                res += head - old + 1;
            }
        }
        
        return res;
    }
    
}
