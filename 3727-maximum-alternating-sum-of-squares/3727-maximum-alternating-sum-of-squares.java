class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long sum = 0;

        for(int i = 0;i<n;i++){
            nums[i] = Math.abs(nums[i]);
        }
       Arrays.sort(nums);
    for(int i = 0; i < n ;i++){

        if(i < n/2){
            sum = sum - (long)nums[i] * nums[i];
        }
        else{
            sum = sum + (long)nums[i]* nums[i];
        }
    }
        return sum;
    }
}