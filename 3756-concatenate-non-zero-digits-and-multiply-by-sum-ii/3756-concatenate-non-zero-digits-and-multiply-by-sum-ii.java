class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        long mod = 1000000007;
        
        long[] pow10 = new long[m + 1];
        long[] prefNum = new long[m + 1];
        int[] prefSum = new int[m + 1];
        int[] nonZeroCount = new int[m + 1];
        
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) 
        pow10[i] = (pow10[i - 1] * 10) % mod;
        
        for (int i = 0; i < m; i++) {
            int digit = s.charAt(i) - '0';
            if (digit != 0) {
                prefNum[i + 1] = (prefNum[i] * 10 + digit) % mod;
                prefSum[i + 1] = prefSum[i] + digit;
                nonZeroCount[i + 1] = nonZeroCount[i] + 1;
            } else {
                prefNum[i + 1] = prefNum[i];
                prefSum[i + 1] = prefSum[i];
                nonZeroCount[i + 1] = nonZeroCount[i];
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            
            int count = nonZeroCount[r + 1] - nonZeroCount[l];
            if (count == 0) {
                ans[i] = 0;
                continue;
            }
            
            long sum = prefSum[r + 1] - prefSum[l];
            long x = (prefNum[r + 1] - (prefNum[l] * pow10[count]) % mod + mod) % mod;
            
            ans[i] = (int) ((x * sum) % mod);
        }
        
        return ans;
    }
}