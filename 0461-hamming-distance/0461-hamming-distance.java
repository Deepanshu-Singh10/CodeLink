class Solution {
    public int hammingDistance(int x, int y) {
        int count=0;
        int sub = x^y;
        while(sub>0){
            if((sub & 1)==1){
                count++;
            }
            sub>>=1;
        }
        return count;
    }
}