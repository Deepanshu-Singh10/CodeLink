class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        int[] dp = new int[k];

        for (int num : nums) {
            int[] newDp = new int[k];

            int numMod = (int) (((long) num % k + k) % k);
            newDp[numMod]++;

            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newR = (int) (((long) r * num) % k);
                    newR = (newR % k + k) % k;
                    
                    newDp[newR] += dp[r];
                }
            }

            dp = newDp;

            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }

        return result;
    }
}