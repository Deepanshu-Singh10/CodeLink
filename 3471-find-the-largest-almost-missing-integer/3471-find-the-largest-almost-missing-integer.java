class Solution {
    public int largestInteger(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int fre[] = new int[max + 1];
        int n = nums.length;
        int size = n - k;
        for (int i = 0; i <= size; i++) {
            boolean visited[] = new boolean[max + 1];
            for (int j = i; j < k + i; j++) {
                int val = nums[j];
                if (!visited[val]) {
                    fre[val]++;
                    visited[val] = true;
                }
            }
        }

        int result = -1;
        for (int i = 0; i <= max; i++) {
            if (fre[i] == 1) {
                result = Math.max(result, i);
            }
        }

        return result;
    }
}