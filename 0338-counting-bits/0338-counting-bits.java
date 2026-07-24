class Solution {
    public int[] countBits(int n) {
        int ans [] = new int [n+1];
        int count = 0;
        for(int i = 0;i<=n;i++){
            int curr = i;
            while(curr>0){
                if((curr&1)==1){
                count++;
                }
                curr>>=1;
            }
            ans[i] = count;
            count = 0;
        }
        return ans;
    }
}