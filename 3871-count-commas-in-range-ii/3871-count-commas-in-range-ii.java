class Solution {
    public long countCommas(long n) {
        long power = 1000;
        long res = 0;
        while(power<=n){
            res+= n-power+1;
            power *= 1000;
        }
        return res;
    }
}