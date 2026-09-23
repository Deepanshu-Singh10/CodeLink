class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalSum = 0;
        for(int num:nums){
            totalSum += num;
        }
        int left = 0;
        int target = totalSum - x;
        if(target<0) return -1;
        int len = -1;
        int sum= 0;
        for(int right = 0;right<n;right++){
            sum+= nums[right];
            while(sum>target){
                sum-=nums[left];
                left++;
            }
            if(sum==target){
                len = Math.max(len,right-left+1);
            }
        }
        if(len==-1) return -1;
        return n - len;
    }
}