class Solution {
    public int maximumLengthSubstring(String s) {
        int fre[] = new int [26];
        int i=0,j=0;
        int size = 0;
        char [] ch = s.toCharArray();
        while(j<ch.length){
            fre[ch[j] - 'a']++;
                while(fre[ch[j] - 'a']>2){
                    fre[ch[i] - 'a']--;
                    i++;
                }
            size = Math.max(size,j-i+1);
            j++;
        }
        return size;
    }
}