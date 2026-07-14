class Solution {
    int[][][] dp;
    int mod = 1000000007;

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num); 
        }
        
        dp = new int[n][max + 1][max + 1];
        for (int i = 0; i < n; i++) {
            for (int[] num : dp[i]) {
                Arrays.fill(num, -1);
            }
        }
        return helper(0, 0, 0, nums);
    }

    int helper(int index, int seq1, int seq2, int[] nums) {
        if (index == nums.length) {
            if (seq1 != seq2 || (seq1 == 0 && seq2 == 0)) {
                return 0;
            } else {
                return 1;
            }
        }

        if (dp[index][seq1][seq2] != -1) {
            return dp[index][seq1][seq2];
        }

        long take1 = helper(index + 1, gcd(nums[index], seq1), seq2, nums);
        long take2 = helper(index + 1, seq1, gcd(nums[index], seq2), nums);
        long skip = helper(index + 1, seq1, seq2, nums);

        long ans = (take1 % mod + take2 % mod + skip % mod) % mod;
        return dp[index][seq1][seq2] = (int) ans;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}