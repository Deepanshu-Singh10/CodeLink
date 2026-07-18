class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int ans = gcd(nums[0],nums[nums.length-1]);
        return ans;
    }
    private int gcd(int a,int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a ;
    }
}