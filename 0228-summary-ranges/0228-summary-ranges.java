class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> result = new ArrayList<>();
        if (n == 0) return result;

        int start = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] != nums[i] + 1) {
                if (start == i) {
                    result.add(String.valueOf(nums[start])); 
                } else {
                    result.add(nums[start] + "->" + nums[i]);
                }
                start = i + 1;
            }
        }

        if (start == n - 1) {
            result.add(String.valueOf(nums[start]));
        } else {
            result.add(nums[start] + "->" + nums[n - 1]);
        }

        return result;
    }
}