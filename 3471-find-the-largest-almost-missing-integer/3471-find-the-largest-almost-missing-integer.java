import java.util.*;

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
            Set<Integer> unique = new HashSet<>();
            for (int j = i; j < k + i; j++) {
                unique.add(nums[j]); 
            }
            for (int num : unique) {
                fre[num]++;
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