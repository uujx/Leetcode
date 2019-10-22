class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, amount + 1);
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i)
                    f[i] = Math.min(f[i], f[i - coins[j]] + 1);
            }
        }
        return f[amount] > amount ? -1 : f[amount];
    }
}
