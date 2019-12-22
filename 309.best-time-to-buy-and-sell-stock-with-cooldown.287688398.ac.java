class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int s1 = 0, s2 = -prices[0], s3 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            int tmp = s3;
            s3 = s2 + prices[i];
            s2 = Math.max(s2, s1 - prices[i]);
            s1 = Math.max(s1, tmp);
        }
        return Math.max(s1, s3);
    }
}
