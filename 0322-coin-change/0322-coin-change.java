class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i) {
                    int remain = i - coin;
                    if (dp[remain] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[remain] + 1);
                    }
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}