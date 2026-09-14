class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder("^");
        for(char c: s.toCharArray()){
            sb.append("#").append(c);
        }
        sb.append("#$");
        String t = sb.toString();
        int centre = 0,right = 0;
        int n = t.length();
        int radius [] = new int [n];
        for(int i = 1;i<n-1;i++){
            int mirror = 2*centre-i;
            if(i<right){
                radius[i] = Math.min(right - i,radius[mirror]);
            }
            while(t.charAt(i + radius[i]+1)==t.charAt(i - radius[i]-1)){
                radius[i]++;
            }
            if(i+radius[i]>right){
                right = i+radius[i];
                centre = i;
            }
        }
        int currentLen = 0; int maxlen = 0;
        for(int i =1;i<n-1;i++){
            if(radius[i]>maxlen){
                currentLen = i;
                maxlen = radius[i];
            }
        }
        int start = (currentLen - maxlen)/2;
        return s.substring(start,start+maxlen);
    }
}