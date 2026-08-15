class Solution {
    public int longestSubsequence(int[] nums) {
        int result =0;
        boolean hasNonZero = false;
        for(int num:nums){
            result^=num;
            if(num!=0) hasNonZero = true;
        }
        if(result!=0) return nums.length;
        if(hasNonZero) return nums.length-1;
        return 0;
    }
}