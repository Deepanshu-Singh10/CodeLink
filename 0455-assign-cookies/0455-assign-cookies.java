class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int content= 0;
        int cookie =0;
        while(content<g.length&&cookie<s.length){
            if(g[content]<=s[cookie]){
                content++;
            }
            cookie++;
        }
        return content;
    }
}