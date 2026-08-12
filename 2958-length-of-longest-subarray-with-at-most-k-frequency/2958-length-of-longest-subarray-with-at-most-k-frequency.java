class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        int i = 0;
        int length = 0;

        for (int j = 0; j < nums.length; j++) {

            freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);

            while (freq.get(nums[j]) > k) {
                freq.put(nums[i], freq.get(nums[i]) - 1);
                i++;
            }

            length = Math.max(length, j - i + 1);
        }

        return length;
    }
}