class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate("",n,ans);
        return ans;
    }
    void generate(String curr,int n ,List<String>ans){
        if(curr.length()==2*n){
            if(isValid(curr)){
                ans.add(curr);
            }
            return;
        }
        generate(curr+"(",n,ans);
        generate(curr+")",n,ans);
    }
   boolean isValid(String curr) {
    int balancy = 0;
    for (char ch :curr.toCharArray()) {
        if (ch == '(') {
            balancy++;
        } else {
            balancy--;
        }
        if (balancy < 0) return false; 
    }
    return balancy == 0;
}
}