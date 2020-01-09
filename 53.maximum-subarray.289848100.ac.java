class Solution {
    public int maxSubArray(int[] nums) {
        /** DP
        if (nums.length < 1) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            if (dp[i] > max) max = dp[i];
        }
        return max;
        */
        
        
        // DP - O(1) space
        if (nums.length < 1) return 0;
        int dp = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            if (dp > max) max = dp;
        }
        return max;
        
    }
}
