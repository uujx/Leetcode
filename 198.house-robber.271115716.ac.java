class Solution {
    /** Top down with memo
    /*
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, memo, nums.length-1);
    }
    
    private int dp(int[] nums, int[] memo, int n) {
        if (n < 0)
            return 0;
        if (memo[n] < 0)
            memo[n] = Math.max(dp(nums, memo, n-2) + nums[n], dp(nums,memo, n-1));
        return memo[n];
    }
    */
    
    // Buttom up 
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        int first = 0;
        int second = 0;
        for (int num : nums) {
            int tmp = second;
            second = Math.max(first + num, second);
            first = tmp;
        }
        return second;
    }
}
