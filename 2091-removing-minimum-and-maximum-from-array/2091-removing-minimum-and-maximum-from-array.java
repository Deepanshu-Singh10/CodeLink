class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int indexForMax = 1;
        int indexForMin = 1;
        if (n == 1)
            return 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                indexForMax = i + 1;
            }  if (nums[i] < min) {
                min = nums[i];
                indexForMin = i + 1;
            }
        }
         int l = Math.min(indexForMin,indexForMax);
         int r = Math.max(indexForMin,indexForMax);
        
        int option1 = r;
        int option2 = n-l+1;
        int option3 = l+(n-r+1);

        return Math.min(option1,Math.min(option2,option3));
    }
}