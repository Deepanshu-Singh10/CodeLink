class Solution {
    public boolean uniformArray(int[] nums) {
        int n = nums.length;
        int odd  = 0;
        int min = Integer.MAX_VALUE;
        for(int num:nums){
            min = Math.min(min,num);
        }
        if(min%2!=0)return true;
        else {
            for(int i =0;i<n;i++){
                if(nums[i]%2!=0) odd++;
            }
            if(odd!=0) return false;
        }
        return true;
    }
}