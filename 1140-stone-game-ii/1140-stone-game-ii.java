class Solution {
    int[] suffixSum;
    int n;
    int[][] dp;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffixSum = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }

        dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dp(0, 1);
    }

    private int dp(int i, int M) {
        
        if (i >= n) {
            return 0;
        }

        if (i + 2 * M >= n) {
            return suffixSum[i];
        }

        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        int best = 0;

        for (int X = 1; X <= 2 * M; X++) {
            int nextM = Math.max(M, X);
            int currentTurn = suffixSum[i] - dp(i + X, nextM);
            best = Math.max(best, currentTurn);
        }

        dp[i][M] = best;
        return best;
    }
}