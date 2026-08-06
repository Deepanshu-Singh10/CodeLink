class Solution {
    public int smallestNumber(int n, int t) {
        for(int i =n;i<=n+10;i++){
        int product = (i<10)?i:(i%10)*(i/10);
        if(product%t==0) return i;
        }
        return -1;
    }
}