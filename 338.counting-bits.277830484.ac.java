class Solution {
    public int[] countBits(int num) {
        /** API
        int[] res = new int[num + 1];
        for (int i = 0; i < num+1; i++) {
            res[i] = Integer.bitCount(i);
        }
        
        return res;
        */
        
        // DP - dp[i] = i&1 + dp[i>>1] 
        // the last digit (1 or 0) + number of 1s in all other positions
        int[] dp = new int[num + 1];
        for (int i = 1; i < num+1; i++)
            dp[i] = (i & 1) + dp[i>>1];
        return dp;
    }
}
