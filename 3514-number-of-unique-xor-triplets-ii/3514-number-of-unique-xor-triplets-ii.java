class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int count=0;
        boolean xor[] = new boolean[2048];
        boolean ans[] = new boolean[2048];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                xor[nums[i] ^ nums[j]] = true;
            }
        }
        for (int i = 0; i < 2048; i++) {
            if (xor[i]==true) {
                for(int j = 0;j<n;j++){
                  ans[i^nums[j]]=true;
                }
            }
        }
        for(int i = 0;i<2048;i++){
            if(ans[i]==true) count++;
        }
        return count;
    }
}